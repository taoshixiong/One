package com.taosx.one.View.Home.Model;

import com.taosx.one.View.Home.Entity.ImageTextEntity;
import com.taosx.one.Http.NetWorkClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TAO_SX on 2017/4/26/026.
 */

public class HpInfoModel implements HpInfoModelInterface {
    @Override
    public void getImageTextInfoByDate(String date, final OnImageTextCallBack onImageTextCallBack) {
        NetWorkClient.getApiService().getImageTextByDate(date).enqueue(new Callback<ImageTextEntity>() {
            @Override
            public void onResponse(Call<ImageTextEntity> call, Response<ImageTextEntity> response) {
                if (response.body().getData() == null) {
                    onImageTextCallBack.OnFail("Null");
                    return;
                }
                onImageTextCallBack.OnSuccess(response.body().getData());

            }

            @Override
            public void onFailure(Call<ImageTextEntity> call, Throwable t) {
                onImageTextCallBack.OnFail(t.getMessage());
            }
        });
    }
}
