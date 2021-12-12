//package br.com.qualify.awslocalstack.controller;
//
//import br.com.qualify.awslocalstack.service.model.DownloadedResource;
//import br.com.qualify.awslocalstack.service.StorageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import lombok.extern.log4j.Log4j2;
//
//@Controller
//@Log4j2
//public class FileDownloadController {
//
//    private final StorageService storageService;
//
//    public FileDownloadController(StorageService storageService) {
//        this.storageService = storageService;
//    }
//
//    @GetMapping("/download")
//    public ResponseEntity<Resource> download(String id) {
//        DownloadedResource downloadedResource = storageService.download(id);
//
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + downloadedResource.getFileName())
//                .contentLength(downloadedResource.getContentLength()).contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(new InputStreamResource(downloadedResource.getInputStream()));
//    }
//}
