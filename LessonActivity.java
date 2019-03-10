package com.epam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.epam.cleancodetest.R;

public class LessonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lesson);

        findViewById(R.id.lesson_components_root_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openLesson(MainActivity.class);
            }
        });
    }

    private void openLesson(Class<? extends Activity> lessonActivityClass) {
        startActivity(new Intent(this, lessonActivityClass));
    }
}