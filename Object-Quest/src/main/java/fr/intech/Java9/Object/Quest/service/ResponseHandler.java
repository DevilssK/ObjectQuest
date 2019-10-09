package fr.intech.Java9.Object.Quest.service;

import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import fr.intech.Java9.Object.Quest.model.RequestResponse;

public interface ResponseHandler {

//    public RequestResponse getResponse(BatchAnnotateImagesResponse resp) throws Exception;
      public void Display(BatchAnnotateImagesResponse resp) throws Exception;
}
