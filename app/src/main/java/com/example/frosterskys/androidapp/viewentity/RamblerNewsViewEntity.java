package com.example.frosterskys.androidapp.viewentity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.frosterskys.androidapp.R;
import com.example.frosterskys.androidapp.RamblerNewsActivity;
import com.example.frosterskys.androidapp.entity.RamblerPreviewNews;
import com.squareup.picasso.Picasso;

/**
 * Created by evbe0615 on 21-Dec-17.
 */

public class RamblerNewsViewEntity{

    private LinearLayout linearLayout;

    public RamblerNewsViewEntity(final Context context, final RamblerPreviewNews ramblerPreviewNews) {
        linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.rambler_preview_news, null);
        ImageView imageView = (ImageView) linearLayout.getChildAt(0);
        Picasso.with(context).load(ramblerPreviewNews.getImageLink()).into(imageView);
        TextView title = (TextView) linearLayout.getChildAt(1);
        title.setText(ramblerPreviewNews.getTopic());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RamblerNewsActivity.class);
                intent.putExtra("newsRef", ramblerPreviewNews.getLink());
                intent.putExtra("newsImage", ramblerPreviewNews.getImageLink());
                intent.putExtra("newsTopic", ramblerPreviewNews.getTopic());
                context.getApplicationContext().startActivity(intent);
            }
        });
    }

    public LinearLayout getLinearLayout(){
        return linearLayout;
    }

}
