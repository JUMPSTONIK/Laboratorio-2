package com.example.jumpstonik.laboratorio.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.jumpstonik.laboratorio.Model.ModelCosas;

import static com.example.jumpstonik.laboratorio.Local.CosasDataBase.DATABASES_VERSION;

/**
 * Created by JUMPSTONIK on 01/03/2018.
 */

@Database(entities = ModelCosas.class,version = DATABASES_VERSION)
public abstract class CosasDataBase extends RoomDatabase {
    public static final int DATABASES_VERSION = 1;
    public static final  String DATABASES_NAME="EDMT-Database-Room";

    public abstract  CosasDAO cosasDAO();
    private static CosasDataBase mInstance;

    public  static CosasDataBase getInstance(Context context){

        if (mInstance == null){
            mInstance = Room.databaseBuilder(context,CosasDataBase.class, DATABASES_NAME).fallbackToDestructiveMigration().build();

        }
        return mInstance;
    }


}
