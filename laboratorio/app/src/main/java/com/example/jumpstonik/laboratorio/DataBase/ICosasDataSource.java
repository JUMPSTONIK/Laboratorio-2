package com.example.jumpstonik.laboratorio.DataBase;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.jumpstonik.laboratorio.Model.ModelCosas;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by JUMPSTONIK on 01/03/2018.
 */

public interface ICosasDataSource {
    Flowable<ModelCosas> getModelCosasById(int CosasId);
    Flowable<List<ModelCosas>> getAllModelCosas();

    void insertModelCosas(ModelCosas... modelCosas);
}
