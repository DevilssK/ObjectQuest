package fr.intech.Java9.Object.Quest.service;

import java.io.InputStream;

public interface AppRequestHandler {

    public void SendToApi(InputStream inputStream) throws Exception;
}
