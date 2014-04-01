package com.dynastymasra.augmented.custom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.dynastymasra.augmented.view.GridLocationView;
import com.dynastymasra.augmented.view.MapLocationView;
import com.dynastymasra.augmented.view.RealityLocationView;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new GridLocationView();
            case 1:
                return new MapLocationView();
            case 2:
                return new RealityLocationView();
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getCount() {
        return 3;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
