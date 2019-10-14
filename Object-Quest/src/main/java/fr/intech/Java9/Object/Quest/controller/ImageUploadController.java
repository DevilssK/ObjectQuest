package fr.intech.Java9.Object.Quest.controller;

import fr.intech.Java9.Object.Quest.service.AppRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"/image"})
public class ImageUploadController {

    AppRequestHandler appRequestHandler;

    public ImageUploadController(AppRequestHandler appRequestHandler) {
        this.appRequestHandler = appRequestHandler;
    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String getUploadedImage(@RequestParam("file") MultipartFile file )  throws Exception {

        appRequestHandler.sendToApi(file.getInputStream());

    return  "Image sent";
    }
}