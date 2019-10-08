package fr.intech.Java9.Object.Quest;

import com.google.cloud.ByteArray;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public interface VisionApi {

    public BatchAnnotateImagesResponse sendRequest(InputStream inputStream) throws Exception;

    public default BatchAnnotateImagesResponse sendRequest(String fileName) throws Exception {
        FileInputStream stream = new FileInputStream(new File(fileName));
        return sendRequest(stream);
    }
}
