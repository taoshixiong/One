package com.taosx.one.View.Home.Adapter;

import android.content.Context;

import com.taosx.one.R;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.EasyRVAdapter;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.helper.EasyRVHolder;
import com.taosx.one.View.Home.Entity.QuestionListEntity;

import java.util.List;

/**
 * Created by TAO_SX on 2017/4/28/028.
 */

public class QuestionListAdapter extends EasyRVAdapter<QuestionListEntity.QuestionItemEntity> {
    public QuestionListAdapter(Context context, List<QuestionListEntity.QuestionItemEntity> list, int... layoutIds) {
        super(context, list, layoutIds);
    }

    @Override
    protected void onBindData(EasyRVHolder viewHolder, int position, QuestionListEntity.QuestionItemEntity item) {
        viewHolder.setText(R.id.item_tv_title, item.getQuestion_title()).setText(R.id.item_tv_sub_title, item.getAnswer_content());
    }
}
