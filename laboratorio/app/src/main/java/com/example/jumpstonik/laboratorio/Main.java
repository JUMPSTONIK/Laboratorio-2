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
import android.widget.Toast;

import com.example.jumpstonik.laboratorio.DataBase.CosasRepository;
import com.example.jumpstonik.laboratorio.Local.CosasDataBase;
import com.example.jumpstonik.laboratorio.Local.CosasDataSource;
import com.example.jumpstonik.laboratorio.Model.ModelCosas;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Main extends AppCompatActivity {
    private ListView listView;
    private Canasta info;

    //Database
    private CompositeDisposable compositeDisposable;
    private CosasRepository cosasRepository;

    //Adapter
    List<ModelCosas> cosasList = new ArrayList<>();
    ArrayAdapter adapter; //para ver lo del adapter mirar en 20:43

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init
        compositeDisposable = new CompositeDisposable();

        //Init View
        info = new Canasta();
        listView = (ListView) findViewById(R.id.List1);
        //Getting data
        //String[] dat = new String[]{info.getListaCosas().get(0).getTexto1() + " " + info.getListaCosas().get(0).getTexto2(), info.getListaCosas().get(1).getTexto1() + " " + info.getListaCosas().get(1).getTexto2(), info.getListaCosas().get(2).getTexto1() + " " + info.getListaCosas().get(2).getTexto2()};


        adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1, cosasList); // para mo strar la data sin BD poner dat en ves de cosaList y descomentar dat
        registerForContextMenu(listView);
        listView.setAdapter(adapter);

        //DataBase
        CosasDataBase cosasDataBase = CosasDataBase.getInstance(this); //Create Database
        cosasRepository = CosasRepository.getInstance(CosasDataSource.getInstance(cosasDataBase.cosasDAO())); //si algo falla aca, es porque hice static a cosasDAO. Revisar en el video al crear Database

        //loadData form DataBase
        loadData();

        Disposable disposable = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public  void  subscribe(ObservableEmitter<Object> e) throws Exception{
                ModelCosas modelCosas1 = new ModelCosas(info.getListaCosas().get(0).getTexto1(), info.getListaCosas().get(0).getTexto2());
                cosasRepository.insertModelCosas(modelCosas1);
                ModelCosas modelCosas2 = new ModelCosas(info.getListaCosas().get(1).getTexto1(), info.getListaCosas().get(1).getTexto2());
                cosasRepository.insertModelCosas(modelCosas2);
                ModelCosas modelCosas3 = new ModelCosas(info.getListaCosas().get(2).getTexto1(), info.getListaCosas().get(2).getTexto2());
                cosasRepository.insertModelCosas(modelCosas3);
                e.onComplete();
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer() {
                                                                                                @Override
                                                                                                public void accept(Object o) throws Exception {
                                                                                                    Toast.makeText(Main.this, "Cosa added!", Toast.LENGTH_SHORT).show();
                                                                                                }
                                                                                            }, new Consumer<Throwable>() {
                                                                                                @Override
                                                                                                public void accept(Throwable throwable) throws Exception {
                                                                                                    Toast.makeText(Main.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                                                                                                }
                                                                                            }, new Action() {
                                                                                                                                                       @Override
                                                                                                                                                       public void run() throws Exception {
                                                                                                                                                          loadData();//Refresh data
                                                                                                                                                       }
                                                                                                                                                   }
        );



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent q = new Intent(Main.this, Display.class);
                q.putExtra("data", info.getListaCosas().get(i));
                startActivity(q);

            }
        });
    }



    private  void loadData(){
        //Use RxJava
        Disposable disponsable = cosasRepository.getAllModelCosas().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<List<ModelCosas>>() {
            @Override
            public void accept(List<ModelCosas> modelCosas) throws Exception {
                onGetAllCosasSuccess(modelCosas);
            }
        }, new Consumer<Throwable>(){
            @Override
            public void accept(Throwable throwable) throws Exception{
                Toast.makeText(Main.this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        compositeDisposable.add(disponsable);
    }


    private void onGetAllCosasSuccess(List<ModelCosas> modelCosas) { // 23:54 aqui quedo el video y el codigo siguiente es del listview
        cosasList.clear();
        cosasList.addAll(modelCosas);
        adapter.notifyDataSetChanged();

    }


}
