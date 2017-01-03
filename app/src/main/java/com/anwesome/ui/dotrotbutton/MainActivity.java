package com.anwesome.ui.dotrotbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.anwesome.ui.dotrotmodule.AddDotRotHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddDotRotHelper helper = new AddDotRotHelper(this);
        helper.setup();
        helper.addView(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Hello Toaster",Toast.LENGTH_LONG).show();
            }
        });
    }
}
