package com.example.greenfood_bryanpozo;

//importar bibliotecas de clases necesariass para trabajar con sqlite
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import androidx.annotation.Nullable;

//clase auxiliar que generara mi esquema de la base de datos
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    //constructor que me permitira conf. el ficheero de BD
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //permite definir mis tablas y campos
    @Override
    public void onCreate(SQLiteDatabase Productos) {

        Productos.execSQL("CREATE TABLE Alimentos (CODIGO int primary key, nombre tex, precio float)"); // implementar una query para crear la tabla
    }

    //permite revisar los cambios esquematicos de la BD
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

