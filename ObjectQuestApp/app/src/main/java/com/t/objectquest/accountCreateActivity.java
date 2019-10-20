package com.t.objectquest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.t.objectquest.database.AppDatabase;
import com.t.objectquest.model.User;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class accountCreateActivity  extends AppCompatActivity {

    public static final String MESSAGE = "com.t.objectquest.accountCreateActivity.MESSAGE";
    AppRequest appRequestImp = new AppRequest();

    AppRequest appRequest = new AppRequest();


    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_create);



        Button button = (Button) findViewById(R.id.createButton);
        button.setOnClickListener((v)->{
            username = findViewById(R.id.usernmaneField);
            String i =username.getText().toString();
            if(i.isEmpty() || i!=null ||i.matches("/s")){

               String res =  appRequest.CreateUser(new User(0,i,0) ,  new Callback() {
                   @Override
                   public void onFailure(final Call call, IOException e) {
                       Log.e("CreateUser","Erreur d'envoi",e);
                   }

                   @Override
                   public void onResponse(Call call, final Response response) throws IOException {
                       String res = response.body().string();
                      com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                       User user = mapper.readValue(res, User.class);
                       Log.i("CreateUser", "response"+ res);

                       int userId = user.getUserId();
                   //    appdatabase.userDao().saveUser(user);
                   }
               });





                Log.i("responseUserCreate", "response"+ res);

                Intent intent = new Intent(this , MainActivity.class );
               // intent.putExtra("com.t.objectquest.accountCreateActivity.MESSAGE", res);
                startActivity(intent);

            }
            else{
                Toast.makeText(getApplicationContext(), getString(R.string.retry), Toast.LENGTH_LONG).show();
            }
        });
    }


}
