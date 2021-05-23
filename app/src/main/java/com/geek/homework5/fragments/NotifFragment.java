package com.geek.homework5.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.geek.homework5.databinding.FragmentDashBinding;
import com.geek.homework5.databinding.FragmentNotificationBinding;


public class NotifFragment extends Fragment {



    private FragmentNotificationBinding binding;
    public NotifFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}