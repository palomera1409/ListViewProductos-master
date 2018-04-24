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

        Intent i = getIntent();
      int posicionprincipal = i.getIntExtra("position", 0);
        String nombre = i.getStringExtra("nombre");
        String category = i.getStringExtra("categoria");


        spinner = (Spinner) findViewById(R.id.spncategoria);
        nombreprod= (EditText)findViewById(R.id.edtxtnombre);
        if (posicionprincipal == 0) {
            String categoria[] = {"Electronica", "Electronica", "Dulceria", "Papeleria", "Papeleria", "Moda", "Perfumeria ", "Hogar", "Electronicos", "Hogar",
                    "Electrodomesticos", "Electrodomesticos", };

            ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoria);
            spinner.setAdapter(adaptador);

        }

        else if (posicionprincipal!= 0) {

            nombreprod.setText(nombre);

            String categoria[] = {"Electronica", "Electronica", "Dulceria", "Papeleria", "Papeleria", "Moda", "Perfumeria ", "Hogar", "Electronicos", "Hogar",
                    "Electrodomesticos", "Electrodomesticos"};
            ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoria);
            spinner.setAdapter(adaptador);

        }


    }










    public void agregar (View v)
    {


        Intent  i  = new Intent();
i.putExtra("nombre",nombreprod.getText().toString());
i.putExtra("categoria",spinner.getSelectedItem().toString());

setResult(RESULT_OK,i);





    }






}
