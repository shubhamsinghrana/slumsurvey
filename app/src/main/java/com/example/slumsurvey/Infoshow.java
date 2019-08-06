package com.example.slumsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Infoshow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoshow);
    }
    public void onBackPressed() {
        super.onBackPressed();

        Intent a = new Intent(Infoshow.this,mysubmission.class);
        startActivity(a);
        Infoshow.this.finish();

    }
}
