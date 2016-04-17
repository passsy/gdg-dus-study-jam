package com.google.gdgdus.studyjam;

import com.squareup.picasso.Picasso;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // https://pbs.twimg.com/media/CgJ7DhNWsAAGJyy.jpg
        final String url = getIntent().getStringExtra("imageUrl");

        Log.v("picture", "url = " + url);

        final ImageView image = (ImageView) findViewById(R.id.image);

        Picasso.with(this)
                .load(Uri.parse(url))
                .into(image);
    }
}
