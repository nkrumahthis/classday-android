package com.nkrumahsarpong.classday.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nkrumahsarpong.classday.R;

import java.util.ArrayList;

public class DayFragment extends Fragment {
    private static final String ARG_DAY_NUMBER = "day_number";
    private DayViewModel dayViewModel;
    ArrayList<String> lectures = new ArrayList<>();

    public static DayFragment newInstance(int index){
        DayFragment fragment = new DayFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_DAY_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dayViewModel = ViewModelProviders.of(this).get(DayViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_DAY_NUMBER);
        }
        dayViewModel.setIndex(index);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
//        final TextView textView = root.findViewById(R.id.section_label);

        final ListView  listView = root.findViewById(R.id.listView);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, lectures);
        listView.setAdapter(arrayAdapter);

        dayViewModel.getText().observe(this, new Observer<String>(){
            @Override
            public void onChanged(String s) {
//                textView.setText(s);
                lectures.add("add " + s);
            }
        });

        return root;
    }
}
