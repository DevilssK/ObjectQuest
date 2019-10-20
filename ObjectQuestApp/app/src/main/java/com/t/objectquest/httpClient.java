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

public class httpClient {

    private static final String TAG = "httpClient";
    private static final String Url = "http://192.168.43.40:8080";

    OkHttpClient client = new OkHttpClient();

    public void GetUser(int Id) {

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("id" , String.valueOf(Id))
                .build();

        Request request = new Request.Builder()
                .url(Url+"/image/uploadFile")
                .post(body)
                .build();

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


    public void CreateUser(String Username , Callback callback){

        RequestBody req = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("Username" , String.valueOf(Username))
                .build();

        Request request = new Request.Builder()
                .url(Url+"/createUser")
                .post(req)
                .build();

        client.newCall(request)
                .enqueue(callback);
    }



    public void GetQuest(Callback callback){

        Request request = new Request.Builder()
                .url(Url+"/getQuest")
                .build();

        client.newCall(request)
                .enqueue(callback);
    }

    private static final String TAG1 = "SendPhoto";

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
                        Log.i(TAG1, "response"+ res);

                    }
                });


    }

}


