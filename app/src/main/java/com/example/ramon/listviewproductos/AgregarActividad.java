package com.example.ramon.listviewproductos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

public class AgregarActividad extends AppCompatActivity {

    Spinner spinner;
    EditText nombreprod;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividad);

        Intent i = getIntent();

        String nombre = i.getStringExtra("nombre");
        String category = i.getStringExtra("categoria");
       int  pos = i.getIntExtra("position", -1);

        spinner = (Spinner) findViewById(R.id.spncategoria);
        nombreprod= (EditText)findViewById(R.id.edtxtnombre);


        if (pos ==-1) {
            String categoria[] = {"Electronica", "Dulceria", "Papeleria","Moda", "Perfumeria ", "Hogar", "Electronicos", "Hogar",
                    "Electrodomesticos","primera" };
            ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoria);
            spinner.setAdapter(adaptador);


        }

       if (pos >=0) {


            nombreprod.setText(nombre);


            String categoria[] = {"Electronica", "Dulceria", "Papeleria",  "Moda", "Perfumeria ", "Hogar", "Electronicos", "Hogar",
                    "Electrodomesticos","segunda"};


           Arrays.sort(categoria);
           ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,categoria);
           spinner.setAdapter(adaptador);
           spinner.setSelection(Arrays.binarySearch(categoria,category));
        }


    }


















    public void agregar (View v)
    {
        Intent i = getIntent();
          int pos = i.getIntExtra("position", 0);



i.putExtra("nombre",nombreprod.getText().toString());
i.putExtra("categoria",spinner.getSelectedItem().toString());
i.putExtra("position",pos);
setResult(RESULT_OK,i);



finish();


    }






}
