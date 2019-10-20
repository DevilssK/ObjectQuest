package com.t.objectquest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.t.objectquest.model.Quest;
import com.t.objectquest.model.User;

import java.util.List;

public class accountCreateActivity  extends AppCompatActivity {

    AppRequestImp appRequestImp = new AppRequestImp();

    Button listB;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_create);

        Button button = (Button) findViewById(R.id.createButton);
        button.setOnClickListener((v)->{
            username = findViewById(R.id.usernmaneField);
            String i =username.getText().toString();
            if(i.isEmpty() || i!=null ||i.matches("/s")){

               String res =  appRequestImp.CreateUser(new User(0,i,0));
                Log.i("responseUserCreate", "response"+ res);

            }
            else{
                Toast.makeText(getApplicationContext(), getString(R.string.retry), Toast.LENGTH_LONG).show();
            }
        });
    }


}
