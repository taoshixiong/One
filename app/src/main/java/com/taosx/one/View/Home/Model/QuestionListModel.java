package com.taosx.one.View.Home.Model;

import com.taosx.one.Http.NetWorkClient;
import com.taosx.one.View.Home.Entity.QuestionListEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TAO_SX on 2017/5/3/003.
 */

public class QuestionListModel implements QuestionListModelInterface {
    @Override
    public void getdata(String date, final OnQuestionListModelListener listener) {
        NetWorkClient.getApiService().getQuestionByDate(date).enqueue(new Callback<QuestionListEntity>() {
            @Override
            public void onResponse(Call<QuestionListEntity> call, Response<QuestionListEntity> response) {
                listener.onData(response.body());
            }

            @Override
            public void onFailure(Call<QuestionListEntity> call, Throwable t) {

            }
        });
    }
}
