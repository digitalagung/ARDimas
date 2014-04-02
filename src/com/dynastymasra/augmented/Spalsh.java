package com.dynastymasra.augmented;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.dynastymasra.augmented.activity.MainActivity;
import com.dynastymasra.augmented.view.Home;

public class Spalsh extends Activity {

    private ImageView imageWorld, imageTemple, imageMontain, imageRoute, imageEye;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        imageWorld = (ImageView) findViewById(R.id.drawableWorld);
        imageTemple = (ImageView) findViewById(R.id.drawableTemple);
        imageMontain = (ImageView) findViewById(R.id.drawableMontain);
        imageRoute = (ImageView) findViewById(R.id.drawableRoute);
        imageEye = (ImageView) findViewById(R.id.drawableEye);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
                imageWorld.setVisibility(View.VISIBLE);
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
                imageTemple.setVisibility(View.VISIBLE);
            }
        }, 3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
                imageMontain.setVisibility(View.VISIBLE);
            }
        }, 4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
                imageRoute.setVisibility(View.VISIBLE);
            }
        }, 5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
                imageEye.setVisibility(View.VISIBLE);
            }
        }, 6000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
                Intent intent = new Intent(Spalsh.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 7000);
    }
}
