package com.taosx.one.View.Home.Adapter;

import android.content.Context;

import com.taosx.one.R;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.EasyRVAdapter;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.helper.EasyRVHolder;
import com.taosx.one.Util.DateUtil;

import java.util.List;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public class EssayAdapter extends EasyRVAdapter<String> {
    public EssayAdapter(Context context, List<String> list, int... layoutIds) {
        super(context, list, layoutIds);
    }
    public EssayAdapter(Context context, int... layoutIds) {
        super(context, null, layoutIds);
    }

    @Override
    protected void onBindData(EasyRVHolder viewHolder, int position, String item) {
        viewHolder.setText(R.id.item_tv_title, DateUtil.format(item));
    }
}
