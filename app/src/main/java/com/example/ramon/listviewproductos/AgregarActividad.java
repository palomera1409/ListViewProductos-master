package com.example.ramon.listviewproductos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AgregarActividad extends AppCompatActivity {

    Spinner spinner;
    EditText nombreprod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividad);
        String categoria[]={"Electronica","Electronica","Dulceria","Papeleria","Papeleria","Moda","Perfumeria ","Hogar","Electronicos", "Hogar",
                "Electrodomesticos", "Electrodomesticos","Electronica"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categoria);
    spinner =(Spinner)findViewById(R.id.spncategoria);
    spinner.setAdapter(adaptador);
    nombreprod = (EditText)findViewById(R.id.edtxtnombre);

    }




    public void agregar (View v)
    {

        Intent  i  = new Intent();
i.putExtra("nombre",nombreprod.getText().toString());
i.putExtra("categoria",spinner.getSelectedItem().toString());
setResult(RESULT_OK,i);

        Toast mensaje = Toast.makeText(getApplicationContext(),"Se agregaron correctamente "+nombreprod.getText().toString().toLowerCase(),Toast.LENGTH_LONG);
        mensaje.setGravity(Gravity.CENTER,32,32);
        mensaje.setDuration(Toast.LENGTH_LONG);
        mensaje.show();
finish();


    }






}
