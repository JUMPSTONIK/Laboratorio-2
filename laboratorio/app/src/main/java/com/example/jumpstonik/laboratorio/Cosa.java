package com.example.jumpstonik.laboratorio;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by JUMPSTONIK on 22/02/2018.
 */

public class Cosa implements Parcelable{

    private String texto1;
    private String texto2;

    public Cosa( String text1, String text2){

        this.texto1 = text1;
        this.texto2 = text2;
    }

    protected Cosa(Parcel in) {

        this.texto1 = in.readString();
        this.texto2 = in.readString();
    }

    public static final Creator<Cosa> CREATOR = new Creator<Cosa>() {
        @Override
        public Cosa createFromParcel(Parcel in) {
            return new Cosa(in);
        }

        @Override
        public Cosa[] newArray(int size) {
            return new Cosa[size];
        }
    };

    /**
     * esta funcion regresa el primer texto
     * @return texto del atributo texto1
     */
    public String getTexto1(){
        return this.texto1;
    }
    /**
     * esta funcion regresa el primer texto
     * @return texto del atributo texto2
     */
    public String getTexto2(){
        return  this.texto2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(texto1);
        parcel.writeString(texto2);
    }
}
