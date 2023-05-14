package com.geektech.semenov_yurii_android_studio_m3_hw2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geektech.semenov_yurii_android_studio_m3_hw2.R;

public class ThirdFragment extends Fragment {

    EditText placeOfStudy;
    EditText placeOfWork;
    Button button;
    String study;
    String work;
    String firstName;
    String lastName;
    Integer getAge;
    String getGender;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        click();
    }

    private void findView() {
        placeOfStudy = requireActivity().findViewById(R.id.edit_place_of_study);
        placeOfWork = requireActivity().findViewById(R.id.edit_place_of_work);
        button = requireActivity().findViewById(R.id.button_next_three);
    }

    private void click() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                study = placeOfStudy.getText().toString();
                work = placeOfWork.getText().toString();

                if (study.isEmpty() || work.isEmpty()) {
                    Toast.makeText(getActivity(), "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    FourthFragment fourthFragment = new FourthFragment();
                    Bundle bundle = getArguments();
                    if (bundle != null) {
                        firstName = bundle.getString("firstName");
                        lastName = bundle.getString("lastName");
                        getAge = bundle.getInt("getAge");
                        getGender = bundle.getString("getGender");
                    }

                    Bundle bundle1 = new Bundle();
                    bundle1.putString("firstName", getArguments().getString("firstName"));
                    bundle1.putString("lastName", getArguments().getString("lastName"));
                    bundle1.putInt("getAge", getArguments().getInt("getAge"));
                    bundle1.putString("getGender", getArguments().getString("getGender"));
                    bundle1.putString("study", study);
                    bundle1.putString("work", work);
                    fourthFragment.setArguments(bundle1);

                    requireActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container_view, fourthFragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
    }
}