package com.example.mysamsung.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class vegetables extends AppCompatActivity {
    EditText buckysinput;
    TextView buckystext;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);
        buckysinput =(EditText)findViewById(R.id.buckysInput);
        buckystext = (TextView) findViewById(R.id.buckysText);
        dbHandler = new MyDBHandler(this,null,null,1);
        printdatabase();

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
    public void addButtonClicked (View view){

     Product product = new Product(buckysinput.getText().toString());
        dbHandler.addProduct(product);
        printdatabase();
    }
    public void deleteButtonClicked(View view){
        String inputText = buckysinput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printdatabase();

    }

    public void printdatabase(){

        String dbstring = dbHandler.databaseToString();
        buckystext.setText(dbstring);
        buckysinput.setText("");
    }

}
