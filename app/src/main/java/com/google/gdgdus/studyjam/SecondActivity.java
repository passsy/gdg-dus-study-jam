package com.google.gdgdus.studyjam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final String extra = getIntent().getStringExtra("textKey");

        final TextView text = (TextView) findViewById(R.id.value);
        text.setText(extra);
    }
}
