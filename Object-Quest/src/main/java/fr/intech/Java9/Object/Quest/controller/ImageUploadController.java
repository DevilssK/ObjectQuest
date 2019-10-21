package fr.intech.Java9.Object.Quest.controller;

import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import fr.intech.Java9.Object.Quest.VisionApi;
import fr.intech.Java9.Object.Quest.model.RequestResponse;
import fr.intech.Java9.Object.Quest.model.database.Item;
import fr.intech.Java9.Object.Quest.model.database.User;
import fr.intech.Java9.Object.Quest.model.database.UserRepository;
import fr.intech.Java9.Object.Quest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"/image"})
public class ImageUploadController {

    @Autowired
    AppRequestHandler appRequestHandler;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ScoreManager scoreManager;
    @Autowired
    ResponseHandler responseHandler;

    @Autowired
    ObjectRecognition objectRecognition;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String getUploadedImage(@RequestParam("file") MultipartFile file, @RequestParam int userId)  throws Exception {
        BatchAnnotateImagesResponse res = appRequestHandler.sendToApi(file.getInputStream());
        RequestResponse response = responseHandler.getResponseFromApi(res);
        Item foundObject = objectRecognition.reconizeObject(response);

        System.out.println(foundObject);

        if(foundObject.getItemName() == null){
            System.out.println("not Found");
            return "L'object ne correspond pas";
            }else{

           return String.valueOf(foundObject.getPoint());

        }


   //  Item foundObject = objectRecognition.reconizeObject(response);
//        if(foundObject.getObjectName() == null){
//            System.out.println("not Found");
//            return "L'object ne correspond pas";
        //}

//        userRepository.save(new User("Axel"));
//        User user = userRepository.findByUserName("Axel").get(0);
//
//
//
//        scoreManager.updateScoreAndFoundObjects(user, foundObject);
//        System.out.println("founded");
////+foundObject.getObjectName();
//    return  "Object trouvé : ";
//
//        scoreManager.updateScoreAndFoundObjects(user, foundObject);
//        System.out.println("found");
        //+foundObject.getObjectName();
   }
    //}
}