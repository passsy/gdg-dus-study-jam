package com.google.gdgdus.studyjam;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<Integer> mImages = Arrays.asList(
            R.drawable.holiday,
            R.drawable.cat1,
            R.drawable.cat2
    );

    int mCounter = 0;

    private LayoutInflater mLayoutInflater;

    private TextView mOutput;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOutput = (TextView) findViewById(R.id.output);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mLayoutInflater = LayoutInflater.from(this);

        final Button second = ((Button) findViewById(R.id.second));
        //noinspection ConstantConditions
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("textKey", "Hello GDG!");

                final Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));

                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // cry
                    throw e;
                }
            }
        });

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public int getCount() {
                return mImages.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

                ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
                imageView.setImageResource(mImages.get(position));

                container.addView(itemView);

                return itemView;
            }

            @Override
            public boolean isViewFromObject(final View view, final Object object) {
                return view == object;
            }
        });

        Button button = (Button) findViewById(R.id.button);
        //noinspection ConstantConditions
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                nextImage();
            }
        });

        //TODO use button_decrease to decrease the mCounter and Toast the new output

        Button decrease = (Button) findViewById(R.id.button_decrease);
        //noinspection ConstantConditions
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                previousImage();
            }
        });
    }

    private void nextImage() {
        mCounter++;
        mCounter %= mImages.size();
    }

    private void previousImage() {
        mCounter--;
        mCounter += mImages.size();
        mCounter %= mImages.size();
    }
}
