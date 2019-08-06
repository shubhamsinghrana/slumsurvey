package com.example.slumsurvey;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class applicationform extends AppCompatActivity {
    Spinner spinner,spinner2,catspinner,relspinner,fammemspinner;
    ImageView cameraBtn, imageBox,cameraBtn1, imageBox1;
    EditText hof,address,family ,nationaloty,adarcard,nooffamily;
    String slumarea,gender1,religion1,caategory1,fmnumber;
    Bitmap bitmap,bitmap1;
    String imgtype="Ss";
    Button save;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_applicationform);
        setTitle("");
       // requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        spinner=findViewById(R.id.slumname);
        spinner2=findViewById(R.id.spinner2);
        relspinner=findViewById(R.id.religion1);
        catspinner=findViewById(R.id.catspinner);
        cameraBtn=findViewById(R.id.cameraBtn);
        imageBox=findViewById(R.id.imageBox);
        fammemspinner=findViewById(R.id.familymemberspinner);
       // cameraBtn1=findViewById(R.id.cameraBtn1);
      //  imageBox1=findViewById(R.id.imageBox1);
        imageBox.setVisibility(View.GONE);
        //imageBox1.setVisibility(View.GONE);
        save=findViewById(R.id.savebtn);
        hof=findViewById(R.id.hof);
        address=findViewById(R.id.address);
        family=findViewById(R.id.famiincome);
        nationaloty=findViewById(R.id.famiincome);
        adarcard=findViewById(R.id.adarcard);

        // Spinner click listener
        //spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("locality 1");
        categories.add("locatity 2");
        categories.add("locatity 3");
        categories.add("locatity 4");
        categories.add("locatity 5");
        categories.add("locatity 6");

        List<String> gen = new ArrayList<String>();
        gen.add("Male");
        gen.add("Female");
        gen.add("Other");


        List<String> cat = new ArrayList<String>();
        cat.add("General");
        cat.add("OBC");
        cat.add("SC");
        cat.add("ST");
        cat.add("Immigrant");



        List<String> rel = new ArrayList<String>();
        rel.add("Hindu");
        rel.add("Muslim");
        rel.add("Sikh");
        rel.add("Christian");
        rel.add("Other");


        List<String> fmno = new ArrayList<String>();
        fmno.add("0");
        fmno.add("1");
        fmno.add("2");
        fmno.add("3");
        fmno.add("4");
        fmno.add("5");
        fmno.add("6");
        fmno.add("7");
        fmno.add("8");
        fmno.add("9");
        fmno.add("10");
        fmno.add("11");
        fmno.add("12");




        // Creating adapter for spinner

        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,categories));
        spinner2.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,gen));
        catspinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cat));
       relspinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rel));
       fammemspinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fmno));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //  Toast.makeText(ShowingTimeTable.this, String.valueOf(i), Toast.LENGTH_SHORT).show();

                slumarea = spinner.getItemAtPosition(i).toString();

                // Showing selected spinner item
                //Toast.makeText(applicationform.this, item, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //  Toast.makeText(ShowingTimeTable.this, String.valueOf(i), Toast.LENGTH_SHORT).show();

                gender1= spinner2.getItemAtPosition(i).toString();

                // Showing selected spinner item
                //Toast.makeText(applicationform.this, g Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        catspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //  Toast.makeText(ShowingTimeTable.this, String.valueOf(i), Toast.LENGTH_SHORT).show();

                caategory1 = catspinner.getItemAtPosition(i).toString();

                // Showing selected spinner item
                //Toast.makeText(applicationform.this, item, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        relspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //  Toast.makeText(ShowingTimeTable.this, String.valueOf(i), Toast.LENGTH_SHORT).show();

                religion1= relspinner.getItemAtPosition(i).toString();

                // Showing selected spinner item
                //Toast.makeText(applicationform.this, item, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        fammemspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //  Toast.makeText(ShowingTimeTable.this, String.valueOf(i), Toast.LENGTH_SHORT).show();

                fmnumber= fammemspinner.getItemAtPosition(i).toString();

                // Showing selected spinner item
                //Toast.makeText(applicationform.this, item, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        cameraBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                imgtype="hodf";
//
//                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent, 0);

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
//        cameraBtn1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//
//            public void onClick(View view) {
//                imgtype="house";
//                imageBox1.setVisibility(View.VISIBLE);
//                Intent cameraIntent2 = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent2, 0);
//
//            }
//        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(hof.getText().toString().trim().equals(""))        // validation in Android , title and description should not be empty
//                {
//                    hof.setError("this field cannot be blank");
//                }
////                else if(address.getText().toString().trim().equals(""))
//                {
//                    address.setError("This field cannot be blank");
//                }
//                else if(family.getText().toString().trim().equals(""))
//                {
//                    family.setError("This field cannot be blank");
//                }
//                else if(nationaloty.getText().toString().trim().equals(""))
//                {
//                    nationaloty.setError("This field cannot be blank");
//                }
//                else if(adarcard.getText().toString().trim().equals(""))
//                {
//                    adarcard.setError("This field cannot be blank");
//                }
//                else if(nooffamily.getText().toString().trim().equals(""))
//                {
//                    nooffamily.setError("This field cannot be blank");
////                }
//                else {

                            if(fmnumber.equals("0")==false) {
                                Intent a = new Intent(applicationform.this, familymembers.class);
                                a.putExtra("membercount", fmnumber.trim());
                                a.putExtra("appid", "1234567");
                                a.putExtra("memberno", "1");
                                startActivity(a);
                                applicationform.this.finish();
                            }
                            else{
                                Intent a = new Intent(applicationform.this, houseform.class);
                                a.putExtra("appid", "1234567");
                                startActivity(a);
                                applicationform.this.finish();
                            }

//                        }

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(imgtype.equals("hodf")) {
//            bitmap = (Bitmap) data.getExtras().get("data");
//            if ( resultCode == RESULT_OK)
//            {
//                imageBox.setVisibility(View.VISIBLE);
//                imageBox.setImageBitmap(bitmap);
//            }
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imageBox.setVisibility(View.VISIBLE);
                imageBox.setImageBitmap(imageBitmap);
            }
//


           // Toast.makeText(this, imgtype, Toast.LENGTH_SHORT).show();
        }
//        if(imgtype.equals("house"))
//        {
//            bitmap1 = (Bitmap) data.getExtras().get("data");
//            imageBox1.setImageBitmap(bitmap1);
//            Toast.makeText(this, imgtype, Toast.LENGTH_SHORT).show();
//        }

    }
    public void onBackPressed() {
        super.onBackPressed();

        Intent a = new Intent(applicationform.this,dashb.class);
        startActivity(a);
        applicationform.this.finish();

    }

}