package com.example.frosterskys.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.frosterskys.androidapp.common.MyLeadingMarginSpan2;
import com.example.frosterskys.androidapp.entity.RamblerFullNews;
import com.example.frosterskys.androidapp.entity.RamblerPreviewNews;
import com.example.frosterskys.androidapp.restservice.RamblerNewsService;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import uk.co.deanwild.flowtextview.FlowTextView;

/**
 * Created by evbe0615 on 21-Dec-17.
 */

public class RamblerNewsActivity extends Activity {

    private TextView title;
    private TextView articleView;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rambler_page);

        title = (TextView) findViewById(R.id.title);
        articleView = (TextView) findViewById(R.id.article_content);
        imageView = (ImageView) findViewById(R.id.imageView);

        RamblerPreviewNews ramblerPreviewNews = new RamblerPreviewNews(
                getIntent().getStringExtra("newsTopic"),
                getIntent().getStringExtra("newsImage"),
                getIntent().getStringExtra("newsRef")
        );
        RamblerNewsService ramblerNewsService = new RamblerNewsService();
        try {
            int SDK_INT = android.os.Build.VERSION.SDK_INT;
            if (SDK_INT > 8)
            {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                        .permitAll().build();
                StrictMode.setThreadPolicy(policy);
                RamblerFullNews ramblerFullNews = ramblerNewsService.getNewsContent(ramblerPreviewNews);
                buildNews(ramblerFullNews);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildNews(RamblerFullNews ramblerFullNews){
        title.setText(ramblerFullNews.getTitle());
        Picasso.with(getApplicationContext()).load(ramblerFullNews.getImageRef()).into(imageView);
        SpannableString ss = new SpannableString(ramblerFullNews.getArticle());
        // Выставляем отступ для первых трех строк абазца
        ss.setSpan(new MyLeadingMarginSpan2(4, 10), 0, ss.length(), 0);

        articleView.setText(ss);
    }
}
