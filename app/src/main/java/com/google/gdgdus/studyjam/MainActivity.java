package com.google.gdgdus.studyjam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        //noinspection ConstantConditions
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                counter = counter + 1;
                // this code runs on click
                Toast.makeText(MainActivity.this, "Hello World! " + counter, Toast.LENGTH_SHORT)
                        .show();
            }
        });

        //TODO use button_decrease to decrease the counter and Toast the new output
    }
}
