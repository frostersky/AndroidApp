package com.example.frosterskys.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.frosterskys.androidapp.entity.RamblerPreviewNews;
import com.example.frosterskys.androidapp.restservice.RamblerNewsService;

import org.json.JSONException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RamblerNewsService ramblerNewsService= new RamblerNewsService();
        try {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.newsLinearLayout);
            ramblerNewsService.setPreviewNews("Воронеж", linearLayout);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
