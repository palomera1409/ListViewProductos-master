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

public class AgregarActividad extends AppCompatActivity {

    Spinner spinner;
    EditText nombreprod;
    Button guardar;
  int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividad);

        Intent i = getIntent();
        int pos = i.getIntExtra("position", 0);
        String nombre = i.getStringExtra("nombre");
        String category = i.getStringExtra("categoria");


        spinner = (Spinner) findViewById(R.id.spncategoria);
        nombreprod= (EditText)findViewById(R.id.edtxtnombre);
        guardar =(Button)findViewById(R.id.btnagregar);
        if (pos == 0) {
            String categoria[] = {"Electronica", "Dulceria", "Papeleria", "Papeleria", "Moda", "Perfumeria ", "Hogar", "Electronicos", "Hogar",
                    "Electrodomesticos", "Electrodomesticos", };
            ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoria);
            spinner.setAdapter(adaptador);

        }

        else if (pos != 0) {

            nombreprod.setText(nombre);

            String categoria[] = {"Electronica", "Dulceria", "Papeleria", "Papeleria", "Moda", "Perfumeria ", "Hogar", "Electronicos", "Hogar",
                    "Electrodomesticos", "Electrodomesticos"};
            ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoria);
            spinner.setAdapter(adaptador);

        }


    }


















    public void agregar (View v)
    {
        Intent f = getIntent();
        int pos = f.getIntExtra("position", 0);


        Intent  i  = new Intent();
i.putExtra("nombre",nombreprod.getText().toString());
i.putExtra("categoria",spinner.getSelectedItem().toString());
i.putExtra("position",pos);
setResult(RESULT_OK,i);



finish();


    }






}
