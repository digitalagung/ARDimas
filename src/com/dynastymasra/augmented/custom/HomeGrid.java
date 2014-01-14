package com.dynastymasra.augmented.custom;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dynastymasra.augmented.R;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

public class HomeGrid extends ArrayAdapter<String> {

    private final Activity activitys;
    private final Integer[] images;
    private final String[] texts;

    public HomeGrid(Activity activity, Integer[] image, String[] text) {
        super(activity, R.layout.home_gird, text);
        this.activitys = activity;
        this.images = image;
        this.texts = text;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = activitys.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.home_gird, null, true);
        ImageView imageView = (ImageView) view.findViewById(R.id.homeGridImage);
        TextView textView = (TextView) view.findViewById(R.id.homeGridText);

        imageView.setImageResource(images[position]);
        textView.setText(texts[position]);
        return view;
    }
}
