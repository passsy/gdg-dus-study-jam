package com.google.gdgdus.studyjam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int mCounter = 0;

    private ImageView mImage;

    private static List<Integer> mImages = Arrays.asList(
            R.drawable.holiday,
            R.drawable.cat1,
            R.drawable.cat2
    );

    private TextView mOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mOutput = (TextView) findViewById(R.id.output);
        mImage = (ImageView) findViewById(R.id.image);

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
        mOutput.setText("Image #" + mCounter);
        mImage.setImageDrawable(getResources().getDrawable(mImages.get(mCounter)));
    }

    private void previousImage() {
        mCounter--;
        mCounter += mImages.size();
        mCounter %= mImages.size();
        mOutput.setText("Image #" + mCounter);
        mImage.setImageDrawable(getResources().getDrawable(mImages.get(mCounter)));
    }
}
