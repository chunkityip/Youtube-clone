package com.programming.techie.youtubeclone.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service implements FileService {

    public static final String BUCKET_NAME = "youtube-demo-cky";
    private final AmazonS3Client amazonS3Client;

    //Upload file to AWS
    @Override
    public String uploadFile(MultipartFile file) {
        //Prepare a Key
        var filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        var key = UUID.randomUUID().toString() + "." + filenameExtension;

        var metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        try {
            //put object to s3 bucket : the name I am using in s3 is call youtube-demo-cky
            amazonS3Client.putObject(BUCKET_NAME, key, file.getInputStream(), metadata);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR ,
                    "Showing an exception when trying to upload a video");
        }

        //Adding public video read access control list
        amazonS3Client.setObjectAcl(BUCKET_NAME, key , CannedAccessControlList.PublicRead);

        return amazonS3Client.getResourceUrl(BUCKET_NAME, key);
    }
}
