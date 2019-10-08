package fr.intech.Java9.Object.Quest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.protobuf.ByteString;
import fr.intech.Java9.Object.Quest.model.RequestResponse;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

@Service
public class ResponseHandlerImp  implements ResponseHandler {

    public RequestResponse getResponse(BatchAnnotateImagesResponse resp) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        RequestResponse response = objectMapper.readValue(resp.toString(),RequestResponse.class);

        return response;
    }
}
