package com.taosx.one.View.Home.Model;

import com.taosx.one.Http.NetWorkClient;
import com.taosx.one.View.Home.Entity.SeriacontentListEntity;
import com.taosx.one.View.Home.Presenter.OnSeriacontentListPresenterListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public class SeriacontentListModel implements SeriacontentListModelInterface {

    @Override
    public void getdata(String date, final OnSeriacontentListPresenterListener listener) {
        NetWorkClient.getApiService().getSeriacontentByDate(date).enqueue(new Callback<SeriacontentListEntity>() {
            @Override
            public void onResponse(Call<SeriacontentListEntity> call, Response<SeriacontentListEntity> response) {
                listener.OnLoadData(response.body());
            }

            @Override
            public void onFailure(Call<SeriacontentListEntity> call, Throwable t) {

            }
        });
    }
}
