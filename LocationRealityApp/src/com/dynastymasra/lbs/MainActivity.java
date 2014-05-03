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
import android.widget.Toast;
import com.dynastymasra.lbs.adapter.CustomDrawerAdapter;
import com.dynastymasra.lbs.domain.DrawerItem;
import com.dynastymasra.lbs.fragment.MainFragment;
import com.dynastymasra.lbs.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private CustomDrawerAdapter adapter;
    private List<DrawerItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<DrawerItem>();
        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        dataList.add(new DrawerItem("Places Categories"));
        dataList.add(new DrawerItem("Hotels", R.drawable.ic_hotel));
        dataList.add(new DrawerItem("Transportation"));
        dataList.add(new DrawerItem("Airport", R.drawable.ic_airport));
        dataList.add(new DrawerItem("Train Station", R.drawable.ic_train));
        dataList.add(new DrawerItem("Bus Station", R.drawable.ic_bus));
        dataList.add(new DrawerItem("Tourist Place"));
        dataList.add(new DrawerItem("Park", R.drawable.ic_park));
        dataList.add(new DrawerItem("Temple", R.drawable.ic_temple));
        dataList.add(new DrawerItem("Museum", R.drawable.ic_museum));
        dataList.add(new DrawerItem("Others"));
        dataList.add(new DrawerItem("Gas Station", R.drawable.ic_gas));
        dataList.add(new DrawerItem("Money Changer", R.drawable.ic_money_changer));
        dataList.add(new DrawerItem("ATM", R.drawable.ic_atm));
        dataList.add(new DrawerItem("Mosque", R.drawable.ic_mosque));
        dataList.add(new DrawerItem("Options"));
        dataList.add(new DrawerItem("About", R.drawable.ic_about));

        adapter = new CustomDrawerAdapter(this, dataList);

        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void selectItem(int possition) {
        Fragment fragment = null;
        Bundle args = new Bundle();
        switch (possition) {
            case 1:
                fragment = new MapFragment();
                break;
            case 2:
                fragment = new UserFragment();
                args.putString(UserFragment.ITEM_NAME, "2");
                break;
            case 3:
                fragment = new MainFragment();
                args.putString(MainFragment.ITEM_NAME, "3");
                break;
            case 4:
                fragment = new MainFragment();
                args.putString(MainFragment.ITEM_NAME, "4");
                break;
            case 5:
                fragment = new MainFragment();
                args.putString(MainFragment.ITEM_NAME, "5");
                break;
            case 7:
                fragment = new UserFragment();
                args.putString(UserFragment.ITEM_NAME, "7");
                break;
        }
        FragmentManager frgManager = getFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

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