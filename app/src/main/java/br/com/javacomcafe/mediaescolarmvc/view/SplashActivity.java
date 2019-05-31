package br.com.javacomcafe.mediaescolarmvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.javacomcafe.mediaescolarmvc.R;
import br.com.javacomcafe.mediaescolarmvc.controller.MediaEscolarController;
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

                obj.setMateria("matematica");
                obj.setBimestre("1o bimestre");
                obj.setNotaProva(10);
                obj.setNotaMateria(9);
                obj.setSituacao("aprovado");
                obj.setMediaFinal(9);
                obj.setSituacao("aprovado");

                MediaEscolarController mediaEscolarController = new MediaEscolarController(getBaseContext());


                mediaEscolarController.salvar(obj);

                obj.setId(1);
                mediaEscolarController.deletar(obj);





                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);

            startActivity(telaPrincipal);
            finish();

            }
        },SPLASH_TIME_OUT);

    }

}
