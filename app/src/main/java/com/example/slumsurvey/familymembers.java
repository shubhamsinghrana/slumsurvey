package com.example.slumsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class familymembers extends AppCompatActivity {
    Spinner genspinner1;
    String gender1,j,s,count;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familymembers);
        genspinner1=findViewById(R.id.memberspinner);
        setTitle("");
        // requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b2.setVisibility(View.GONE);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            j=(String) b.get("appid");
            s=(String)b.get("membercount");
            count=(String)b.get("memberno");
            // Toast.makeText(this, j, Toast.LENGTH_SHORT).show();
        }

        if(s.equals(count)==false)
        {
            b1.setVisibility(View.VISIBLE);
        }

        if(s.equals(count))
        {
            b1.setVisibility(View.GONE);
            b2.setVisibility(View.VISIBLE);
        }
       // Toast.makeText(this, j+"  " + s, Toast.LENGTH_SHORT).show();
        List<String> gen = new ArrayList<String>();
        gen.add("Male");
        gen.add("Female");
        gen.add("Other");

        genspinner1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,gen));
        genspinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //  Toast.makeText(ShowingTimeTable.this, String.valueOf(i), Toast.LENGTH_SHORT).show();

                gender1= genspinner1.getItemAtPosition(i).toString();

                // Showing selected spinner item
                //Toast.makeText(applicationform.this, g Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                int v=Integer.parseInt(count);
                v=v+1;
                Intent a = new Intent(familymembers.this,familymembers.class);
                a.putExtra("membercount",  s);
                a.putExtra("appid", j);
                a.putExtra("memberno", String.valueOf(v));
                startActivity(a);
               familymembers.this.finish();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent a = new Intent(familymembers.this,houseform.class);
                a.putExtra("appid", j);
                startActivity(a);
               familymembers.this.finish();

            }
        });
    }

}
