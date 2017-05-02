package com.taosx.one.View.Home.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taosx.one.Base.BaseFragment;
import com.taosx.one.R;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.EasyRVAdapter;
import com.taosx.one.Util.SpaceItemDecoration;
import com.taosx.one.View.Home.Adapter.HpAdapter;
import com.taosx.one.View.Home.Entity.HpItemEntity;
import com.taosx.one.View.Home.Presenter.HpPresenter;
import com.taosx.one.View.Home.Presenter.HpPresenterInterface;

/**
 * 图文
 * Created by TAO_SX on 2017/4/25/025.
 */

public class HpFragment extends BaseFragment {
    private HpPresenterInterface Hpi;

    private RecyclerView recyclerHome;
    private HpAdapter adapter;


    private Intent intent;
    public HpFragment() {
    }

    public static HpFragment newInstance() {
        HpFragment fragment = new HpFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hp, container, false);
        Hpi = new HpPresenter();
        findView(view);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
    /**
     * 初始化View
     * @param view
     */
    private void findView(View view) {
        recyclerHome = (RecyclerView) view.findViewById(R.id.recyclerHome);
        recyclerHome.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerHome.addItemDecoration(new SpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_item_pading)));

        adapter=new HpAdapter(getContext(),Hpi.getDateList(),R.layout.item_hy);
        adapter.setClick(new EasyRVAdapter.OnItemClick<HpItemEntity>() {
            @Override
            public void onItemClick(View v, int vId, int position, HpItemEntity item) {
                intent = new Intent(HpFragment.this.getContext(), HpInfoActivity.class);
                intent.putExtra(HpFragment.class.getName(),item);
                startActivity(intent);
            }
        });
        recyclerHome.setAdapter(adapter);
    }



}
