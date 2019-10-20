package com.t.objectquest;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.t.objectquest.model.Quest;
import com.t.objectquest.model.User;


import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.Struct;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AppRequestImp implements AppRequest {

    private static final String TAG = "httpClient";
    private static final String Url = "http://192.168.43.40:8080";
    private ObjectMapper mapper = new ObjectMapper();

    OkHttpClient client = new OkHttpClient();


    public List<Quest> getQuests(){

         List<Quest>quests = null;

        Request request = new Request.Builder()
                .url(Url+"/quest/getQuests")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("failled");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {


                System.out.println(response.body());

            }
        });

        return quests;

    }


    public void GetUser(int Id) {

        Request request = new Request.Builder()
                .url(Url+"/score/"+Id)
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


    public String CreateUser(User user){

        String jsonStr;
        RequestBody req ;
        String res ="";
        try {
             jsonStr = mapper.writeValueAsString(user);
            // Displaying JSON String
             req = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("User" , jsonStr)
                    .build();
            Request request = new Request.Builder()
                    .url(Url+"/User/create")
                    .post(req)
                    .build();

            client.newCall(request)
                    .enqueue( new Callback() {
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

        catch (IOException e) {
            e.printStackTrace();
        }
        return  res;
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
                .addFormDataPart("file", "filename.jpg",RequestBody.create(file, MediaType.parse("image/*jpg")))
                .addFormDataPart("userId" , "1")
                .build();

        Request request = new Request.Builder()
                .url(Url+"/image/uploadFile")
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
