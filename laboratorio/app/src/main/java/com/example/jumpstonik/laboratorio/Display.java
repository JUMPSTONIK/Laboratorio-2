package com.example.jumpstonik.laboratorio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by JUMPSTONIK on 20/02/2018.
 */

public class Display extends Activity {
    TextView txv_receptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_pestana);
        //inicializo mi intent para recopilar datos
        Intent a = getIntent();
        Cosa elemento = a.getParcelableExtra("data");
        //aqui agrego el atributo 1 de mi objeto mandado
        TextView textView1 = findViewById(R.id.linea1);
        textView1.setText(elemento.getTexto1());
        //aqui agrego el atributo 1 de mi objeto mandado
        TextView textView2 = findViewById(R.id.linea2);
        textView2.setText(elemento.getTexto2());

    }


}
