package com.example.welcomescreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class intro_Activity extends AppCompatActivity {

    ViewPager viewPager;
    welcome_page_adapter welcomePageAdapter;
    LinearLayout dotsLayout;
    AppCompatButton start_button;

    // Array of textview
    TextView[] dots;
    PreferenceManager preferenceManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);




        dotsLayout = findViewById(R.id.dotsLayout);
        start_button = findViewById(R.id.start_button);
        dotsFuction(0);

        preferenceManager = new PreferenceManager(this,"OB");

        if (preferenceManager.isfirstTimeChecl()==1){
            Intent intent = new Intent(intro_Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }


        List<screen_item_model> mlist = new ArrayList<>();

        //Adding Title, description and image
        mlist.add(new screen_item_model("Accept a job", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.car));
        mlist.add(new screen_item_model("Realtime Tracking", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.tracking));
        mlist.add(new screen_item_model("Earn Money", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.money));

        viewPager = findViewById(R.id.viewPager);
        welcomePageAdapter = new welcome_page_adapter(this, mlist);
        viewPager.setAdapter(welcomePageAdapter);




               // set Adapter

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // current page of view pager......when click on get start button then page will change from 0 to 1
                // current position is 1 now...if click on btn
                viewPager.setCurrentItem(1, true);

            }
        });

        //Method for handle dots (page indicator)


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                // dots method call for handle the dots with the view pager page (if go to the next page then dots color will be changed)
                //position variable holdes the position of current page (page number of viewpager)
                dotsFuction(position);

                start_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //if viewpager page is last then run the MainActivity(Welcome screen)
                        // other wise (current position + 1 and go to next page )

                        if (position < 2) {
                            viewPager.setCurrentItem(position + 1, true);
                        } else {
                            preferenceManager.setFirstTimeLaunch(1);
                            Intent intent = new Intent(intro_Activity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    //Method for handle dots:
    private void dotsFuction(int pos) {
        dots = new TextView[3];   // initialize the array of textview with size:
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);                           // create the textview with index i (according to loop)
            dots[i].setText(Html.fromHtml("&#8226;"));              // Create dots......(&#8226;) this is code for circle dots
            dots[i].setTextColor(getColor(R.color.unselect_grey));        // unselected dots color
            dots[i].setTextSize(40);                                     // unselected text (dots size) size

            dotsLayout.addView(dots[i]);                                 // add view of textview of dots from dots[i]

        }

        if (dots.length > 0) {
            dots[pos].setTextSize(40);                                    // selected dots size
            dots[pos].setTextColor(getColor(R.color.grey));               // selected dots color

        }
    }
}