package com.taosx.one.View.Home.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.taosx.one.Base.BaseActivity;
import com.taosx.one.View.Home.Entity.DataEntity;
import com.taosx.one.View.Home.Entity.ImageTextEntity;
import com.taosx.one.R;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.EasyRVAdapter;
import com.taosx.one.Util.DateUtil;
import com.taosx.one.Util.GridSpacingItemDecoration;
import com.taosx.one.Util.logger.Logger;
import com.taosx.one.View.Home.Adapter.HpInfoAdapter;
import com.taosx.one.View.Home.Entity.HpItemEntity;
import com.taosx.one.View.Home.Presenter.HpInfoPresenter;
import com.taosx.one.View.Home.Presenter.HpInfoPresenterInterface;

import java.util.ArrayList;
import java.util.List;

public class HpInfoActivity extends BaseActivity implements HpInfoPresenterInterface {

    private HpInfoPresenter hpInfoPresenter;

    private Intent intent;
    private HpItemEntity hpItemEntity;
    private List<DataEntity> list = new ArrayList<>();

    private RecyclerView recyclerView;
    private HpInfoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hp_info);
        intent = getIntent();
        hpInfoPresenter = new HpInfoPresenter(this);

        hpItemEntity = intent.getParcelableExtra(HpFragment.class.getName());
        initToolbar(DateUtil.format(hpItemEntity.getName()));
        if (hpItemEntity.getListData() != null) {
            list.addAll(hpItemEntity.getListData());
        }else{
            Logger.d("传参没有详细数据");
            hpInfoPresenter.getImageTextInfo(hpItemEntity.getName());
        }

        initview();
    }

    private void initview() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,getResources().getDimensionPixelSize(R.dimen.recycler_item_pading),true));
        adapter = new HpInfoAdapter(this, list, R.layout.item_hy_info);
        adapter.setClick(new EasyRVAdapter.OnItemClick<DataEntity>() {
            @Override
            public void onItemClick(View v, int vId, int position, DataEntity item) {
                ImageTextEntity imageTextEntity = new ImageTextEntity();
                imageTextEntity.setData(list);

                intent = new Intent(HpInfoActivity.this, GalleryImageActivity.class);
                intent.putExtra(HpInfoActivity.class.getName(), imageTextEntity);
                intent.putExtra("index", position);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setData(List<DataEntity> dataEntityList) {
        list.clear();
        list.addAll(dataEntityList);
        adapter.notifyDataSetChanged();
    }
}
