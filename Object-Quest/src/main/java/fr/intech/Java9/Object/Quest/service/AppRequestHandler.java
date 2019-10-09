package fr.intech.Java9.Object.Quest.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public interface AppRequestHandler {

    /**
     * Sends inputstream / file to Api
     * @param inputStream
     * @throws Exception
     */
    public void sendToApi(InputStream inputStream) throws Exception;
    public default void sendToApi(File file) throws Exception {
        sendToApi(new FileInputStream(file));
    }
}
