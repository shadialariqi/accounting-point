package com.example.end;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class expeness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expeness);
    }

    public void manger_expenes(View view) {

        Intent intent = new Intent(getApplicationContext(),expeness1.class);
        startActivity(intent);
    }
}
