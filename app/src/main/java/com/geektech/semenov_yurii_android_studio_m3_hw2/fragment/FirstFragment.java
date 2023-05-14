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

public class FirstFragment extends Fragment {

    private EditText name;
    private EditText surname;
    private Button button;
    private String firstName;
    private String lastName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        click();
    }

    private void findView() {
        name = requireActivity().findViewById(R.id.edit_name);
        surname = requireActivity().findViewById(R.id.edit_surname);
        button = requireActivity().findViewById(R.id.button_next_one);
    }

    private void click() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName = name.getText().toString();
                lastName = surname.getText().toString();

                if (firstName.isEmpty() || lastName.isEmpty()) {
                    Toast.makeText(getActivity(), "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else {

                    SecondFragment secondFragment = new SecondFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("firstName", firstName);
                    bundle.putString("lastName", lastName);
                    secondFragment.setArguments(bundle);

                    requireActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container_view, secondFragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
    }
}