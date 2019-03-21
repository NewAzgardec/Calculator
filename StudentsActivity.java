package com.epam.themes.collectionviews;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.annotation.NonNull;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.epam.themes.collectionviews.recyclerview.StudentTouchCallback;
import com.epam.themes.util.StudentAdapterCallback;

import java.util.Random;

import static com.epam.themes.backend.StudentsWebService.MAX_HW_COUNT;
import static com.epam.themes.backend.StudentsWebService.NULL_ID;
import static com.epam.themes.backend.StudentsWebService.nameStudents;

import com.epam.cleancodetest.R;
import com.epam.themes.backend.IWebService;
import com.epam.themes.backend.StudentsWebService;
import com.epam.themes.backend.entities.Student;
import com.epam.themes.collectionviews.recyclerview.StudentsAdapter;
import com.epam.themes.util.ICallback;

import java.util.List;

public class StudentsActivity extends AppCompatActivity {

    public static final int MAX_ITEMS = 100;
    public static final String LAYOUT_MANAGER_KEY = "LayoutManagerKey";
    public static final String STUDENT_LIST_KEY = "studentListKey";
    public static final String IS_SHOW_LAST_VIEW_AS_LOADING_STATE_KEY = "isShowLastViewAsLoadingStateKey";
    public static final String IS_LOAD_COMPLETE_STATE_KEY = "isLoadCompleteStateKey";
    private final IWebService<Student> studentsWebService = new StudentsWebService();
    public static final int PAGE_SIZE = 10;
    private boolean isLoadComplete = false;
    private boolean isLoading = false;
    private StudentsAdapter studentsAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ImageView addStudentImageButton;
    private Random random = new Random();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_students);
        setupAddButton();
        setupRecyclerView();
        if (savedInstanceState != null) {
            studentsAdapter.addItems(savedInstanceState.<Student>getParcelableArrayList(STUDENT_LIST_KEY));
            linearLayoutManager.onRestoreInstanceState(savedInstanceState.getParcelable(LAYOUT_MANAGER_KEY));
            studentsAdapter.setShowLastViewAsLoading(savedInstanceState.getBoolean(IS_SHOW_LAST_VIEW_AS_LOADING_STATE_KEY));
            isLoadComplete = savedInstanceState.getBoolean(IS_LOAD_COMPLETE_STATE_KEY);
        } else {
            loadMoreItems(0, PAGE_SIZE);
        }
    }

    private void setupAddButton() {
        addStudentImageButton = findViewById(R.id.addStudentImageButton);
        addStudentImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Student newStudent = new Student()
                        .setId(NULL_ID)
                        .setName(nameStudents.get(random.nextInt(nameStudents.size())))
                        .setHwCount(random.nextInt(MAX_HW_COUNT));
                int insertPosition = linearLayoutManager.findFirstVisibleItemPosition() + 1;

                studentsWebService.insertEntity(insertPosition, newStudent, new ICallback<Long>() {
                    @Override
                    public void onResult(Long result) {
                        newStudent.setId(result);
                    }
                });
                studentsAdapter.insertItem(insertPosition, newStudent);
            }
        });
    }

    private void setupRecyclerView() {
        final RecyclerView studentsRecyclerView = findViewById(android.R.id.list);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        studentsRecyclerView.setLayoutManager(linearLayoutManager);
        studentsAdapter = new StudentsAdapter(new StudentAdapterCallback() {

            @Override
            public void onStudentChange(Student student) {
                studentsWebService.setHomework(student.getId(), student.getHwCount());
            }

            @Override
            public void onStudentRemove(long id) {
                studentsWebService.removeEntity(id);
                checkNeedAndLoadMore();
            }
        }, this);


        studentsRecyclerView.setAdapter(studentsAdapter);
        studentsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                checkNeedAndLoadMore();
            }
        });

        new ItemTouchHelper(new StudentTouchCallback(studentsAdapter)).attachToRecyclerView(studentsRecyclerView);

    }

    private void checkNeedAndLoadMore() {
        int totalItemCount = linearLayoutManager.getItemCount() - 1;

        if (totalItemCount >= MAX_ITEMS || isLoadComplete) {
            studentsAdapter.setShowLastViewAsLoading(false);
            return;
        }

        int visibleItemCount = linearLayoutManager.getChildCount();
        int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

        if (!isLoading) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0) {
                loadMoreItems(totalItemCount, totalItemCount + PAGE_SIZE);
            }
        }
    }

    private void loadMoreItems(final int startPosition, final int endPosition) {
        isLoading = true;
        studentsAdapter.setShowLastViewAsLoading(true);
        studentsWebService.getEntities(startPosition, endPosition, new ICallback<List<Student>>() {
            @Override
            public void onResult(List<Student> resultList) {
                if (resultList != null) {
                    if (resultList.size() < PAGE_SIZE) {
                        isLoadComplete = true;
                    }

                    studentsAdapter.addItems(resultList);
                } else {
                    isLoadComplete = true;
                }

                isLoading = false;
            }
        });
    }
}







