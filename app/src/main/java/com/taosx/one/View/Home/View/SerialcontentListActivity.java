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
import com.taosx.one.View.Home.Adapter.SerialcontentAdapter;
import com.taosx.one.View.Home.Entity.SeriacontentListEntity;
import com.taosx.one.View.Home.Presenter.OnSeriacontentListPresenterListener;
import com.taosx.one.View.Home.Presenter.SeriacontentListPresenter;
import com.taosx.one.View.Home.Presenter.SeriacontentListPresenterInterface;

public class SerialcontentListActivity extends BaseActivity implements OnSeriacontentListPresenterListener {
    private RecyclerView recyclerView;
    private SerialcontentAdapter adapter;
    private SeriacontentListPresenterInterface Slpi;

    private Intent intent;
    private String mDate = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serialcontent_list);
        mDate = getIntent().getStringExtra("Date");
        initToolbar(DateUtil.format(mDate));
        findview();
    }

    private void findview() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new SpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_item_pading)));
        adapter = new SerialcontentAdapter(this, null, R.layout.item_essay_list);
        adapter.setClick(new EasyRVAdapter.OnItemClick<SeriacontentListEntity.SeriacontentEntity>() {
            @Override
            public void onItemClick(View v, int vId, int position, SeriacontentListEntity.SeriacontentEntity item) {
                intent = new Intent(SerialcontentListActivity.this, SerialcontentListInfoActivity.class);
                intent.putExtra("Title", item.getTitle());
                intent.putExtra("Id", item.getId());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        Slpi = new SeriacontentListPresenter(this);
        Slpi.getEssayData(mDate);
    }

    @Override
    public void OnLoadData(SeriacontentListEntity seriacontentListEntity) {
        adapter.addAll(seriacontentListEntity.getData());
    }
}
