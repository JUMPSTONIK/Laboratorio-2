/**
 * josue david lopez florian
 * universidad del valle de guatemala
 * 17081 23/02/2018
 * Plataformas y videojuegos
 */


package com.example.jumpstonik.laboratorio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Cosa> info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CrearObjetos();
        listView = (ListView) findViewById(R.id.List1);

        String[] dat = new String[]{info.get(0).getTexto1() + " " + info.get(0).getTexto2(), info.get(1).getTexto1() + " " + info.get(1).getTexto2(), info.get(2).getTexto1() + " " + info.get(2).getTexto2()};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, dat);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent q = new Intent(Main.this, Display.class);
                q.putExtra("data", info.get(i));
                startActivity(q);
            }
        });
    }

    /**
     * aqui creo los objetos que s emostraran en mi lista
     */
    public void CrearObjetos(){
        info = new ArrayList<Cosa>();
        info.add( new Cosa("pelota", "roja"));
        info.add(new Cosa("globo", "azul"));
        info.add( new Cosa("botella", "amarilla"));
    }
    //public void onButtonClick(View v){

        //if (v.getId() == R.id.btn_displayer){
            //Intent i = new Intent(Main.this, Display.class);
            //startActivity(i);
        //}
    //}
}
