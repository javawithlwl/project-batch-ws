package com.lwl.sc.di.ws;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletService {

  private List<AppUser> userList;
  private List<Transactions> txnList;
  private List<Wallet> walletList;

  @Autowired
  private JsonReaderUtil jsonReaderUtil;

  public WalletService() {
    this.userList = new ArrayList<>();
    this.txnList = new ArrayList<>();
    this.walletList = new ArrayList<>();
  }

  @PostConstruct
  public void init() {
    TypeReference<List<Wallet>> walletType = new TypeReference<List<Wallet>>() {};
    TypeReference<List<AppUser>> appUserType = new TypeReference<List<AppUser>>() {};
    TypeReference<List<Transactions>> transactionType = new TypeReference<List<Transactions>>() {};
    this.userList.addAll(jsonReaderUtil.getData("/user_data.json", appUserType));
    this.txnList.addAll(jsonReaderUtil.getData("/txn_data.json",transactionType));
    this.walletList.addAll(jsonReaderUtil.getData("/wallet_data.json", walletType));
    updateWalletBalance();
  }

  public List<Wallet> getWallets(){
    return this.walletList;
  }
  public List<Transactions> getTransactions(String mobile){
        return txnList.stream()
            .filter(t->t.getFromMobile().equals(mobile) || t.getToMobile().equals(mobile))
            .collect(Collectors.toList());
  }
  public List<Transactions> getTransaction(int month){
    return txnList.stream()
        .filter(t->t.getDate().getMonth().getValue() == month)
        .collect(Collectors.toList());
  }

  private void updateWalletBalance(){
        for(Transactions t:txnList){
            String fromMobile = t.getFromMobile();
            String toMobile = t.getToMobile();
            Wallet fromWallet = getWallet(fromMobile);
            Wallet toWallet = getWallet(toMobile);
            fromWallet.setBalance(fromWallet.getBalance()-t.getAmount());
            toWallet.setBalance(toWallet.getBalance()+t.getAmount());
        }
  }

  private Wallet getWallet(String mobile) {
      for(Wallet wallet:walletList){
          if(wallet.getMobile().equals(mobile)){
            return wallet;
          }
      }
      throw new IllegalArgumentException("Wallet is not found for given mobile number "+mobile);
  }
}
