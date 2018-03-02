package com.example.jumpstonik.laboratorio;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jumpstonik.laboratorio.DataBase.CosasRepository;
import com.example.jumpstonik.laboratorio.Local.CosasDataBase;
import com.example.jumpstonik.laboratorio.Model.ModelCosas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.jumpstonik.laboratorio.Local.CosasDataBase.getInstance;

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
