package com.taosx.one.View.Home.Model;

import com.taosx.one.Http.NetWorkClient;
import com.taosx.one.View.Home.Entity.SerialcontentInfoEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TAO_SX on 2017/4/28/028.
 */

public class SerialcontentListInfoModel implements SerialcontentListInfoModelInterface{
    @Override
    public void getdata(String id, final OnSerialcontentListInfoModelInterfaceListener listener) {
        NetWorkClient.getApiService().getSerialcontentInfoByid(id).enqueue(new Callback<SerialcontentInfoEntity>() {
            @Override
            public void onResponse(Call<SerialcontentInfoEntity> call, Response<SerialcontentInfoEntity> response) {
                listener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SerialcontentInfoEntity> call, Throwable t) {

            }
        });
    }
}
