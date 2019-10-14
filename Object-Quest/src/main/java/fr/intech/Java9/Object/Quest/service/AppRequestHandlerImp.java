package fr.intech.Java9.Object.Quest.service;

import fr.intech.Java9.Object.Quest.VisionApi;
import fr.intech.Java9.Object.Quest.VisionApiImp;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class AppRequestHandlerImp implements AppRequestHandler {

    private VisionApi visionApi;
    private ResponseHandlerImp responseHandler;

    public AppRequestHandlerImp(){}

    public AppRequestHandlerImp(VisionApiImp visionApi, ResponseHandlerImp responseHandler){
        this.visionApi = visionApi;
        this.responseHandler = responseHandler;
    }

    public void sendToApi(InputStream stream)throws Exception{

        responseHandler.getResponseFromApi(visionApi.sendRequest(stream));
    }

}
