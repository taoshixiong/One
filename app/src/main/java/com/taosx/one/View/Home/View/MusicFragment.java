package com.taosx.one.View.Home.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taosx.one.R;

/**
 * 音乐
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {


    public MusicFragment() {
        // Required empty public constructor
    }

    public static MusicFragment newInstance() {
        MusicFragment musicFragment = new MusicFragment();
        return musicFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false);
    }

}
