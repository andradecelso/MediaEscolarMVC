package br.com.javacomcafe.mediaescolarmvc.controller;

import android.content.ContentValues;
import android.content.Context;

import br.com.javacomcafe.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import br.com.javacomcafe.mediaescolarmvc.datasource.DataSource;
import br.com.javacomcafe.mediaescolarmvc.model.MediaEscolar;

public class MediaEscolarController extends DataSource {


    ContentValues dados;

    public MediaEscolarController(Context context) {
        super(context);
    }

    public void calcularMedia(){


    }


    public void resultadoFinal(){


    }



    public boolean salvar(MediaEscolar obj){

        dados = new ContentValues();
        boolean sucesso=true;

        dados.put(MediaEscolarDataModel.getMateria(),obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(),obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(),obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(),obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaMateria(),obj.getNotaMateria());
        dados.put(MediaEscolarDataModel.getMediaFinal(),obj.getMediaFinal());


        sucesso = insert(MediaEscolarDataModel.getTABELA(),dados);



        return sucesso;

    }


    public boolean deletar(MediaEscolar obj){

        boolean sucesso = true;

        sucesso = deletar(MediaEscolarDataModel.getTABELA(), obj.getId());

        return sucesso;

    }


}

