package com.dynastymasra.lbs;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.dynastymasra.lbs.adapter.CustomDrawerAdapter;
import com.dynastymasra.lbs.domain.DrawerItem;
import com.dynastymasra.lbs.fragment.*;
import com.dynastymasra.lbs.fragment.MapsFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private final static LatLng YOGYAKARTA = new LatLng(-7.797069, 110.37053);
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private CustomDrawerAdapter adapter;
    private List<DrawerItem> dataList;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<DrawerItem>();
        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        dataList.add(new DrawerItem("Restaurants & Hotels"));
        dataList.add(new DrawerItem("Hotel +", R.drawable.ic_hotel_icon));
        dataList.add(new DrawerItem("Motel", R.drawable.ic_motel_icon));
        dataList.add(new DrawerItem("Fast Food", R.drawable.ic_fastfood_icon));
        dataList.add(new DrawerItem("Pizzeria +", R.drawable.ic_pizza_icon));
        dataList.add(new DrawerItem("Restaurant", R.drawable.ic_restaurant_icon));
        dataList.add(new DrawerItem("Korean", R.drawable.ic_korean_icon));
        dataList.add(new DrawerItem("Tourism"));
        dataList.add(new DrawerItem("Agritourism", R.drawable.ic_agritourism_icon));
        dataList.add(new DrawerItem("Palace", R.drawable.ic_palace_icon));
        dataList.add(new DrawerItem("Temple", R.drawable.ic_temple_icon));
        dataList.add(new DrawerItem("Mosque", R.drawable.ic_mosque_icon));
        dataList.add(new DrawerItem("Stores"));
        dataList.add(new DrawerItem("Mall", R.drawable.ic_mall_icon));
        dataList.add(new DrawerItem("Market", R.drawable.ic_market_icon));
        dataList.add(new DrawerItem("Supermarket", R.drawable.ic_supermarket_icon));
        dataList.add(new DrawerItem("Health & Education"));
        dataList.add(new DrawerItem("Hospital +", R.drawable.ic_hospital_icon));
        dataList.add(new DrawerItem("Medical Store", R.drawable.ic_medicalstore_icon));
        dataList.add(new DrawerItem("Transportation"));
        dataList.add(new DrawerItem("Airport", R.drawable.ic_airport_icon));
        dataList.add(new DrawerItem("Train Station", R.drawable.ic_train_icon));
        dataList.add(new DrawerItem("Bus Station", R.drawable.ic_bus_icon));
        dataList.add(new DrawerItem("Gas Station", R.drawable.ic_fillingstation_icon));
        dataList.add(new DrawerItem("Others"));
        dataList.add(new DrawerItem("About", R.drawable.ic_about));

        adapter = new CustomDrawerAdapter(this, dataList);

        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        getMaps();

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
                selectItem(1);
        }
    }

    public void getMaps() {
        if(map == null) {
            map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(YOGYAKARTA, 15));
            map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
            map.setMyLocationEnabled(true);
            map.getUiSettings().setCompassEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void selectItem(int possition) {
        switch (possition) {
            case 1:
                map.clear();
                map.addMarker(new MarkerOptions().position(YOGYAKARTA).title("Yogyakarta").snippet("Yogyakarta Province, Indonesia").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_hotel_marker)));

                break;
            case 2:
                map.clear();
                break;
            case 3:
                map.clear();
                break;
            case 4:
                break;
            case 5:
                break;
            case 7:
                break;
        }

        mDrawerList.setItemChecked(possition, true);
        setTitle(dataList.get(possition).getItemName());
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return false;
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (dataList.get(position).getTitle() == null) {
                selectItem(position);
            }
        }
    }
}