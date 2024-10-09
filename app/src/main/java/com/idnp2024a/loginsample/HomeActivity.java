package com.idnp2024a.loginsample;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.idnp2024a.loginsample.fragments.HomeFragment;
import com.idnp2024a.loginsample.fragments.ListaFragment;
import com.idnp2024a.loginsample.fragments.MapaFragment;

public class HomeActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;
    private HomeFragment homeFragment = null;
    private ListaFragment listaFragment = null;
    private MapaFragment mapaFragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragmentManager = getSupportFragmentManager();
        BottomNavigationView bottomNavigationView =findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.menu_home){
                    homeFragment = HomeFragment.newInstance("","");
                    loadFragment(homeFragment);
                    return true;
                } else if (menuItem.getItemId()== R.id.menu_edificaciones) {
                    listaFragment = ListaFragment.newInstance("","");
                    loadFragment(listaFragment);
                    return true;
                }else if (menuItem.getItemId()== R.id.menu_mapa) {
                    mapaFragment = MapaFragment.newInstance("","");
                    loadFragment(mapaFragment);
                    return true;
                }
                else {
                    return false;
                }

            }

    });

    }

    private void loadFragment(Fragment fragment){
        if(fragmentManager!=null){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView2,fragment);
            fragmentTransaction.commit();
        }

    }
}

