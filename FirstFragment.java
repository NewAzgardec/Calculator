package com.example.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    private static final String CURRENT_TEXT = "currentText";
    private static final String NEW_LINE = "\n:)";
    private TextView textView;
    private Button button;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        button = view.findViewById(R.id.button);
        textView = view.findViewById(R.id.textView);

        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(CURRENT_TEXT));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append(NEW_LINE);
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(CURRENT_TEXT, textView.getText().toString());
    }
}