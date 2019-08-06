package com.example.slumsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


//logn activity
public class MainActivity extends AppCompatActivity {
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin=findViewById(R.id.btnlogin);
        setTitle("");

        // requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        btnlogin.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent a = new Intent(MainActivity.this,dashb.class);
                startActivity(a);
                MainActivity.this.finish();

            }
        });




    }
}
