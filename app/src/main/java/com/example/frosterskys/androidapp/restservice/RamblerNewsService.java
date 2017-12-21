package com.example.frosterskys.androidapp.restservice;

import android.util.Log;
import android.widget.TextView;

import com.example.frosterskys.androidapp.R;
import com.example.frosterskys.androidapp.entity.RamblerPreviewNews;
import com.example.frosterskys.androidapp.restclient.RamblerNewsClient;
import com.loopj.android.http.*;

import org.json.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Frostersky's on 15.12.2017.
 */

public class RamblerNewsService {
    public void getPreviewNews(String regionName, final TextView textView) throws JSONException {
        final List<RamblerPreviewNews> previewNewsList = new ArrayList<>();
        RamblerNewsClient.get("/news/getRamblerNews/"+regionName, null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        RamblerPreviewNews ramblerPreviewNews = new RamblerPreviewNews(
                                jsonObject.getString("topic"),
                                jsonObject.getString("imageRef"),
                                jsonObject.getString("href")
                        );
                        previewNewsList.add(ramblerPreviewNews);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String text = "";
                for(RamblerPreviewNews news : previewNewsList){
                    text+=news.getTopic();
                    text+=news.getImageLink()+"\n";
                    text+=news.getLink()+"\n\n";
                }
                textView.setText(text);
            }
        });

    }
}
