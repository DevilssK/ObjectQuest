package com.t.objectquest;

import android.util.Log;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.t.objectquest.database.AppDatabase;

import com.t.objectquest.model.Item;
import com.t.objectquest.model.Quest;
import com.t.objectquest.model.User;


import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AppRequest {

    private AppDatabase appdatabase = AppDatabase.getInstance(MyApplication.getAppContext());
    private static final String TAG = "httpClient";
    private static final String Url = "http://192.168.43.40:8080";
    public ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    OkHttpClient client = new OkHttpClient();


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

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

    public String CreateUser(User user){

        try {
            jsonStr = mapper.writeValueAsString(user);
            // Displaying JSON String
            req = RequestBody.create(JSON, jsonStr);

            Request request = new Request.Builder()
                    .url(Url+"/user/create")
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

                            User user = mapper.readValue(res, User.class);
                            Log.i(TAG, "response"+ res);

                            int userId = user.getUserId();
                            //appdatabase.userDao().saveUser(user);
                        }
                    });

        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return "OK";
    }


    public void GetQuest(Callback callback){

        Request request = new Request.Builder()
                .url(Url+"/getQuest")
                .build();

        client.newCall(request)
                .enqueue(callback);
    }

    private static final String TAG1 = "SendPhoto";

    public static void uploadImage(byte[] file ,int userId) {


        RequestBody req = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", "filename.jpg",RequestBody.create(file, MediaType.parse("image/*jpg")))
                .addFormDataPart("userId" , String.valueOf(userId))
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

    public List<Item> GetItems() {

        List<Item> items = null;

        Request request = new Request.Builder()
                .url(Url+"/quest/getQuests")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("failled");
              //  items = null;
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {


                System.out.println(response.body());
             //   items = mapper.readValue(response.body().string(), Item.class);

                //Log.i("object list",items.)
            }
        });

        return items;

    }

}