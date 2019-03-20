package com.epam.themes.collectionviews.recyclerview;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({ViewType.STUDENT, ViewType.LOADING})
@Retention(RetentionPolicy.SOURCE)
@interface ViewType {
    int STUDENT = 0;
    int LOADING = 1;
}
