package com.example.myfoodapp.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myfoodapp.utils.helper.PreferenceHelper;
import com.example.myfoodapp.utils.livedata.AppViewModel;

public class BaseFragment extends Fragment {
    PreferenceHelper preferenceHelper;
    AppViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceHelper = new PreferenceHelper(requireActivity());
        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);
    }
}
