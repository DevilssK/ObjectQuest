package com.t.objectquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.t.objectquest.adapters.QuestAdapter;
import com.t.objectquest.model.Quest;
import com.t.objectquest.model.User;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    CapturePhotoUtils photoUtils = new CapturePhotoUtils();
    SendPhoto sendPhoto = new SendPhoto();
    AppRequest appRequest = new AppRequest();
    List<Quest> quests;
    User user;
    Button listB;


   /* Button create = findViewById(R.id.createButton);
    TextView error = findViewById(R.id.error_message);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appRequestImp.getQuests();

        /*
        Intent intent = getIntent();
        String message = intent.getStringExtra(accountCreateActivity.MESSAGE);
        TextView textView = findViewById(R.id.userName);
        Log.i("MaintActivity" , message);
        Log.i("MaintActivity" , "hello");

        textView.setText("id"+message);*/

        //TODO: Set User Object
        user = new User(0,"0" , 0);



        Button button = (Button) findViewById(R.id.button_Photo);
        button.setOnClickListener((c) -> {onClick();} );






        //ListView questView = findViewById(R.id.quest_list);
      //  BaseAdapter questAdapter = new QuestAdapter(quests,this);
//        questView.setAdapter(questAdapter);

        listB = findViewById(R.id.button_Photo);
        listB.setOnClickListener((v)->{

            onClick();
          //  Intent intent = new Intent(this, quest_activity);

        });
       //questView.setOnItemClickListener((parent, view, position, id) -> {
         //      Toast.makeText(MainActivity.this, "Click "+position, Toast.LENGTH_SHORT).show();
       //});

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


            appRequestImp.uploadImage(byteArray , this.user.getUserId());
     }


    }
}


