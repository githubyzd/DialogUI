package com.dialog.helper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void popup(View view) {
        startActivity(new Intent(this, PopupWindowActivity.class));
    }

    public void dialog(View view) {
        startActivity(new Intent(this, DialogActivity.class));
    }


}
