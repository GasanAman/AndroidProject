package com.example.gasan.slidingmenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class VisiMisiFragment extends Fragment {


    public VisiMisiFragment() {
        // Required empty public constructor
    }
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_visi_misi, container, false);

        getActivity().setTitle("Visi Misi");

        return rootView;
    }

}
