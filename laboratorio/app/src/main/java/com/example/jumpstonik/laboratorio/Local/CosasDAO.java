package com.example.jumpstonik.laboratorio.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.jumpstonik.laboratorio.Model.ModelCosas;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by JUMPSTONIK on 01/03/2018.
 */
@Dao
public interface CosasDAO {
    @Query("SELECT * FROM ModelCosas WHERE id=:CosasId")
    Flowable<ModelCosas> getModelCosasById(int CosasId);

    @Query("SELECT * FROM ModelCosas")
    Flowable<List<ModelCosas>> getAllModelCosas();

    @Insert
    void insertModelCosas(ModelCosas... modelCosas);
}
