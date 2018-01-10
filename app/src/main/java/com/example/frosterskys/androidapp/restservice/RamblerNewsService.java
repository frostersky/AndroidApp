package com.example.frosterskys.androidapp.restservice;

import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.frosterskys.androidapp.R;
import com.example.frosterskys.androidapp.entity.RamblerFullNews;
import com.example.frosterskys.androidapp.entity.RamblerPreviewNews;
import com.example.frosterskys.androidapp.restclient.RamblerNewsClient;
import com.example.frosterskys.androidapp.viewentity.RamblerNewsViewEntity;
import com.loopj.android.http.*;

import org.json.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Frostersky's on 15.12.2017.
 */

public class RamblerNewsService {
    public void setPreviewNews(String regionName, final LinearLayout linearLayout) throws JSONException {
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
                            news
                    );
                    linearLayout.addView(ramblerNewsViewEntity.getLinearLayout(), param);
                }
            }
        });
    }

    public RamblerFullNews getNewsContent(RamblerPreviewNews ramblerPreviewNews) throws IOException {
        Document doc = Jsoup.connect(ramblerPreviewNews.getLink()).get();
        Elements newsArticle = doc.select(".article__content").get(0).children();
        RamblerFullNews ramblerFullNews = new RamblerFullNews();
        ramblerFullNews.setTitle(ramblerPreviewNews.getTopic());
        StringBuilder fullArticle = new StringBuilder();
        for(Element textElement : newsArticle){
            fullArticle.append("\t"+textElement.text()+"\n");
        }
        ramblerFullNews.setArticle(fullArticle.toString());

        Elements sourceElements = doc.select(".big-title__source-n-date a");
        ramblerFullNews.setSource(sourceElements.get(0).text());
        ramblerFullNews.setTime(sourceElements.get(1).text());

        Element imageRefElement = doc.select(".article__main-image--reduced img").get(0);
        ramblerFullNews.setImageRef(imageRefElement.attr("data-src"));
        return ramblerFullNews;

    }
}
