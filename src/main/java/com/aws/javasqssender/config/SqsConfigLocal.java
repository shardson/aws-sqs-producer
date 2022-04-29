package com.aws.javasqssender.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfigLocal {

    private final AmazonSQS sqsClient;
    private static final Logger LOG = LoggerFactory.getLogger(SqsConfigLocal.class);
    //Definição do Client do SQS
    public SqsConfigLocal(){
        this.sqsClient = AmazonSQSClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", Regions.SA_EAST_1.getName()))
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();

        LOG.info("Client Criado!!!");

    }

    @Bean
    public AmazonSQS sqsClient(){
        return this.sqsClient;
    }

}
