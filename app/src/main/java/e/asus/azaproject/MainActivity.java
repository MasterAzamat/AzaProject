package e.asus.azaproject;

import android.app.Fragment;
import android.app.FragmentTransaction;
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

import e.asus.azaproject.Fragments.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentAlphabet alphabet;
    FragmentConvert convert;
    FragmentDastur dastur;
    FragmentMatchingWords matchingWords;
    FragmentProfile profile;
    FragmentWords words;
    FragmentTest test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        alphabet =new FragmentAlphabet();
        convert=new FragmentConvert();
        dastur = new FragmentDastur();
        matchingWords= new FragmentMatchingWords();
        profile=new FragmentProfile();
        words=new FragmentWords();
        test=new FragmentTest();

        FragmentTransaction ftrans = getFragmentManager().beginTransaction();
        ftrans.replace(R.id.container,words);
        ftrans.commit();


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

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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

        int id = item.getItemId();
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();


        if (id == R.id.words) {
            ftrans.replace(R.id.container,words);

        } else if (id == R.id.alphabet) {
            ftrans.replace(R.id.container,alphabet);

        } else if (id == R.id.word_matching) {
            ftrans.replace(R.id.container,matchingWords);

        }else if (id == R.id.test) {
            ftrans.replace(R.id.container,test);

        }
        else if (id == R.id.convert) {
            ftrans.replace(R.id.container,convert);

        } else if (id == R.id.dastur) {
            ftrans.replace(R.id.container,dastur);

        } else if (id == R.id.profile) {
            ftrans.replace(R.id.container,profile);

        }
        ftrans.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
