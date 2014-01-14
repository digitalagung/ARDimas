package com.dynastymasra.augmented.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.dynastymasra.augmented.R;
import com.dynastymasra.augmented.custom.HomeGrid;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

public class Home extends Activity {

    private GridView gridView;
    private String[] text = {"Hotel", "Airport", "Train Station", "Bus Station", "Tour Place", "Restaurant", "Gas Station", "Hospital", "Mosque"};
    private Integer[] image = {R.drawable.hotel, R.drawable.plane, R.drawable.train, R.drawable.bus, R.drawable.tour, R.drawable.food, R.drawable.gas, R.drawable.hospital, R.drawable.mosque};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.home_view);

        HomeGrid homeGrid = new HomeGrid(Home.this, image, text);
        gridView = (GridView) findViewById(R.id.girdViewHome);
        gridView.setAdapter(homeGrid);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //To change body of implemented methods use File | Settings | File Templates.
                Toast.makeText(Home.this, text[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
