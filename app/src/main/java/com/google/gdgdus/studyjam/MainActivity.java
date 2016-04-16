package com.google.gdgdus.studyjam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mCounter = 0;

    private TextView mOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOutput = (TextView) findViewById(R.id.output);

        Button button = (Button) findViewById(R.id.button);
        //noinspection ConstantConditions
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                mCounter++;
                updateCounterUi();
            }
        });

        //TODO use button_decrease to decrease the mCounter and Toast the new output

        Button decrease = (Button) findViewById(R.id.button_decrease);
        //noinspection ConstantConditions
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mCounter--;
                updateCounterUi();
            }
        });
    }

    private void updateCounterUi() {
        mOutput.setText("Counter: " + mCounter);
    }
}
