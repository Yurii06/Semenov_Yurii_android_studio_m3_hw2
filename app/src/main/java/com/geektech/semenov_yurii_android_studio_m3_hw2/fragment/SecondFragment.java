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

public class SecondFragment extends Fragment {

    private EditText age;
    private EditText gender;
    private Button button;
    private String getAge;
    private String getGender;
    private String firstName;
    private String lastName;
    private Integer ageOne;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        click();
    }

    private void findView() {
        age = requireActivity().findViewById(R.id.edit_age);
        gender = requireActivity().findViewById(R.id.edit_gender);
        button = requireActivity().findViewById(R.id.button_next_two);
    }

    private void click() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAge = age.getText().toString();
                getGender = gender.getText().toString();

                if (getAge.isEmpty() || getGender.isEmpty()) {
                    Toast.makeText(getActivity(), "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        ageOne = Integer.parseInt(getAge);
                    } catch (NumberFormatException e) {
                        Toast.makeText(getActivity(), "Укажите возраст", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    ThirdFragment thirdFragment = new ThirdFragment();
                    Bundle bundle = getArguments();
                    if (bundle != null) {
                        firstName = bundle.getString("firstName");
                        lastName = bundle.getString("lastName");
                    }

                    Bundle bundle1 = new Bundle();
                    bundle1.putString("firstName", getArguments().getString("firstName"));
                    bundle1.putString("lastName", getArguments().getString("lastName"));
                    bundle1.putInt("getAge", ageOne);
                    bundle1.putString("getAge", getGender);
                    thirdFragment.setArguments(bundle);

                    requireActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container_view, thirdFragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
    }
}