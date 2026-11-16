package com.example.proyectodam;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransactionKt;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // DEFAULT PESTAÑA GACHA
        bottomNavigationView.setSelectedItemId(R.id.nav_gacha);

        if (savedInstanceState == null) {
            cargarPestaña(new FragmentoGacha());
        }

        // DETECTAR APARTADO DEL MENU
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_gacha) {
                // CARGAR PESTAÑA GACHA
                cargarPestaña(new FragmentoGacha());

                return true;
            } else if (itemId == R.id.nav_album) {
                // CARGAR PANTALLA ALBUM
                cargarPestaña(new FragmentoAlbum());

                return true;
            } else if (itemId == R.id.nav_perfil) {
                // CARGAR PANTALLA PERFIL
                cargarPestaña(new FragmentoPerfil());

                return true;
            }
            return false;
        });
    }

    protected void cargarPestaña(Fragment fragment) {
        FragmentManager fragmentoApoyo = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaccion = fragmentoApoyo.beginTransaction();
        transaccion.replace(R.id.nav_host_fragment, fragment);
        transaccion.commit();
    }
}