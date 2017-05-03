package com.taosx.one.View.Home.Model;

import com.taosx.one.Http.NetWorkClient;
import com.taosx.one.View.Home.Entity.QuestionInfoEntity;
import com.taosx.one.View.Home.Presenter.OnQuestionInfoPresenterListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TAO_SX on 2017/5/3/003.
 */

public class QuestionInfoModel implements QuestionInfoModelInterface {
    @Override
    public void getdata(String id, final OnQuestionInfoPresenterListener listener) {
        NetWorkClient.getApiService().getQuestionInfoByid(id).enqueue(new Callback<QuestionInfoEntity>() {
            @Override
            public void onResponse(Call<QuestionInfoEntity> call, Response<QuestionInfoEntity> response) {
                listener.OnData(response.body());
            }

            @Override
            public void onFailure(Call<QuestionInfoEntity> call, Throwable t) {

            }
        });
    }
}
