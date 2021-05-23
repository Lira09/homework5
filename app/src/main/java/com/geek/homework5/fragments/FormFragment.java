package com.geek.homework5.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.homework5.Adapter.Model;
import com.geek.homework5.MainActivity;
import com.geek.homework5.R;
import com.geek.homework5.databinding.FragmentFormBinding;
import com.geek.homework5.databinding.FragmentHomeBinding;

import java.text.Normalizer;


public class FormFragment extends Fragment {
    private MainActivity activity;
    private FragmentFormBinding binding;
    private FragmentManager fm;
    Model model;

    public FormFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) requireActivity();
        fm = getActivity().getSupportFragmentManager();
        if (getArguments() != null) {
            model = (Model) getArguments().getSerializable("fa");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater, container, false);
        if (model != null) {
            binding.etName.setText(model.getName());
            binding.etPhoneNum.setText(model.getPhone());
        }

        binding.btnSave.setOnClickListener(v -> {
            String name = binding.etName.getText().toString().trim();
            String phoneNum = binding.etPhoneNum.getText().toString().trim();

            if (name.isEmpty() && phoneNum.isEmpty()) {
                binding.etName.setError("Введите имя");
                binding.etPhoneNum.setError("Введите номер телефона");
            } else {
                Bundle bundle = new Bundle();
                if (model != null) {
                    model.setName(name);
                    model.setPhone(phoneNum);
                    bundle.putSerializable("update", model);
                } else {
                    model = new Model(name, phoneNum);
                    bundle.putSerializable("add", model);
                }
                activity.showBottonNav();
                fm.setFragmentResult("res", bundle);
                fm.popBackStack();
            }

        });

        return binding.getRoot();
    }


}