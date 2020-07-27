package com.example.greenfood_bryanpozo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Usuarios_act extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_act);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv1 = (TextView) findViewById(R.id.tv1);
    }
    //Mostramos el algoritmo de cifrado

    public void MostrarAlgoritmo(View view)
    {
        try
        {
            String mensaje = Encriptar(et1.getText().toString(), et2.getText().toString());
            tv1.setText(mensaje);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    //Metodo para generar un SecretKey bajo un algoritmo de cigrado

    private SecretKeySpec generateKey(String password)
            throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");// firma HMAC: se utiliza para verificar la integridad de los datos
        byte[] key = password.getBytes("UTF-8"); //que mi password acepte caracteres UTF-8
        key = sha.digest(key);

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");//genero el algoritmo de cifrado
        return secretKey;
    }


    //Metodo para aplicar el algoritmo de encriptacion

    public String Encriptar(String datos, String password)
            throws Exception {
        if (!et2.getText().toString().isEmpty())//si no esta vacio el campo contrasena
        {
            SecretKeySpec secretKey = generateKey(password); // declaramos la funcion SecretKeySpec para generar la llave
            Cipher cipher = Cipher.getInstance("AES");   //obtener Cipher el algoritmode encriptacion
            cipher.init(Cipher.ENCRYPT_MODE, secretKey); // iniciamos la encriptacion en nuestra llave secreta

            byte[] datosEncriptados = cipher.doFinal(datos.getBytes());  //obtengo una cadena de bytes para su encriptacion
            String datosEncriptadosString = Base64.encodeToString(datosEncriptados, Base64.DEFAULT);  //encodeamos la cadena de bytes a String

            return datosEncriptadosString;
        }else
        {
            Toast.makeText(this, "Debe ingresar una contrasena", Toast.LENGTH_SHORT).show();
            return null;
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////

    //Hard-Coded Password
    public void validarpass()
    {
        if(et2.getText().toString().equals("123"))
        {
            tv1.setText("Utilizar contrasena mas fuerte o use algorimo de encriptado");
        }
    }


}