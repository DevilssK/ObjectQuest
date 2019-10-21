package com.t.objectquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.TextView;

import com.t.objectquest.database.AppDatabase;

import com.t.objectquest.model.User;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    AppDatabase appDatabase = AppDatabase.getIstance(this);

    static final int REQUEST_IMAGE_CAPTURE = 1;

    AppRequest appRequest = new AppRequest();
    User user;
    Button buttonPhoto;
    TextView userName;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //List<Item> items = appRequest.GetItems();



        Intent intent = getIntent();
        String message = intent.getStringExtra("userName");

        System.out.println(message);

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        List<User> users = appDatabase.userDao().findUserByName(message);

        int i = 0;
        while(users.size() != 0 || i<100){
            i++;
            users = appDatabase.userDao().findUserByName(message);

        }
        User user1 = appDatabase.userDao().findByUserId(users.get(0).getUserId());

        userName = findViewById(R.id.userName);
        userName.setText(user1.getUserName());

        score = findViewById(R.id.score);
        score.setText(Integer.toString(user1.getScore()));


        this.buttonPhoto = findViewById(R.id.button_Photo);
        this.buttonPhoto.setOnClickListener((v)-> {


            });


    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void onClick() {
        new Thread(new Runnable() {
            public void run() {
                dispatchTakePictureIntent();

            }
        }).start();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            //ImageView imageView = findViewById(R.id.imageView2);

            CapturePhotoUtils.insertImage(this.getContentResolver(),imageBitmap,"title", "uberIMG" );

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] byteArray = stream.toByteArray();


            appRequest.uploadImage(byteArray , this.user.getUserId());
        }
    }
}


