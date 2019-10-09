package fr.intech.Java9.Object.Quest.service;

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

    public void Display(BatchAnnotateImagesResponse response) throws IOException {

        RequestResponse requestResponse = new RequestResponse();

        List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.printf("Error: %s\n", res.getError().getMessage());
                    return;
                }

                List<Annotation> annotations = new ArrayList<Annotation>();

                for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
                    Annotation an = new Annotation();
                    an.setDescription(annotation.getDescription());
                    an.setScore((int) annotation.getScore());

                    annotations.add(an);
                }
                requestResponse.setAnnotations(annotations);
            }
            System.out.println(requestResponse.toString());
    }

}