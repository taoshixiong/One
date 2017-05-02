package com.taosx.one.View.Home.Adapter;

import android.content.Context;
import android.widget.ImageView;

import com.taosx.one.View.Home.Entity.DataEntity;
import com.taosx.one.R;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.EasyRVAdapter;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.helper.EasyRVHolder;
import com.taosx.one.Util.Glide.ImageLoader;

import java.util.List;

/**
 * Created by TAO_SX on 2017/4/26/026.
 */

public class HpInfoAdapter extends EasyRVAdapter<DataEntity> {
    public HpInfoAdapter(Context context, List<DataEntity> list, int... layoutIds) {
        super(context, list, layoutIds);
    }

    @Override
    protected void onBindData(EasyRVHolder viewHolder, int position, DataEntity item) {
        viewHolder.setText(R.id.item_tv_text, item.getHp_content());
        ImageLoader.loadStringRes((ImageView) viewHolder.getView(R.id.item_iv_img),item.getHp_img_url());
    }
}
