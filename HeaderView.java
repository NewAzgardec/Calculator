package com.example.vkpage;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HeaderView extends LinearLayout {

    private ImageView userImage;
    private TextView userName;
    private TextView userEmail;

    public HeaderView(Context context) {
        this(context, null);
    }

    public HeaderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeaderView(Context context, @Nullable AttributeSet attributeSet, int defStyleAttribute) {
        super(context, attributeSet, defStyleAttribute);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        inflate(getContext(), R.layout.header_compound, this);

        userImage = findViewById(R.id.android_icon);
        userName = findViewById(R.id.name_navigation);
        userEmail = findViewById(R.id.email_navigation);
    }

    public void updateImage(String colorCode) {
        try {
            int color = Color.parseColor(colorCode);
            userImage.setColorFilter(color);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}