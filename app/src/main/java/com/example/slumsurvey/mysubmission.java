package com.example.slumsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class mysubmission extends AppCompatActivity {

    LinearLayout mlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysubmission);
        mlay=findViewById(R.id.mysub);
        setTitle("");

        // requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar

        mlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent a = new Intent(mysubmission.this, Infoshow.class);
                a.putExtra("appid", "1234567");
                startActivity(a);
               mysubmission.this.finish();


            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();

        Intent a = new Intent(mysubmission.this,dashb.class);
        startActivity(a);
        mysubmission.this.finish();

    }
}
