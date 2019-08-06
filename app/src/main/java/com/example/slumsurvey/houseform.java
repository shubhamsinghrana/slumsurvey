package com.example.slumsurvey;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.nio.file.FileVisitOption;
import java.util.ArrayList;
import java.util.List;

public class
houseform extends AppCompatActivity {
    Spinner conhouse,room,toilet,kitchen;
    ImageView cameraBtn12, imageBox12;
    Bitmap bitmap1;
    Button exit;
    EditText area,areabuilt,yearofstaying,consent;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houseform);
        conhouse=findViewById(R.id.conhouse);

        cameraBtn12=findViewById(R.id.cameraBtn12);
        imageBox12=findViewById(R.id.imageBox12);
        imageBox12.setVisibility(View.GONE);
        exit= findViewById(R.id.saveexit);

        setTitle("");

        // requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar

        room=findViewById(R.id.room);
        toilet=findViewById(R.id.toilet);
        kitchen=findViewById(R.id.kitchen);

        List<String> options = new ArrayList<String>();
        options.add("NO");
        options.add("YES");

        List<String> option = new ArrayList<String>();
        option.add("Kutcha");
        option.add("Semi-Pakka");
        option.add("Pakka");

        conhouse.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,option));

        room.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options));
        toilet.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options));
        kitchen.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options));




        cameraBtn12.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

            //imageBox12.setVisibility(View.VISIBLE);
//                Intent cameraIntent23 = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent23, 0);
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent a = new Intent(houseform.this,dashb.class);
                startActivity(a);
                houseform.this.finish();


            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageBox12.setVisibility(View.VISIBLE);
            imageBox12.setImageBitmap(imageBitmap);
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent a = new Intent(houseform.this,dashb.class);
        startActivity(a);
        houseform.this.finish();

    }

}
