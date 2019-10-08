package fr.intech.Java9.Object.Quest.controller;

import fr.intech.Java9.Object.Quest.service.AppRequestHandlerImp;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"/image"})
public class ImageUpload {


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String getUploadedImage(@RequestParam("file") MultipartFile file )  throws Exception {


        AppRequestHandlerImp appRequestHandlerImp =new AppRequestHandlerImp();
        appRequestHandlerImp.SendToApi(file.getInputStream());

    return  "Image sent";
    }
}