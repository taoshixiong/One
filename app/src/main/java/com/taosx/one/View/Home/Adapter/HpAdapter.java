package com.taosx.one.View.Home.Adapter;

import android.content.Context;
import android.widget.ImageView;

import com.taosx.one.View.Home.Entity.ImageTextEntity;
import com.taosx.one.Http.NetWorkClient;
import com.taosx.one.R;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.EasyRVAdapter;
import com.taosx.one.Util.BaseAdapter.RecyclerAdapter.helper.EasyRVHolder;
import com.taosx.one.Util.DateUtil;
import com.taosx.one.Util.Glide.ImageLoader;
import com.taosx.one.Util.logger.Logger;
import com.taosx.one.View.Home.Entity.HpItemEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TAO_SX on 2017/4/25/025.
 */

public class HpAdapter extends EasyRVAdapter<HpItemEntity> {
    public HpAdapter(Context context, List<HpItemEntity> list, int... layoutIds) {
        super(context, list, layoutIds);
    }

    @Override
    protected void onBindData(final EasyRVHolder viewHolder, int position, final HpItemEntity item) {
        viewHolder.setText(R.id.item_tv_name, DateUtil.format(item.getName()));
        //根据月份取第一张图片填充
        if (item.getUrl() == null || item.getUrl().equals("")) {
            NetWorkClient.getApiService().getImageTextByDate(item.getName()).enqueue(new Callback<ImageTextEntity>() {
                @Override
                public void onResponse(Call<ImageTextEntity> call, Response<ImageTextEntity> response) {
                    item.setUrl(response.body().getData().get(0).getHp_img_url());
                    ImageLoader.loadStringRes((ImageView) viewHolder.getItemView().findViewById(R.id.item_iv_img), item.getUrl());
                    //同时把请求下来的数据保存起来，传入二级页面，就不需要再次请求
                    item.setListData(response.body().getData());
                }

                @Override
                public void onFailure(Call<ImageTextEntity> call, Throwable t) {
                    Logger.e(t.getMessage());
                }
            });
        } else {
            ImageLoader.loadStringRes((ImageView) viewHolder.getItemView().findViewById(R.id.item_iv_img), item.getUrl());
        }

    }
}
