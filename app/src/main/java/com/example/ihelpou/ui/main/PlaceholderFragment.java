package com.example.ihelpou.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ihelpou.classes.GestClassDB;
import com.example.ihelpou.databinding.FragmentAidsBinding;
import com.example.ihelpou.fragments.AidsFragment;
import com.example.ihelpou.fragments.HelpSeekerFragment;
import com.example.ihelpou.models.User;

public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    private FragmentAidsBinding binding;
    private static GestClassDB gestClassDB = new GestClassDB();

    public static Fragment newInstance(int index, User user) {
        Fragment fragment = null;
        switch (index) {
            case 1:
                fragment = new AidsFragment(user);
                break;
            case 2:
                fragment = new HelpSeekerFragment(user);
                break;
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentAidsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}