package com.lwl.sc.di.xml;

import com.lwl.common.util.AwsS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AwsS3Service awsS3Service;
}
