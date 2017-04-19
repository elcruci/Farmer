package com.example.mysamsung.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Loginpageforshop extends AppCompatActivity {

    EditText phoneno;
    EditText postalad;
    TextView buckystext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpageforshop);

        phoneno= (EditText)findViewById(R.id.phoneno);
        postalad = (EditText)findViewById(R.id.postalad);
        buckystext = (TextView) findViewById(R.id.buckystext);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void onclick (View view){
        Intent i= new Intent(this,vegetables.class);
        startActivity(i);


    }
  
    public void saveinfo (View view ){

        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("phoneno",phoneno.getText().toString());
        editor.putString("postalad",postalad.getText().toString());
        editor.apply();
        Toast.makeText(this,"Saved!",Toast.LENGTH_LONG).show();

    }
    public void displayinfo ( View view ){
        SharedPreferences sharedPref = getSharedPreferences("userinfo",Context.MODE_PRIVATE);

        String phno =   sharedPref.getString("phoneno","");
        String postad= sharedPref.getString("postalad","");
        buckystext.setText( phno + " " + postad);

    }

}
