package com.geek.homework5.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.homework5.Adapter.Adapter;
import com.geek.homework5.Adapter.Model;
import com.geek.homework5.MainActivity;
import com.geek.homework5.R;
import com.geek.homework5.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    private FragmentManager fm;
    private Adapter adapter;
    int num;
    private MainActivity mainActivity;
    private FragmentHomeBinding binding;

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getActivity().getSupportFragmentManager();


        adapter = new Adapter((model, position) -> {
            num = position;
            FormFragment formFragment = new FormFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("fa", model);
            formFragment.setArguments(bundle);
            fm.beginTransaction().replace(R.id.fm_container, formFragment).addToBackStack(null).commit();

        });
        mainActivity = (MainActivity) requireActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding.rvTarget.setAdapter(adapter);

        binding.fab.setOnClickListener(v -> {
            fm.beginTransaction().replace(R.id.fm_container, new FormFragment()).addToBackStack(null).commit();
            mainActivity.hideBottonNav();

        });


        fm.setFragmentResultListener("res", this, (requestKey, result) -> {
            Model model;
            if (result.getSerializable("update") != null) {
                model = (Model) result.getSerializable("update");
                adapter.update(model, num);
            } else {
                model = (Model) result.getSerializable("add");
                adapter.adds(model);
            }

        });
        return binding.getRoot();
    }
}