package com.epam.themes.collectionviews.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.epam.cleancodetest.R;
import com.epam.themes.uicomponents.base.CompoundRelativeLayout;


public class StudentView extends CompoundRelativeLayout {

    private String studentNameStr;
    private TextView studentNameTextView;
    private TextView studentHwCountTextView;
    private ImageView studentAvatarView;
    private String attributeStudentName;
    private String attributeStudentHwNumber;
    private CardView cardView;

    public StudentView(Context context) {
        super(context);
    }

    public StudentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(context, attrs);
    }

    public StudentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttributes(context, attrs);
    }

    @Override
    public void onViewInflated(@NonNull final Context context) {

        studentNameTextView = findViewById(R.id.student_name);
        studentHwCountTextView = findViewById(R.id.student_homework_count);
        studentAvatarView = findViewById(R.id.student_avatar);
        cardView = findViewById(R.id.students_card_view);
    }

    @Override
    public int getLayoutResId() {

        return R.layout.student_view;
    }

    @UiThread
    public StudentView setStudentName(final String studentName) {
        studentNameTextView.setText(studentName);
        setStudentNameStr(studentName);

        return this;
    }

    @UiThread
    public StudentView setStudentHwCount(final String studentHw) {
        studentHwCountTextView.setText(studentHw);

        return this;
    }

    private void parseAttributes(final Context pContext, final AttributeSet pAttrs) {
        final Resources.Theme theme = pContext.getTheme();
        final TypedArray styledAttributes = theme.obtainStyledAttributes(pAttrs, R.styleable.StudentView, 0, 0);

        try {
            attributeStudentName = styledAttributes.getString(R.styleable.StudentView_studentName);
            attributeStudentHwNumber = styledAttributes.getString(R.styleable.StudentView_studentAge);

            studentNameTextView.setText(attributeStudentName);
            studentHwCountTextView.setText(attributeStudentHwNumber);
        } finally {
            styledAttributes.recycle();
        }
    }

    public StudentView setStudentAvatar(Drawable studentAvatar) {
        studentAvatarView.setImageDrawable(studentAvatar);

        return this;
    }

    public void setStudentNameStr(String studentNameStr) {

        this.studentNameStr = studentNameStr;
    }

}