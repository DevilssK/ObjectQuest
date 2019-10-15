package fr.intech.Java9.Object.Quest.service;

import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import fr.intech.Java9.Object.Quest.VisionApi;
import fr.intech.Java9.Object.Quest.VisionApiImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class AppRequestHandlerImp implements AppRequestHandler {

    @Autowired
    private VisionApi visionApi;
    @Autowired
    private ResponseHandler responseHandler;


    public BatchAnnotateImagesResponse sendToApi(InputStream stream)throws Exception{

        BatchAnnotateImagesResponse apiResponse = visionApi.sendRequest(stream);
        responseHandler.getResponseFromApi(apiResponse);
        return apiResponse;
    }

}
