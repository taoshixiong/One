package com.taosx.one.View.Home.Adapter;

import android.content.Context;

import com.taosx.one.R;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.EasyRVAdapter;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.helper.EasyRVHolder;
import com.taosx.one.View.Home.Entity.SeriacontentListEntity;

import java.util.List;

/**
 * Created by TAO_SX on 2017/4/28/028.
 */

public class SerialcontentAdapter extends EasyRVAdapter<SeriacontentListEntity.SeriacontentEntity> {
    public SerialcontentAdapter(Context context, List<SeriacontentListEntity.SeriacontentEntity> list, int... layoutIds) {
        super(context, list, layoutIds);
    }

    @Override
    protected void onBindData(EasyRVHolder viewHolder, int position, SeriacontentListEntity.SeriacontentEntity item) {
        viewHolder.setText(R.id.item_tv_title, item.getTitle()).setText(R.id.item_tv_sub_title, item.getExcerpt());
    }
}
