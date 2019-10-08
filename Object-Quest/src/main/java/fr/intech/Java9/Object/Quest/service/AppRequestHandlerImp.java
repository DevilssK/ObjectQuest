package fr.intech.Java9.Object.Quest.service;

import fr.intech.Java9.Object.Quest.VisionApi;
import fr.intech.Java9.Object.Quest.VisionApiImp;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class AppRequestHandlerImp implements AppRequestHandler {

    private VisionApi visionApi;

    public AppRequestHandlerImp(){}

    public AppRequestHandlerImp(VisionApiImp visionApi){
        this.visionApi = visionApi;
    }

    public void SendToApi(InputStream stream)throws Exception{

        visionApi.sendRequest(stream);
    }


}
