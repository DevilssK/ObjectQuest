package com.t.objectquest;

import android.util.Log;


import java.io.IOException;



import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SendPhoto {

    private static final String TAG = "SendPhoto";

    public static void uploadImage(byte[] file) {


        FormBody.Builder form = new FormBody.Builder().add("userId" , "1").add("image" , file.toString());


        RequestBody req = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", "filename.jpg",RequestBody.create(file,MediaType.parse("image/*jpg")))
                .addFormDataPart("userId" , "1")
                .build();

        Request request = new Request.Builder()
                .url("http://192.168.43.41:8080/image/uploadFile")
                .post(req)
                .build();

        OkHttpClient client = new OkHttpClient();

        client.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(final Call call, IOException e) {
                        Log.e(TAG,"Erreur d'envoi",e);
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        String res = response.body().string();
                        Log.i(TAG, "response"+ res);

                    }
                });


    }
}