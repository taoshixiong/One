package com.taosx.one.View.Home.View;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taosx.one.R;
import com.taosx.one.Util.BaseAdapter.TabLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private TabLayoutAdapter adapter;

    //TabLayout标签
    private String[] titles=new String[]{"图文","阅读","连载","问答"};
//    private String[] titles=new String[]{"图文","阅读","连载","问答","音乐"};
    private List<Fragment> fragments=new ArrayList<>();

    private Fragment hpFragment;
    private Fragment essayFragment;
    private Fragment serialcontentFragment;
    //为了上架先隐藏一些功能
    private Fragment questionFragment;
//    private Fragment musicFragment;

    //保存Fragment的ID，内存不足时会销毁Activity，但是不会销毁Fragment，导致重叠，这里时保存其ID，方便在重启的时候找到其活动
    private int[] fragmentId;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            fragmentId = savedInstanceState.getIntArray("fragmentId");
            if (fragmentId != null) {
                hpFragment=(Fragment) getChildFragmentManager().findFragmentById(fragmentId[0]);
                essayFragment=(Fragment) getChildFragmentManager().findFragmentById(fragmentId[1]);
                serialcontentFragment=(Fragment) getChildFragmentManager().findFragmentById(fragmentId[2]);
                questionFragment=(Fragment) getChildFragmentManager().findFragmentById(fragmentId[3]);
//                musicFragment=(Fragment) getChildFragmentManager().findFragmentById(fragmentId[4]);

                getChildFragmentManager().beginTransaction().hide(hpFragment);
                getChildFragmentManager().beginTransaction().hide(essayFragment);
                getChildFragmentManager().beginTransaction().hide(serialcontentFragment);
//                getChildFragmentManager().beginTransaction().hide(questionFragment);
//                getChildFragmentManager().beginTransaction().hide(musicFragment);
                getChildFragmentManager().beginTransaction().commit();
//            fragments.clear();
            }
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        findView(view);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntArray("fragmentId",new int[]{
                hpFragment.getId(),
                essayFragment.getId(),
                serialcontentFragment.getId()
//                questionFragment.getId(),
//                musicFragment.getId()
        });
        super.onSaveInstanceState(outState);
    }

    private void findView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layou);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);

        //循环注入标签
        for (String tab:titles){
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }

        hpFragment=HpFragment.newInstance();
        essayFragment=EssayFragment.newInstance();
        serialcontentFragment=SerialcontentFragment.newInstance();
        questionFragment=QuestionFragment.newInstance();
//        musicFragment=MusicFragment.newInstance();
        fragments.add(hpFragment);
        fragments.add(essayFragment);
        fragments.add(serialcontentFragment);
        fragments.add(questionFragment);
//        fragments.add(musicFragment);

        adapter=new TabLayoutAdapter(getChildFragmentManager(),titles,fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
