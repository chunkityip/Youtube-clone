package com.programming.techie.youtubeclone.service;

import com.amazonaws.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class S3Service implements FileService {

    @Override
    public String uploadFile(MultipartFile file) {
        //Upload file to AWS

        //Prepare a Key
        var filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        return null;
    }
}
