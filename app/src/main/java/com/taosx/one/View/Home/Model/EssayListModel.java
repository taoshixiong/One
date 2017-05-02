package com.taosx.one.View.Home.Model;

import com.taosx.one.Http.NetWorkClient;
import com.taosx.one.View.Home.Entity.EssayEntity;
import com.taosx.one.View.Home.Presenter.OnEssayListPresenterListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public class EssayListModel implements EssayListModelInterface {
    @Override
    public void getdata(String date, final OnEssayListPresenterListener listener) {
        NetWorkClient.getApiService().getEssayByDate(date).enqueue(new Callback<EssayEntity>() {
            @Override
            public void onResponse(Call<EssayEntity> call, Response<EssayEntity> response) {
                listener.OnLoadData(response.body());
            }

            @Override
            public void onFailure(Call<EssayEntity> call, Throwable t) {

            }
        });
    }
}
