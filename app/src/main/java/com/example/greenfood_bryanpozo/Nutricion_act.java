package com.example.greenfood_bryanpozo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Nutricion_act extends AppCompatActivity {

    private TextView texto, texto4;
    private EditText edit2,edit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricion_act);

        edit2 = (EditText)findViewById(R.id.et1);
        edit3 = (EditText)findViewById(R.id.et2);
        texto = (TextView)findViewById(R.id.tv2);
        texto4 = (TextView)findViewById(R.id.tv1);

        String tx1 =getIntent().getStringExtra("mensaje");
        texto.setText(tx1);
    }

    public void Calcular(View view)
    {
        String ingPresio = edit2.getText().toString();
        String cantidad = edit3.getText().toString();

        int ingresarPresio = Integer.parseInt(ingPresio);
        int cant = Integer.parseInt(cantidad);

        int total = (ingresarPresio*cant);

        texto4.setText("El valor final es: "+total);
    }
    public void Web(View view)
    {
        Intent i =new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.medicina.uchile.cl/pregrado/licenciaturas-y-titulos/nutricion-y-dietetica"));
        startActivity(i);
    }

    public void VolverMenu(View view)
    {
        finish();
    }
}