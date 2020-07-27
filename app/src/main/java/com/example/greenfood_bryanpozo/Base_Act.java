package com.example.greenfood_bryanpozo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Base_Act extends AppCompatActivity {

    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_);

        //recibo mis componentes graficos
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);

    }

    //añadir Alimentos
    public void AñadirAlimentos (View view)
    {
        //obtengo mi fichero de configuracion de BD, el cual me pide el contexto / nombre del fichero / cursor / version de la BD
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Productos", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();// le damos los permisos para sobreescritura en la BD

        // Si el codigo no esta vacio
        if(!et1.getText().toString().isEmpty())
        {
            //añado el dato
            ContentValues registro = new ContentValues();
            registro.put("codigo", et1.getText().toString()); //campo de BD y lo reemplaza por el dato a reemplazar
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", et3.getText().toString());

            database.insert ("Alimentos", null, registro);  //realizo el insert.
            database.close();

            Toast.makeText (this, "Se a guardado el dato", Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this, "Debe ingresar un codigo", Toast.LENGTH_SHORT).show();
        }
    }

    //Mostrar nuestros Alimentos de la database

    public void MostrarAlimentos (View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Productos", null, 1); //traer nuestra database
        SQLiteDatabase Productos = admin.getWritableDatabase(); //permisos y sobreescritura

        String codigo = et1.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor fila = Productos.rawQuery("SELECT nombre, precio FROM Alimentos WHERE codigo = " + codigo, null );

            if(fila.moveToFirst()) //verifica si hay un registro en mi database
            {
                et2.setText(fila.getString(0));
                et3.setText(fila.getString(1));
            }
            else
            {
                Toast.makeText(this, "No existe producto con codigo asociado", Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(this, "Debe ingresar un codigo", Toast.LENGTH_LONG).show();
        }
    }

    //Eliminar Alimentos

    public void EliminarAlimentos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Productos", null, 1); //traemos la base de datos
        SQLiteDatabase Productos = admin.getWritableDatabase(); //sobreescribimos la base de datos

        String codigo = et1.getText().toString();

        if(!codigo.isEmpty())
        {
            //Elimino
            Productos.delete("Alimentos","codigo="+codigo, null); //elimina codigo asociado
            Productos.close();

            Toast.makeText(this, "Se ha eliminado el producto con el codigo"+ codigo, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Debe ingresar un codigo", Toast.LENGTH_SHORT).show();
        }

    }

    //modificar Alimentos

    public void ModificarAlimentos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Productos", null,1);
        SQLiteDatabase Productos = admin.getWritableDatabase(); //sobreescribimos la database

        String codigo = et1.getText().toString(); // obtenemos el codigo

        ContentValues content = new ContentValues();
        content.put("codigo", et1.getText().toString());
        content.put("nombre", et2.getText().toString());
        content.put("precio", et3.getText().toString());

        if(!codigo.isEmpty())
        {
            //modificar datos
            Productos.update("Alimentos", content, "codigo="+codigo, null);//actualizando los registros
            Productos.close();

            Toast.makeText(this, "Se ha actualizado el producto"+ codigo, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Debe ingresar un codigo", Toast.LENGTH_SHORT).show();
        }

    }

}

