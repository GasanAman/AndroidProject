package com.example.gasan.slidingmenu;

import android.app.*;
import android.os.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;




public class LeftSideMenu extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {
    private ProgressDialog pDialog;
    ProgressDialog prDialog;
    Toolbar toolbar = null;
    NavigationView navigationView = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_side_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BeritaFragment beritaFrag = new BeritaFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, beritaFrag);
        fragmentTransaction.commit();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            fragment = new BeritaFragment();
            callFragment(fragment);
        }

//        WebView webBerita = (WebView) findViewById(R.id.webberita);
//        WebView webAward = (WebView) findViewById(R.id.webaward) ;
//        webBerita.loadUrl("http://green-nitrogen.com/website/info/berita.html");



    }


//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        //ketika disentuh tombol back
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && webBerita.canGoBack()) {
//            webBerita.goBack(); //method goback(),untuk kembali ke halaman sebelumnya
//            return true;
//        }
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && webAward.canGoBack()) {
//            webAward.goBack(); //method goback(),untuk kembali ke halaman sebelumnya
//            return true;
//        }
//        // Jika tidak ada halaman yang pernah dibuka
//        // maka akan keluar dari activity (tutup aplikasi)
//        return super.onKeyDown(keyCode, event);
//    }







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
        getMenuInflater().inflate(R.menu.left_side_menu, menu);
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

        if (id == R.id.nav_home) {
            // Handle the camera action
            BeritaFragment beritaFrag = new BeritaFragment();
            callFragment(beritaFrag);
        } else if (id == R.id.nav_peta) {

        } else if (id == R.id.nav_berita) {
            BeritaFragment beritaFrag = new BeritaFragment();
            callFragment(beritaFrag);
        } else if (id == R.id.nav_award) {
            AwardFragment awardFrag = new AwardFragment();
            callFragment(awardFrag);
        } else if (id == R.id.nav_promo) {
            PromoFragment promoFrag = new PromoFragment();
            callFragment(promoFrag);
        } else if (id == R.id.nav_garansi) {
            GaransiFragment garansiFrag = new GaransiFragment();
            callFragment(garansiFrag);
        } else if (id == R.id.nav_asuransi) {
            AsuransiFragment asuransiFrag = new AsuransiFragment();
            callFragment(asuransiFrag);
        } else if (id == R.id.nav_tentang) {
            TentangFragment tentangFrag = new TentangFragment();
            callFragment(tentangFrag);
        } else if (id == R.id.nav_visi) {
            VisiMisiFragment visiMisiFrag = new VisiMisiFragment();
            callFragment(visiMisiFrag);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void callFragment(Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.remove(fragment);
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
