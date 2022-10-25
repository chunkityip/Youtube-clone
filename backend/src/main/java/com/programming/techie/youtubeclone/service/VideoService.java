package com.programming.techie.youtubeclone.service;


import com.programming.techie.youtubeclone.model.Video;
import com.programming.techie.youtubeclone.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final S3Service s3Service;
    private final VideoRepository videoRepository;

    // Upload file to AWS S3
    public void uploadVideo(MultipartFile multipartFile) {
        // Save Video Data to Database
        String videoUrl = s3Service.uploadFile(multipartFile);
        var video = new Video();
        video.setVideoUrl(videoUrl);

        //save the video into mongoDB
        videoRepository.save(video);
    }

}
