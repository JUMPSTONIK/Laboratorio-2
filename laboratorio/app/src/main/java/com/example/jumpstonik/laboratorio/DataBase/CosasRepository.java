package com.example.jumpstonik.laboratorio.DataBase;

import com.example.jumpstonik.laboratorio.Model.ModelCosas;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by JUMPSTONIK on 01/03/2018.
 */

public class CosasRepository implements ICosasDataSource {

    private ICosasDataSource mLocalDataSource;

    private static CosasRepository mInstance;

    public CosasRepository(ICosasDataSource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static CosasRepository getInstance(ICosasDataSource mLocalDataSource){
        if (mInstance == null){
            mInstance = new CosasRepository(mLocalDataSource);
        }
        return mInstance;
    }

    @Override
    public Flowable<ModelCosas> getModelCosasById(int CosasId) {
        return mLocalDataSource.getModelCosasById(CosasId);
    }

    @Override
    public Flowable<List<ModelCosas>> getAllModelCosas() {
        return mLocalDataSource.getAllModelCosas();
    }

    @Override
    public void insertModelCosas(ModelCosas... modelCosas) {
        mLocalDataSource.insertModelCosas(modelCosas);
    }
}
