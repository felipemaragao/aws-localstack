package br.com.qualify.awslocalstack.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3ClientConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(S3ClientConfiguration.class);


    @Value("${aws.s3.endpoint-url}")
    private String endpointUrl;

    @Value("${profile}")
    private String profile;

    @Value("${s3.bucketName}")
    private String bucketName;

    private  AmazonS3 amazonS3;


    @Bean
    AmazonS3 amazonS3() {


        if (profile != null && profile.equals("dev")) {

            LOGGER.info("Instânciando S3 AWS em LocalStack");

            amazonS3 = AmazonS3ClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpointUrl, "us-east-1"))
                    .withPathStyleAccessEnabled(true).build();

        } else {

            LOGGER.info("Instânciando S3 em AWS");


            amazonS3 = AmazonS3ClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpointUrl, "us-east-1"))
                    .build();


        }
//        createBucket();
        return amazonS3;
    }

//    private void createBucket(){
//        if (!this.amazonS3.doesBucketExistV2(bucketName)){
//            LOGGER.info("Criando Bucket");
//            amazonS3.createBucket(bucketName);
//        } else {
//            LOGGER.info("Já existe Bucket");
//        }
//    }


}
