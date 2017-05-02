package com.taosx.one.View.Home.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.taosx.one.Base.BaseActivity;
import com.taosx.one.R;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.EasyRVAdapter;
import com.taosx.one.Util.DateUtil;
import com.taosx.one.Util.SpaceItemDecoration;
import com.taosx.one.View.Home.Adapter.EssayListAdapter;
import com.taosx.one.View.Home.Entity.EssayEntity;
import com.taosx.one.View.Home.Presenter.EssayListPresenter;
import com.taosx.one.View.Home.Presenter.EssayListPresenterInterface;
import com.taosx.one.View.Home.Presenter.OnEssayListPresenterListener;

public class EssayListActivity extends BaseActivity implements OnEssayListPresenterListener {
    private EssayListAdapter adapter;
    private RecyclerView recyclerView;
    private EssayListPresenterInterface ELpi;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay_list);
        ELpi = new EssayListPresenter(this);
        initToolbar(DateUtil.format(getIntent().getStringExtra("Date")));
        ELpi.getEssayData(getIntent().getStringExtra("Date"));
        initView();
    }

    private void initView() {
        adapter = new EssayListAdapter(this, R.layout.item_essay_list);
        adapter.setClick(new EasyRVAdapter.OnItemClick<EssayEntity.EssayDataEntity>() {
            @Override
            public void onItemClick(View v, int vId, int position, EssayEntity.EssayDataEntity item) {
                intent = new Intent(EssayListActivity.this, EssayListInfoActivity.class);
                intent.putExtra("Title", item.getHp_title());
                intent.putExtra("Id", item.getContent_id());
                startActivity(intent);
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new SpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_item_pading)));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnLoadData(EssayEntity essayEntity) {
        adapter.addAll(essayEntity.getData());
    }
}
