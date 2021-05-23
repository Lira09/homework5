package com.geek.homework5.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.geek.homework5.databinding.FragmentDashBinding;
import com.geek.homework5.databinding.FragmentHomeBinding;


public class DashFragment extends Fragment {



    private FragmentDashBinding binding;
    public DashFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDashBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}