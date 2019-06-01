package br.com.javacomcafe.mediaescolarmvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.List;

import br.com.javacomcafe.mediaescolarmvc.R;
import br.com.javacomcafe.mediaescolarmvc.controller.MediaEscolarController;
import br.com.javacomcafe.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import br.com.javacomcafe.mediaescolarmvc.datasource.DataSource;
import br.com.javacomcafe.mediaescolarmvc.model.MediaEscolar;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT=5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



       apresentarTelaSplash();

    }


    private void apresentarTelaSplash(){

        DataSource ds = new DataSource(getBaseContext());


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


               MediaEscolar obj = new MediaEscolar();


                MediaEscolarController mediaEscolarController = new MediaEscolarController(getBaseContext());


                List<MediaEscolar> objetos = mediaEscolarController.listar();

                for (MediaEscolar lista: objetos
                     ) {
                    Log.i("RETORNO BANCO:  ","ID= " + lista.getId() + " Materia= "+ lista.getMateria() );
                }


               obj = mediaEscolarController.buscarId(4);
                Log.i("RETORNO: ","objeto ID:" + obj.getId());

                String resultado="";
                try {
                    mediaEscolarController.deletar(obj);
                    resultado="sucesso";

                }catch(Exception e){
                    resultado ="erro: " + e.getMessage();

                }


               Log.i("remocao","status:" + resultado);


                for (MediaEscolar lista: objetos
                ) {
                    Log.i("RETORNO BANCO:  ","ID= " + lista.getId() + " Materia= "+ lista.getMateria() );
                }

                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);

            startActivity(telaPrincipal);
            finish();

            }
        },SPLASH_TIME_OUT);

    }

}
