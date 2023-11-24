package com.example.welcomescreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class welcome_page_adapter extends PagerAdapter {

    Context mContext;

    // List of screen items to display in the ViewPager
    List<screen_item_model> mListScreen;

    public welcome_page_adapter(Context mContext, List<screen_item_model> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }

    // This method is called when a page is instantiated in the ViewPager
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        // Inflating the layout for a screen item
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_screen, null);

        // Finding views within the inflated layout

        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        ImageView intro_image = view.findViewById(R.id.intro_image);

        title.setText(mListScreen.get(position).getTitle());
        description.setText(mListScreen.get(position).getDescription());
        intro_image.setImageResource(mListScreen.get(position).getScreenImage());

        // Adding the inflated view to the ViewPager container
        container.addView(view);

        return view;


    }

    @Override
    public int getCount() {
        return mListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
