package com.mj.courseraprw3;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mj.courseraprw3.Adapter.PageAdapter;
import com.mj.courseraprw3.fragment.PerfilFragment;
import com.mj.courseraprw3.fragment.mainFragment;
import com.mj.courseraprw3.pojo.contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements mainFragment.ItemClicked {
    private Toolbar myToolBar;
    private TabLayout myTabLayout;
    private ViewPager myViewPager;
    public  Bundle extras, accountData = new Bundle();;
    public  String myInstgAccount = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolBar   = (Toolbar) findViewById(R.id.myToolBar);
        myTabLayout = (TabLayout) findViewById(R.id.tlMyTabLayout);
        myViewPager = (ViewPager) findViewById(R.id.vpMyViewPager);

        setUpViewPager();
        if(myToolBar != null) {
            setSupportActionBar(myToolBar);
        }

        extras = getIntent().getExtras();
        if (extras != null) {
            myInstgAccount = extras.getString("accountName", "Sin cuenta.");
            accountData.putString("accountName", myInstgAccount);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.miContacto:
                Intent myContactDetail = new Intent(this, contact.class);
                startActivity(myContactDetail);
                break;

            case R.id.miAcercaDe:
                Intent myAcercaDe = new Intent(this, Biography.class);
                startActivity(myAcercaDe);
                break;

            case R.id.myMenuAccount:
                Intent myMenuAccount = new Intent(this, Account.class);
                startActivity(myMenuAccount);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showTopFive(View view){
        Intent myIntent = new Intent(this, top_five.class);
        startActivity(myIntent);
    }

    private ArrayList<Fragment>  agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new mainFragment());
        fragments.add(new PerfilFragment());
        fragments.get(1).setArguments(accountData);
        return fragments;
    }

    private void setUpViewPager () {
        myViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        myTabLayout.setupWithViewPager(myViewPager);
        myTabLayout.getTabAt(0).setIcon(R.mipmap.ic_dog_house);
        myTabLayout.getTabAt(1).setIcon(R.mipmap.ic_dog_face);
    }

    @Override
    public void sendItem(Integer element) {
        PerfilFragment frag = (PerfilFragment)
                getSupportFragmentManager().getFragments().get(1);
        frag.receiveEle(element);
    }
}
