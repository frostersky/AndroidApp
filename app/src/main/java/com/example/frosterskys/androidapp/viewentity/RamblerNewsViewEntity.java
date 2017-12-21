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
import com.squareup.picasso.Picasso;

/**
 * Created by evbe0615 on 21-Dec-17.
 */

public class RamblerNewsViewEntity{

    private LinearLayout linearLayout;

    public RamblerNewsViewEntity(final Context context, String newsTitle, String imageRef) {
        linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.rambler_news, null);
        ImageView imageView = (ImageView) linearLayout.getChildAt(0);
        Picasso.with(context).load(imageRef).into(imageView);
        TextView title = (TextView) linearLayout.getChildAt(1);
        title.setText(newsTitle);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RamblerNewsActivity.class);
                context.getApplicationContext().startActivity(intent);
            }
        });
    }

    public LinearLayout getLinearLayout(){
        return linearLayout;
    }

}
