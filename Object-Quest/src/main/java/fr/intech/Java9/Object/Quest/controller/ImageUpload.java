package fr.intech.Java9.Object.Quest.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping({"/image"})
public class ImageUpload {

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String getUploadedImage(@RequestParam("file") MultipartFile file )  throws IOException {

    return  "Image sent";
    }
}