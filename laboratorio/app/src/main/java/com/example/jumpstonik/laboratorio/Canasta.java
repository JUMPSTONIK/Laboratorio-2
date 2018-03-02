package com.example.jumpstonik.laboratorio;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by JUMPSTONIK on 01/03/2018.
 */

public class Canasta implements Parcelable {
    private ArrayList<Cosa> ListaCosas;

    public Canasta(){
        ListaCosas = new ArrayList<Cosa>();
        ListaCosas = CrearObjetos();
    }

    protected Canasta(Parcel in) {
        ListaCosas = in.createTypedArrayList(Cosa.CREATOR);
    }

    public static final Creator<Canasta> CREATOR = new Creator<Canasta>() {
        @Override
        public Canasta createFromParcel(Parcel in) {
            return new Canasta(in);
        }

        @Override
        public Canasta[] newArray(int size) {
            return new Canasta[size];
        }
    };

    private ArrayList<Cosa> CrearObjetos(){
        ArrayList<Cosa> info = new ArrayList<Cosa>();
        info.add( new Cosa("pelota", "roja"));
        info.add(new Cosa("globo", "azul"));
        info.add( new Cosa("botella", "amarilla"));
        return  info;
    }

    public ArrayList<Cosa> getListaCosas(){
        return this.ListaCosas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(ListaCosas);
    }
}
