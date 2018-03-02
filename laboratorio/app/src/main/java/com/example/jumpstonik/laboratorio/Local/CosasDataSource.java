package com.example.jumpstonik.laboratorio.Local;

import com.example.jumpstonik.laboratorio.DataBase.ICosasDataSource;
import com.example.jumpstonik.laboratorio.Model.ModelCosas;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by JUMPSTONIK on 01/03/2018.
 */

public class CosasDataSource implements ICosasDataSource {

    private CosasDAO cosasDAO;
    private static  CosasDataSource mInstance;

    public CosasDataSource(CosasDAO cosasDAO) {
        this.cosasDAO = cosasDAO;
    }

    public static CosasDataSource getInstance(CosasDAO cosasDAO){
        if (mInstance == null){
            mInstance = new CosasDataSource(cosasDAO);

        }
        return mInstance;
    }

    @Override
    public Flowable<ModelCosas> getModelCosasById(int CosasId) {
        return cosasDAO.getModelCosasById(CosasId);
    }

    @Override
    public Flowable<List<ModelCosas>> getAllModelCosas() {
        return cosasDAO.getAllModelCosas();
    }

    @Override
    public void insertModelCosas(ModelCosas... modelCosas) {
        cosasDAO.insertModelCosas(modelCosas);
    }


}
