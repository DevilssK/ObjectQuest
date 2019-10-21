package com.t.objectquest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.t.objectquest.database.AppDatabase;
import com.t.objectquest.model.User;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class accountCreateActivity  extends AppCompatActivity {

    public static final String MESSAGE = "com.t.objectquest.accountCreateActivity.MESSAGE";
    AppRequest appRequest = new AppRequest();

    AppDatabase appDatabase =  AppDatabase.getInstance(this);



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

               String res =  appRequest.CreateUser(new User(0,i,0));


                Log.i("responseUserCreate", "response"+ res);

                List<User> users = appDatabase.userDao().findByUserName(i);
                users.size();
                Intent intent = new Intent(this , MainActivity.class );

                startActivity(intent);

            }
            else{
                Toast.makeText(getApplicationContext(), getString(R.string.retry), Toast.LENGTH_LONG).show();
            }
        });
    }


}
