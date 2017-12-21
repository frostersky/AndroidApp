package com.example.frosterskys.androidapp.restservice;

import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.frosterskys.androidapp.R;
import com.example.frosterskys.androidapp.entity.RamblerPreviewNews;
import com.example.frosterskys.androidapp.restclient.RamblerNewsClient;
import com.example.frosterskys.androidapp.viewentity.RamblerNewsViewEntity;
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
    public void getPreviewNews(String regionName, final LinearLayout linearLayout) throws JSONException {
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
                for(RamblerPreviewNews news : previewNewsList){
                    LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    param.gravity = Gravity.START;
                    RamblerNewsViewEntity ramblerNewsViewEntity = new RamblerNewsViewEntity(
                            linearLayout.getContext(),
                            news.getTopic(),
                            news.getImageLink(),
                            news.getLink()
                    );
                    linearLayout.addView(ramblerNewsViewEntity.getLinearLayout(), param);
                }
            }
        });
    }
}
