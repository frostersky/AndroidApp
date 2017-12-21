package com.example.frosterskys.androidapp.viewentity;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.frosterskys.androidapp.R;
import com.squareup.picasso.Picasso;

/**
 * Created by evbe0615 on 21-Dec-17.
 */

public class RamblerNewsViewEntity{

    private LinearLayout linearLayout;

    public RamblerNewsViewEntity(Context context, String newsTitle, String imageRef) {
        linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.rambler_news, null);
        ImageView imageView = (ImageView) linearLayout.getChildAt(0);
        Picasso.with(context).load(imageRef).into(imageView);
        TextView title = (TextView) linearLayout.getChildAt(1);
        title.setText(newsTitle);
    }

    public LinearLayout getLinearLayout(){
        return linearLayout;
    }

}
