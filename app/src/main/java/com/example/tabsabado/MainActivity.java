package com.example.tabsabado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabMenu;
    ViewPager vistaPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabMenu=findViewById(R.id.tabMenu);
        vistaPager=findViewById(R.id.vistaPager);

        Adaptador adaptador= new Adaptador(getSupportFragmentManager(),tabMenu.getTabCount());
        vistaPager.setAdapter(adaptador);

        tabMenu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                vistaPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition()==1){

                    adaptador.notifyDataSetChanged();

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        vistaPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabMenu));

    }
}