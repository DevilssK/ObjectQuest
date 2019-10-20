package com.t.objectquest;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.t.objectquest.model.Quest;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AppAppRequest implements AppRequest {

    public List<Quest> quests(){

         List<Quest>quests = null;

        Request request = new Request.Builder()
                .url("http://192.168.0.29:8080/quest/getQuests")
                .build();

        OkHttpClient client = getClient();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("failled");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                System.out.println("worked");
                System.out.println(response.body());

            }
        });

        return quests;

    }

    public static OkHttpClient getClient(){
        OkHttpClient client;
        return  client = new OkHttpClient.Builder()
                .addNetworkInterceptor( new StethoInterceptor())
                .build();
    }

}
