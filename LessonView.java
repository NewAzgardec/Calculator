package com.epam.themes.uicomponents;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.TextView;

import com.epam.cleancodetest.R;
import com.epam.themes.uicomponents.base.CompoundRelativeLayout;

public class LessonView extends CompoundRelativeLayout {

    private TextView dateView;
    private TextView themeView;

    private String attributeDate;
    private String attributeTheme;

    public LessonView(final Context context) {

        super(context);
    }

    public LessonView(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        parseAttributes(context, attrs);
    }

    public LessonView(final Context context, final AttributeSet attrs, final int defAttrs) {
        super(context, attrs, defAttrs);

        parseAttributes(context, attrs);
    }


    @Override
    public void onViewInflated(@NonNull final Context context) {
        dateView = findViewById(R.id.dateView);
        themeView = findViewById(R.id.themeView);
    }

    @Override
    public int getLayoutResId() {

        return R.layout.view_lesson;
    }

    private void parseAttributes(final Context context, final AttributeSet attrs) {
        final Resources.Theme theme = context.getTheme();
        final TypedArray styledAttributes = theme.obtainStyledAttributes(attrs, R.styleable.LessonView, 0, 0);

        try {
            attributeDate = styledAttributes.getString(R.styleable.LessonView_lessonDate);
            attributeTheme = styledAttributes.getString(R.styleable.LessonView_lessonTheme);

            dateView.setText(attributeDate);
            themeView.setText(attributeTheme);
        } finally {
            styledAttributes.recycle();
        }
    }
}
