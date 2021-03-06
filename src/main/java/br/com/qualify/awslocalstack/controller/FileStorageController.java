//package br.com.qualify.awslocalstack.controller;
//
//import br.com.qualify.awslocalstack.service.AmazonClient;
//import com.amazonaws.services.s3.AmazonS3;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/api/storage/")
//public class FileStorageController {
//
//    private AmazonClient amazonClient;
//
//
//
//    @Autowired
//    FileStorageController(AmazonClient amazonClient) {
//        this.amazonClient = amazonClient;
//    }
//
//    @PostMapping("/uploadFile")
//    public String uploadFile(@RequestPart(value = "file") MultipartFile file) throws Exception {
//        return this.amazonClient.uploadFile(file);
//    }
//    @DeleteMapping("/deleteFile")
//    public String deleteFile(@RequestPart(value = "url") String fileUrl) throws Exception {
//        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
//    }
//}
