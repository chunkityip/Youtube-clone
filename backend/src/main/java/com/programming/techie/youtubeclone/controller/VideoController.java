package com.programming.techie.youtubeclone.controller;

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
public class VideoController {

    public void uploadVideo(@RequestParam("file")MultipartFile file) {

    }
}
