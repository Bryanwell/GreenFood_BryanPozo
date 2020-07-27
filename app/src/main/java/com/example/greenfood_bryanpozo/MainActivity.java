package com.example.greenfood_bryanpozo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView edit1;
    private TextView edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.et1);
        edit2 = (EditText) findViewById(R.id.et2);
    }

    public void IniciarSesion (View view)
    {

        if (edit1.getText().toString().equalsIgnoreCase("Android")&&
                edit2.getText().toString().equals("123"))
        {
            Intent i = new Intent(this, Home_Act.class);
            startActivity(i);
        }
        else {
            edit1.setText("datos erroneos");

        }
    }


}