package fr.intech.Java9.Object.Quest.service;

import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public interface AppRequestHandler {

    /**
     * Sends inputstream / file to Api
     * @param inputStream
     * @throws Exception
     */
    public BatchAnnotateImagesResponse sendToApi(InputStream inputStream) throws Exception;
    public default BatchAnnotateImagesResponse sendToApi(File file) throws Exception {
         return sendToApi(new FileInputStream(file));
    }
}
