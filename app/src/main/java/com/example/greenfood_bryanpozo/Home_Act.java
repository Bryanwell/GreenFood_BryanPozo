package com.example.greenfood_bryanpozo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home_Act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] image = {R.drawable.a, R.drawable.b, R.drawable.c}; //recorro las imagenes , asignadas como a b c

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        vf = (ViewFlipper)findViewById(R.id.slider); //obtengo mi elemento por id


        //   declaracion      //condicion         //incremento
        for (int i = 0;      i < image.length     ; i++)
        {
            flip_image(image[i]);
        }

    }


    // Funcion para configurar mi slider ,
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this); //obtengo mis imagen view
        view.setBackgroundResource(i); // seteamos el background
        vf.addView(view);           //añadimos el backgroud al viewflipper
        vf.setFlipInterval(3000);   //añadimos intervalos en tiempo
        vf.setAutoStart(true);     // iniciar de forma automatica

        //orientacion
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void Base (View view)
    {
        Intent i = new Intent(this, Base_Act.class);
        startActivity(i);
    }

    public void Usuarios (View view)
    {
        Intent i = new Intent(this, Usuarios_act.class);
        startActivity(i);
    }

    public void Maps (View view)
    {
        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);
    }

    public void Nutricion(View v)
    {
        Intent i = new Intent(this, Nutricion_act.class);
        i.putExtra("mensaje", "Cuida tu nutricion con nuestros alimentos");
        startActivity(i);
    }


}