package com.epam.themes.collectionviews.recyclerview;

import android.support.v7.util.DiffUtil;

import com.epam.themes.backend.entities.Student;

import java.util.List;

public class DiffUtilCallback extends DiffUtil.Callback {
    private final List<Student> oldList;
    private final List<Student> newList;

    public DiffUtilCallback(List<Student> oldList, List<Student> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItem, int newItem) {
        return !(oldList.get(oldItem) == null || newList.get(newItem) == null)
                && oldList.get(oldItem).getId().equals(newList.get(newItem).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItem, int newItem) {
        return !(oldList.get(oldItem) == null || newList.get(newItem) == null)
                && oldList.get(oldItem).equals(newList.get(newItem));
    }
}
