package br.com.javacomcafe.mediaescolarmvc.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.text.DecimalFormat;

import br.com.javacomcafe.mediaescolarmvc.R;
import br.com.javacomcafe.mediaescolarmvc.fragment.BimestreAFragment;
import br.com.javacomcafe.mediaescolarmvc.fragment.BimestreBFragment;
import br.com.javacomcafe.mediaescolarmvc.fragment.BimestreCFragment;
import br.com.javacomcafe.mediaescolarmvc.fragment.BimestreDFragment;
import br.com.javacomcafe.mediaescolarmvc.fragment.ModeloFragment;
import br.com.javacomcafe.mediaescolarmvc.fragment.ResultadoFinalFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);




        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.content_fragment,new ModeloFragment()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {

            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bimestre_a) {

            setTitle("Notas 1o Bimestre");


            fragmentManager.beginTransaction().replace(R.id.content_fragment,new BimestreAFragment()).commit();

        } else if (id == R.id.nav_bimestre_b) {


            setTitle("Notas 2o Bimestre");
            fragmentManager.beginTransaction().replace(R.id.content_fragment,new BimestreBFragment()).commit();

        } else if (id == R.id.nav_bimestre_c) {

            setTitle("Notas 3o Bimestre");
            fragmentManager.beginTransaction().replace(R.id.content_fragment,new BimestreCFragment()).commit();

        } else if (id == R.id.nav_bimestre_d) {

            setTitle("Notas 4o Bimestre");
            fragmentManager.beginTransaction().replace(R.id.content_fragment,new BimestreDFragment()).commit();

        } else if (id == R.id.nav_resultado_final) {

            setTitle("Resultado Final");
            fragmentManager.beginTransaction().replace(R.id.content_fragment,new ResultadoFinalFragment()).commit();

        } else if (id == R.id.nav_compartilhar) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public static String valorFormatado(Double valor){

        DecimalFormat df = new DecimalFormat("#,###,##0.00");

        return df.format(valor);
    }
}
