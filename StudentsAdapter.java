package com.epam.themes.collectionviews.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.epam.themes.uicomponents.base.BaseViewHolder;

import android.view.ViewGroup;

import com.epam.cleancodetest.R;
import com.epam.themes.backend.entities.Student;
import com.epam.themes.util.StudentAdapterCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final StudentAdapterCallback studentAdapterCallback;
    private boolean isShowLastViewAsLoading = false;
    private final LayoutInflater layoutInflater;
    private final List<Student> studentList = new ArrayList<>();

    public StudentsAdapter(StudentAdapterCallback studentAdapterCallback, final Context context) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.studentAdapterCallback = studentAdapterCallback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup,
                                                      @ViewType final int viewType) {
        if (viewType == ViewType.STUDENT) {
            return new BaseViewHolder<>(new StudentView(viewGroup.getContext()));

        } else {
            return new BaseViewHolder<>(layoutInflater.inflate(R.layout.layout_progress, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int position) {
        if (getItemViewType(position) == ViewType.STUDENT) {
            final Student student = studentList.get(position);

            ((StudentView) viewHolder.itemView)
                    .setStudentName(student.getName())
                    .setStudentHwCount(String.valueOf(student.getHwCount()));
        }
    }

    @ViewType
    @Override
    public int getItemViewType(final int position) {
        if (position < studentList.size()) {
            return ViewType.STUDENT;
        } else {
            return ViewType.LOADING;
        }
    }

    @Override
    public int getItemCount() {
        if (isShowLastViewAsLoading) {
            return studentList.size() + 1;
        } else {
            return studentList.size();
        }
    }

    public void setShowLastViewAsLoading(final boolean isShow) {
        if (isShow != isShowLastViewAsLoading) {
            isShowLastViewAsLoading = isShow;
            notifyDataSetChanged();
        }
    }

    public void addItems(List<Student> studentList) {

        List<Student> newList = new ArrayList<>();
        newList.addAll(this.studentList);
        newList.addAll(studentList);

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtilCallback(this.studentList, newList));
        this.studentList.addAll(studentList);
        diffResult.dispatchUpdatesTo(this);
    }

    public void insertItem(final int position, final Student student) {
        studentList.add(position, student);
        notifyItemInserted(position);
    }

    public void onItemMove(int fromPosition, int toPosition) {
        if (getItemViewType(fromPosition) == ViewType.STUDENT && getItemViewType(toPosition) == ViewType.STUDENT) {
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(studentList, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(studentList, i, i - 1);
                }
            }

            notifyItemMoved(fromPosition, toPosition);
        }
    }

    public void onItemDismiss(int adapterPosition) {
        deleteByIndex(adapterPosition);
    }

    private void deleteByIndex(int i) {
        studentList.remove(i);
        notifyItemRemoved(i);
    }

    public void onItemChange(int adapterPosition) {
        if (getItemViewType(adapterPosition) == ViewType.STUDENT) {
            Student student = studentList.get(adapterPosition);
            student.setHwCount(student.getHwCount() + 1);
            studentAdapterCallback.onStudentChange(student);
        }

        notifyItemChanged(adapterPosition);

    }
}
