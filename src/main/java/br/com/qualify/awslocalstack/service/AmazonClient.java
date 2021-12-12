//package br.com.qualify.awslocalstack.service;
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.client.builder.AwsClientBuilder;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.PostConstruct;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Date;
//
//@Service
//public class AmazonClient {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(AmazonClient.class);
//
//    private AmazonS3 s3client;
//    @Value("${s3.endpointUrl}")
//    private String endpointUrl;
//    @Value("${s3.bucketName}")
//    private String bucketName;
//    @Value("${s3.accessKeyId}")
//    private String accessKeyId;
//    @Value("${s3.secretKey}")
//    private String secretKey;
//    @Value("${s3.region}")
//    private String region;
//
//    @Value("${profile}")
//    private String profile;
//
//    @PostConstruct
//    private void initializeAmazon() {
//        AWSCredentials credentials
//                = new BasicAWSCredentials(this.accessKeyId, this.secretKey);
//
//        if (profile.equals("dev")){
//            LOGGER.info("AWS LocalStack");
//
//            AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(endpointUrl,
//                    Regions.US_EAST_1.getName());
//
//            this.s3client = AmazonS3ClientBuilder
//                    .standard()
//                    .withEndpointConfiguration(endpointConfiguration)
//                    .withPathStyleAccessEnabled(true).build();
//            createBucket();
//
//
//        } else {
//            this.s3client = AmazonS3ClientBuilder
//                    .standard()
//                    .withRegion(region)
//                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
//                    .build();
//
//        }
//
//
//    }
//
//    public String uploadFile(MultipartFile multipartFile)
//            throws Exception {
//        String fileUrl = "";
//        File file = convertMultiPartToFile(multipartFile);
//        String fileName = generateFileName(multipartFile);
//        fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
//        uploadFileTos3bucket(fileName, file);
//        file.delete();
//        return fileUrl;
//    }
//    public String deleteFileFromS3Bucket(String fileUrl) {
//        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
//        s3client.deleteObject(bucketName, fileName);
//        return "Successfully deleted";
//    }
//    private void uploadFileTos3bucket(String fileName, File file) {
//        s3client.putObject(bucketName, fileName, file);
//    }
//    private File convertMultiPartToFile(MultipartFile file)
//            throws IOException {
//        File convFile = new File(file.getOriginalFilename());
//        FileOutputStream fos = new FileOutputStream(convFile);
//        fos.write(file.getBytes());
//        fos.close();
//        return convFile;
//    }
//    private String generateFileName(MultipartFile multiPart) {
//        return new Date().getTime() + "-" +   multiPart.getOriginalFilename().replace(" ", "_");
//    }
//    private void createBucket(){
//        if (!this.s3client.doesBucketExistV2(bucketName)){
//            LOGGER.info("Criando Bucket");
//            s3client.createBucket(bucketName);
//        } else {
//            LOGGER.info("Já existe Bucket");
//        }
//    }
//
//}
