package br.com.qualify.awslocalstack.service;

import br.com.qualify.awslocalstack.service.model.DownloadedResource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    String upload(MultipartFile multipartFile);

    DownloadedResource download(String id);
}
