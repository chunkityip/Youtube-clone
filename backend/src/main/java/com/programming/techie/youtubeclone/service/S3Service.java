package com.programming.techie.youtubeclone.service;

import org.springframework.web.multipart.MultipartFile;

public class S3Service implements FileService {

    @Override
    public String uploadFile(MultipartFile file) {
        //Upload file to AWS
        return null;
    }
}
