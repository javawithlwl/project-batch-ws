package com.lwl.common.util;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;

import java.io.File;
import java.nio.file.Path;

public class AwsS3Service {

  private AmazonS3 s3client;
  private static AwsS3Service awsS3Service = null;

  private AwsS3Service() {
    AWSCredentials credentials = new BasicAWSCredentials(ConnectionUtil.getValue("aws.accesskey"), ConnectionUtil.getValue("aws.secretkey"));
    AWSStaticCredentialsProvider obj = new AWSStaticCredentialsProvider(credentials);
    s3client = AmazonS3ClientBuilder.standard()
        .withCredentials(obj)
        .withRegion(ConnectionUtil.getValue("aws.region"))
        .build();
  }
  public  void uploadFile(String bucketName,String key, File file){
    s3client.putObject(bucketName, key, file);
  }
  public String downloadImage(String bucketName,String key){
    GetObjectRequest request = new GetObjectRequest(bucketName,key);
    String tmpDir = System.getProperty("java.io.tmpdir");
    String fileName = key.substring(key.lastIndexOf("/"));
    Path path = Path.of(tmpDir,fileName);
    File destinationFile = new File(path.toString());
    s3client.getObject(request,destinationFile);
    return destinationFile.getAbsolutePath();
  }

  public static AwsS3Service getInstance(){

        if(awsS3Service == null){
            synchronized (AwsS3Service.class){
                awsS3Service = new AwsS3Service();
            }
        }
        return awsS3Service;
  }

}
