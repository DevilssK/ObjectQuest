package fr.intech.Java9.Object.Quest;


import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import fr.intech.Java9.Object.Quest.model.RequestResponse;
import fr.intech.Java9.Object.Quest.service.ObjectRecognition;
import fr.intech.Java9.Object.Quest.service.ResponseHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class ItemRecognitionTests {

    @Autowired
    VisionApi visionApi;
    @Autowired
    ResponseHandler responseHandler;

    @Autowired
    ObjectRecognition objectRecognition;

    @Test
    public  void objectExist() throws Exception{

//        BatchAnnotateImagesResponse res = visionApi.sendRequest(getClass().getResourceAsStream("/mouse.jpg"));
//        RequestResponse response = responseHandler.getResponseFromApi(res);
//
//       objectRecognition.reconizeObject(response);

    }




}
