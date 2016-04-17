package com.google.gdgdus.studyjam;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity {

    private TextView mOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // in chrome - javascript
        //console.log("app started")

        // in pure java
        System.out.println("app started");

        // in android - java
        Log.v("GDG study", "app started");


        // block comment cmd + shift + / (or ctrl+ shift + /)
        /*
        assfd;
        sdf;
        asdf;
        */

        View foundView = findViewById(R.id.my_awesome_button);
        Log.v("found view", "my view: " + foundView);

        mOutput = (TextView) findViewById(R.id.hello_world);

        Button myAwesomeButton = (Button) foundView;

        myAwesomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.v("click", "click");
                try {
                    httpCall("http://jsonplaceholder.typicode.com/posts/1");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



    }

    public void httpCall(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();


        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mOutput.setText("No Internet!");
                    }
                });
            }

            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                final String string = response.body().string();
                Log.v("call", string);

                final JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(string); // <-- may throw an Exception
                    final String title = jsonObject.getString("title");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mOutput.setText(title);
                        }
                    });

                } catch (JSONException e) {
                    // catch the exception from json parsing
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mOutput.setText("Couldn't parse the json");
                        }
                    });
                }



            }
        });
    }
}
