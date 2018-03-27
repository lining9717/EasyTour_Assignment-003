package com.example.lining.easytour;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<Lobby_Item> lobby_items = new ArrayList<>();
    private Spinner sp_time;
    private Spinner sp_place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        List<String> place = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            place.add("CQU");
        }

        List<String> time = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            time.add("3/26/2018");
        }

        sp_time = findViewById(R.id.spinner_time);
        sp_place = findViewById(R.id.spinner_place);
        initSpinner(sp_place,place);
        initSpinner(sp_time,time);

        generateListContent();
        Lobby_Item_Adapter lobby_item_adapter = new Lobby_Item_Adapter(getBaseContext(),R.layout.lobby_item,lobby_items);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(lobby_item_adapter);
    }

    public void initSpinner(Spinner spinner,List<String> data){
        final List<String> datas = data;
        Spinner_Adapter spinner_adapter = new Spinner_Adapter(this);
        spinner.setAdapter(spinner_adapter);

        spinner_adapter.setDatas(datas);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Click " + datas.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    private void generateListContent(){
        final String[] list = {"重大3/25虎溪3","重大3/25虎溪3","重大3/25虎溪3","重大3/25虎溪3","重大3/25虎溪3","重大3/25虎溪3","重大3/25虎溪3"};
        for(String element:list){
            String title = element.substring(0,2);
            String date = element.substring(2,6);
            String content = element.substring(6,8);
            int day = Integer.parseInt(element.substring(8));
            lobby_items.add(new Lobby_Item(title,date,content,day));
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this,"Coding",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.lobby) {

        } else if (id == R.id.order) {

        } else if (id == R.id.message) {

        } else if(id == R.id.setting){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
