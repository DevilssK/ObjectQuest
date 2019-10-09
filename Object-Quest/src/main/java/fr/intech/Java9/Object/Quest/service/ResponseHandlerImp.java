package fr.intech.Java9.Object.Quest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import fr.intech.Java9.Object.Quest.model.Annotation;
import fr.intech.Java9.Object.Quest.model.RequestResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseHandlerImp  implements ResponseHandler {


    public RequestResponse getResponseFromApi(BatchAnnotateImagesResponse apiResponse){




        RequestResponse requestResponse = new RequestResponse();

        List<AnnotateImageResponse> responses = apiResponse.getResponsesList();

        for (AnnotateImageResponse res : responses) {
            if (res.hasError()) {
                System.out.printf("Error: %s\n", res.getError().getMessage());
                return requestResponse;
            }

            List<Annotation> annotations = new ArrayList<>();

            for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
                Annotation an = new Annotation();
                an.setDescription(annotation.getDescription());
                an.setScore((int) annotation.getScore());

                annotations.add(an);
            }
            requestResponse.setAnnotations(annotations);
        }
        return requestResponse;
    }

}