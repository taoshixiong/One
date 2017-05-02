package com.taosx.one.View.Home.Model;

import com.taosx.one.Http.NetWorkClient;
import com.taosx.one.View.Home.Entity.EssayInfoEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public class EssayInfoModel implements EssayInfoModelInterface {
    @Override
    public void getData(String id, final OnEssayInfoModelInterfaceListener listener) {
        NetWorkClient.getApiService().getEssayInfoByid(id).enqueue(new Callback<EssayInfoEntity>() {
            @Override
            public void onResponse(Call<EssayInfoEntity> call, Response<EssayInfoEntity> response) {
                listener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<EssayInfoEntity> call, Throwable t) {

            }
        });
    }
}
