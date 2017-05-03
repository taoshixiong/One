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
import com.taosx.one.View.Home.Adapter.QuestionListAdapter;
import com.taosx.one.View.Home.Entity.QuestionListEntity;
import com.taosx.one.View.Home.Presenter.OnQuestionListPresenterListener;
import com.taosx.one.View.Home.Presenter.QuestionListPresenter;
import com.taosx.one.View.Home.Presenter.QuestionListPresenterInterface;

public class QuestionListActivity extends BaseActivity implements OnQuestionListPresenterListener {
    private QuestionListPresenterInterface questionListPresenterInterface;
    private RecyclerView recyclerView;
    private QuestionListAdapter adapter;
    private String mDate = "";
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
        questionListPresenterInterface = new QuestionListPresenter(this);
        mDate = getIntent().getStringExtra("Date");
        initToolbar(DateUtil.format(mDate));
        initview();
    }

    private void initview() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new SpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_item_pading)));
        adapter = new QuestionListAdapter(this, null, R.layout.item_essay_list);
        adapter.setClick(new EasyRVAdapter.OnItemClick<QuestionListEntity.QuestionItemEntity>() {
            @Override
            public void onItemClick(View v, int vId, int position, QuestionListEntity.QuestionItemEntity item) {
                intent = new Intent(QuestionListActivity.this, QuestionInfoActivity.class);
                intent.putExtra("Title", item.getQuestion_title());
                intent.putExtra("Id",item.getQuestion_id());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        questionListPresenterInterface.getdata(mDate);
    }

    @Override
    public void onLoadData(QuestionListEntity data) {
        adapter.addAll(data.getData());
    }
}
