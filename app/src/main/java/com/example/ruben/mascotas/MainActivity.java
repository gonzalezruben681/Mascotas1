package com.example.ruben.mascotas;

import android.content.Intent;
import android.os.Bundle;

import com.example.ruben.mascotas.adapter.MascotasAdaptador;
import com.example.ruben.mascotas.adapter.PageAdaptador;
import com.example.ruben.mascotas.fragment.ListaPerroFragment;
import com.example.ruben.mascotas.fragment.RecyclerViewFragment;
import com.example.ruben.mascotas.pojo.DataSet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ImageButton estrella;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        estrella = (ImageButton) findViewById(R.id.estrella);

        setUpViewPager();




        if (toolbar != null){
            setSupportActionBar(toolbar);
        }


        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaMascotas.class);
                startActivity(intent);

            }
        });




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hola estas en la App Mascotas", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú; esto agrega elementos a la barra de acción si está presente.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejar los clics del elemento de la barra de acciones aquí. La barra de acción
        // manejar automáticamente los clics en el botón Inicio / Arriba, siempre que
        // cuando especifica una actividad principal en AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_acerca:
                Intent i = new Intent(MainActivity.this, Acerca.class);
                startActivity(i);
                break;
            case R.id.action_contacto:
                Intent intent = new Intent(MainActivity.this, Contacto.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new ListaPerroFragment());
        return fragments;
    }

    public  void setUpViewPager(){
        viewPager.setAdapter(new PageAdaptador(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perro);
    }

}