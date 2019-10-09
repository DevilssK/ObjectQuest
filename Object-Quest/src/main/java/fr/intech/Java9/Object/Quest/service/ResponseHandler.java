package fr.intech.Java9.Object.Quest.service;

import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import fr.intech.Java9.Object.Quest.model.RequestResponse;

public interface ResponseHandler {

      /**
       * get BatchAnnotateImageResponse from api and transform it into a RequestResponse
       * @param resp
       * @return RequestResponses
       * @throws Exception
       */
      public RequestResponse getResponseFromApi(BatchAnnotateImagesResponse resp) throws Exception;
}
