package com.google.gdgdus.studyjam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        //noinspection ConstantConditions
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                counter = counter + 1;
                // this code runs on click
                updateCounterUi(text);
            }
        });

        if (savedInstanceState != null) {
            Log.v("save state", "reading saved state");
            counter = savedInstanceState.getInt("count");
            User user = savedInstanceState.getParcelable("user");
            updateCounterUi(text);
        }

        //TODO use button_decrease to decrease the counter and Toast the new output
    }

    private void updateCounterUi(final TextView text) {
        text.setText("Count " + counter);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        final User user = new User(12, "someId", "Girl");
        outState.putInt("count", counter);
        outState.putParcelable("user", user);
    }

}
