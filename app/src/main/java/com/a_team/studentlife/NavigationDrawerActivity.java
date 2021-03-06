package com.a_team.studentlife;

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
import android.widget.LinearLayout;

import com.a_team.studentlife.navigation_drawer_fragments.FragmentAccount;
import com.a_team.studentlife.navigation_drawer_fragments.FragmentLeague;
import com.a_team.studentlife.navigation_drawer_fragments.FragmentNews;
import com.a_team.studentlife.navigation_drawer_fragments.FragmentSettings;
import com.a_team.studentlife.navigation_drawer_fragments.FragmentStore;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    FragmentAccount fragmentAccount;
    FragmentNews fragmentNews;
    FragmentLeague fragmentLeague;
    FragmentStore fragmentStore;
    FragmentSettings fragmentSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentAccount = new FragmentAccount();
        fragmentNews = new FragmentNews();
        fragmentLeague = new FragmentLeague();
        fragmentStore = new FragmentStore();
        fragmentSettings = new FragmentSettings();

        View headerView = navigationView.getHeaderView(0);

        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentTransaction frTrans = getSupportFragmentManager().beginTransaction();
                frTrans.replace(R.id.container, fragmentAccount).commit();
                setTitle("Личный кабинет");
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        android.support.v4.app.FragmentTransaction frTransaction = getSupportFragmentManager().beginTransaction();
        setTitle("Новости");
        frTransaction.replace(R.id.container, fragmentNews).commit();
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
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        android.support.v4.app.FragmentTransaction frTransaction = getSupportFragmentManager().beginTransaction();

        if (id == R.id.news_menu) {
            setTitle("Новости");
            frTransaction.replace(R.id.container, fragmentNews).commit();
        } else if (id == R.id.league_menu) {
            setTitle("Лиги");
            frTransaction.replace(R.id.container, fragmentLeague).commit();
        } else if (id == R.id.store_menu) {
            setTitle("Магазин");
            frTransaction.replace(R.id.container, fragmentStore).commit();
        } else if (id == R.id.settings_menu) {
            setTitle("Настройки");
            frTransaction.replace(R.id.container, fragmentSettings).commit();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
