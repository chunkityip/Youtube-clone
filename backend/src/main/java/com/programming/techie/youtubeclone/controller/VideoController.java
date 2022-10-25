package com.programming.techie.youtubeclone.controller;

import com.programming.techie.youtubeclone.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @RestController is a specialized version of the controller.
 * It includes the @Controller and @ResponseBody annotations,
 * and as a result, simplifies the controller implementation:
 */
@RestController
/**
 * Annotation for mapping web requests onto methods
 * in request-handling classes with flexible method signatures.
 */
@RequestMapping("api/videos")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;
    public void uploadVideo(@RequestParam("file")MultipartFile file) {
        videoService.uploadVideo(file);
    }
}
