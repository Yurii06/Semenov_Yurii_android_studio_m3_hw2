package com.geektech.semenov_yurii_android_studio_m3_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geektech.semenov_yurii_android_studio_m3_hw2.fragment.FirstFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container_view, new FirstFragment())
                .commit();
    }
}