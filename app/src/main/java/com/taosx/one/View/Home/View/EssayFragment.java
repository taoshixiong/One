package com.taosx.one.View.Home.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taosx.one.R;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.EasyRVAdapter;
import com.taosx.one.View.Home.Adapter.EssayAdapter;
import com.taosx.one.View.Home.Presenter.EssayPresenter;
import com.taosx.one.View.Home.Presenter.EssayPresenterInterface;

/**
 * 阅读
 * A simple {@link Fragment} subclass.
 */
public class EssayFragment extends Fragment {
    private EssayAdapter adapter;
    private RecyclerView recyclerView;
    private EssayPresenterInterface Epi;
    private Intent intent;


    public EssayFragment() {
        // Required empty public constructor
    }


    public static EssayFragment newInstance() {
        EssayFragment essayFragment = new EssayFragment();
        return essayFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_essay, container, false);
        Epi = new EssayPresenter();
        findView(view);
        return view;
    }

    private void findView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerEssay);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        recyclerView.addItemDecoration(new SpaceItemDecoration(12));
        adapter = new EssayAdapter(getContext(), Epi.getDateList(),R.layout.item_essay);
        adapter.setClick(new EasyRVAdapter.OnItemClick<String>() {
            @Override
            public void onItemClick(View v, int vId, int position, String item) {
                intent = new Intent(EssayFragment.this.getContext(), EssayListActivity.class);
                intent.putExtra("Date", item);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

}
