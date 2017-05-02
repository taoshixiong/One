package com.taosx.one.View.Home.Adapter;

import android.content.Context;

import com.taosx.one.R;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.EasyRVAdapter;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.helper.EasyRVHolder;
import com.taosx.one.View.Home.Entity.EssayEntity;

import java.util.List;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public class EssayListAdapter extends EasyRVAdapter<EssayEntity.EssayDataEntity> {
    public EssayListAdapter(Context context, List<EssayEntity.EssayDataEntity> list, int... layoutIds) {
        super(context, list, layoutIds);
    }
    public EssayListAdapter(Context context, int... layoutIds) {
        super(context, null, layoutIds);
    }

    @Override
    protected void onBindData(EasyRVHolder viewHolder, int position, EssayEntity.EssayDataEntity item) {
        viewHolder.setText(R.id.item_tv_title, item.getHp_title()).setText(R.id.item_tv_sub_title, item.getGuide_word());
    }
}
