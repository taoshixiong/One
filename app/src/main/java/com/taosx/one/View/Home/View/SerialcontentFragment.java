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
import com.taosx.one.View.Home.Presenter.SerialcontentPresenter;
import com.taosx.one.View.Home.Presenter.SerialcontentPresenterInterface;

/**
 * 连载
 * A simple {@link Fragment} subclass.
 */
public class SerialcontentFragment extends Fragment {
    private EssayAdapter adapter;
    private RecyclerView recyclerView;
    private SerialcontentPresenterInterface Spi;
    private Intent intent;

    public SerialcontentFragment() {
        // Required empty public constructor
    }

    public static SerialcontentFragment newInstance() {
        SerialcontentFragment serialcontentFragment = new SerialcontentFragment();
        return serialcontentFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_serialcontent, container, false);
        Spi = new SerialcontentPresenter();
        findView(view);
        return view;
    }
    private void findView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        recyclerView.addItemDecoration(new SpaceItemDecoration(12));
        adapter = new EssayAdapter(getContext(), Spi.getDateList(),R.layout.item_essay);
        adapter.setClick(new EasyRVAdapter.OnItemClick<String>() {
            @Override
            public void onItemClick(View v, int vId, int position, String item) {
                intent = new Intent(SerialcontentFragment.this.getContext(), SerialcontentListActivity.class);
                intent.putExtra("Date", item);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
