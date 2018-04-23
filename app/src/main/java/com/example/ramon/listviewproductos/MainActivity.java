package com.example.ramon.listviewproductos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    private ListView lista;
    
    //Datos
    /*private String productos[] = {
            "Computadora", "Mouse", "Dulces", "Hojas",
            "Lapices", "Lentes","Reloj", "Cuchara", "Celular", "Mesa", "Refrigerador",
            "Horno", "Audifonos"
    };
    private String categoria[] = {
            "Electronica","Electronica","Dulceria","Papeleria","Papeleria","Moda","Perfumeria ","Hogar",
            "Electronicos", "Hogar", "Electrodomesticos", "Electrodomesticos","Electronica"
    };*/

    private List<String> lproductos = new ArrayList<>();
    private  List<String> lcategorias = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txt = (TextView) findViewById(R.id.textView);
        lista = (ListView) findViewById(R.id.lista);
        registerForContextMenu(lista);

    }


    public void llamaactividad (View x)
    {
        Intent i= new Intent(this, AgregarActividad.class);
        startActivityForResult(i,777);


    }


    public  void  actualizarTabla()
    {
      String productos[] = new String[lproductos.size()];
      lproductos.toArray(productos);

              ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,productos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long
                    id) {
                txt.setText("Categoria elegida -" + lcategorias.get(position));
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

   lproductos.add(data.getStringExtra("nombre"));
   lcategorias.add(data.getStringExtra("categoria"));
    actualizarTabla();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         MenuInflater i = getMenuInflater();
         i.inflate(R.menu.menu_barra,menu);
         return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         switch (item.getItemId())
         {
             case R.id.opcion_salir:finish();

         }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo)menuInfo;
menu.setHeaderTitle(lista.getAdapter().getItem(info.position).toString());
getMenuInflater().inflate(R.menu.menu_contextual,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId())

        {
            case R.id.contextual1:
                Toast.makeText(this,"Se modifico",Toast.LENGTH_LONG).show();

                break;

            case R.id.contextual2:
                lproductos.remove(lista.getAdapter().getItem(info.position));
                actualizarTabla();
                Toast.makeText(this,"Se Elimino",Toast.LENGTH_LONG).show();


        }

        return super.onContextItemSelected(item);
    }



    public void modificar ()
    {

    }




}
