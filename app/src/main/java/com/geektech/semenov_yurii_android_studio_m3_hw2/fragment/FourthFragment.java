package com.geektech.semenov_yurii_android_studio_m3_hw2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geektech.semenov_yurii_android_studio_m3_hw2.R;

public class FourthFragment extends Fragment {

    private TextView textFirstName;
    private TextView textLastName;
    private TextView textGetAge;
    private TextView textGetGender;
    private TextView textStudy;
    private TextView textWork;
    private String firstName;
    private String lastName;
    private Integer getAge;
    private String getGender;
    private String study;
    private String work;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        arguments();
    }

    private void findView() {
        textFirstName = requireActivity().findViewById(R.id.text_view_two);
        textLastName = requireActivity().findViewById(R.id.text_view_three);
        textGetAge = requireActivity().findViewById(R.id.text_view_four);
        textGetGender = requireActivity().findViewById(R.id.text_view_five);
        textStudy = requireActivity().findViewById(R.id.text_view_six);
        textWork = requireActivity().findViewById(R.id.text_view_seven);
    }

    private void arguments() {
        Bundle bundle1 = getArguments();
        if (bundle1 != null) {
            firstName = bundle1.getString("firstName");
            lastName = bundle1.getString("lastName");
            getAge = bundle1.getInt("getAge");
            getGender = bundle1.getString("getGender");
            study = bundle1.getString("study");
            work = bundle1.getString("work");

            textFirstName.setText(firstName);
            textLastName.setText(lastName);
            textGetAge.setText(String.valueOf(getAge));
            textGetGender.setText(getGender);
            textStudy.setText(study);
            textWork.setText(work);
        }
    }
}