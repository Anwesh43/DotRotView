package com.anwesome.ui.dotrotbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.dotrotmodule.AddDotRotHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddDotRotHelper helper = new AddDotRotHelper(this);
        helper.setup();
        helper.addView();
    }
}
