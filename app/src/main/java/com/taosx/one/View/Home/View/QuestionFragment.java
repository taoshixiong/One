package com.taosx.one.View.Home.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taosx.one.R;

/**
 * 问答
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    public QuestionFragment() {
        // Required empty public constructor
    }

    public static QuestionFragment newInstance() {
        QuestionFragment questionFragment = new QuestionFragment();
        return questionFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

}
