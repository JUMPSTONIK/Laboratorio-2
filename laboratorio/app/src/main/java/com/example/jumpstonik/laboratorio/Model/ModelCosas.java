package com.example.jumpstonik.laboratorio.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

/**
 * Created by JUMPSTONIK on 01/03/2018.
 */
@Entity(tableName = "ModelCosas")
public class ModelCosas {
    @NonNull
    @PrimaryKey(autoGenerate =  true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "Texto1")
    private String Texto1;

    @ColumnInfo(name = "Texto2")
    private String Texto2;

    public ModelCosas() {

    }
    @Ignore
    public ModelCosas(String texto1, String texto2) {
        Texto1 = texto1;
        Texto2 = texto2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto1() {
        return Texto1;
    }

    public void setTexto1(String texto1) {
        Texto1 = texto1;
    }

    public String getTexto2() {
        return Texto2;
    }

    public void setTexto2(String texto2) {
        Texto2 = texto2;
    }

    @Override
    public String toString() {
        return new StringBuilder(Texto1).append(" ").append(Texto2).toString();
    }
}
