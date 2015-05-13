package com.example.desarrollo1.enucuestas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Inicio extends ActionBarActivity {

    private String[] opciones;
    private DrawerLayout drawerLayout;
    private ListView listView;

    private CharSequence tituloSec;
    private CharSequence tituloApp;

    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        opciones=new String[]{"Realiza encuesta","Mis estadisticas","Informacion personal","Estados","Salir"};

        drawerLayout=(DrawerLayout)findViewById(R.id.contenedorPrincipal);
        listView=(ListView) findViewById(R.id.menuIzq);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().
                getThemedContext(), android.R.layout.simple_list_item_1, opciones));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                if (position != 4) {
                    if (position == 0) {
                        fragment = new fragmento1();
                    }
                    if (position == 1) {
                        fragment = new fragmento2();
                    }
                    if (position == 2) {
                        fragment = new fragmento3();
                    }
                    if (position == 3) {
                        fragment = new fragmento4();
                    }
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().
                                replace(R.id.contenedorFrame, fragment)
                                .commit();

                        listView.setItemChecked(position, true);

                        tituloSec = opciones[position];
                        getSupportActionBar().setTitle(tituloSec);
                        drawerLayout.closeDrawer(listView);

                }
                else
                {

                      AlertDialog.Builder exitDialogo=new AlertDialog.Builder(Inicio.this);
                     exitDialogo.setTitle("Salir");
                    exitDialogo.setMessage("¿Esta seguro que desea salir?");
                    exitDialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                       @Override
                      public void onClick(DialogInterface dialog, int which) {
                         finish();
                    }
                    });
                }


            }
        });

        tituloSec=getTitle();
        tituloApp=getTitle();

       // drawerToggle=new ActionBarDrawerToggle(this,
        //         drawerLayout,R.drawable.ic_action_action_reorder,
        //      R.string.Abierto,R.string.Cerrado){
        //  @Override
        //  public void onDrawerClosed(View drawerView) {
        //      super.onDrawerClosed(drawerView);
        //      ActivityCompat.invalidateOptionsMenu(Inicio.this);
        //  }

        //  @Override
        //  public void onDrawerOpened(View drawerView) {
        ////      super.onDrawerOpened(drawerView);
                //ActivityCompat.invalidateOptionsMenu(Inicio.this);
        //}
        //};

        try {
            drawerToggle = new CustomActionBarDrawerToggle(this, drawerLayout);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(drawerToggle.onOptionsItemSelected(item))
        {return true;}

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private class CustomActionBarDrawerToggle extends ActionBarDrawerToggle {

        public CustomActionBarDrawerToggle(Activity mActivity,
                                          DrawerLayout mDrawerLayout) {
            super(mActivity, mDrawerLayout, R.string.Abierto, R.string.Cerrado);
        }

        @Override
        public void onDrawerClosed(View view) {
            super.onDrawerClosed(view);
            ActivityCompat.invalidateOptionsMenu(Inicio.this);
        }

        @Override
        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
            ActivityCompat.invalidateOptionsMenu(Inicio.this);
        }
    }
}
