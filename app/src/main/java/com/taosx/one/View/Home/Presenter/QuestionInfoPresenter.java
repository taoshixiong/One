package com.taosx.one.View.Home.Presenter;

import com.taosx.one.View.Home.Entity.QuestionInfoEntity;
import com.taosx.one.View.Home.Model.QuestionInfoModel;
import com.taosx.one.View.Home.Model.QuestionInfoModelInterface;

/**
 * Created by TAO_SX on 2017/5/3/003.
 */

public class QuestionInfoPresenter implements QuestionInfoPresenterInterface {
    private QuestionInfoModelInterface questionInfoModelInterface;
    private OnQuestionInfoListener listener;

    public QuestionInfoPresenter(OnQuestionInfoListener listener) {
        this.listener = listener;
        questionInfoModelInterface = new QuestionInfoModel();
    }

    @Override
    public void getdata(String id) {
        questionInfoModelInterface.getdata(id, new OnQuestionInfoPresenterListener() {
            @Override
            public void OnData(QuestionInfoEntity questionInfoEntity) {
                listener.onLoadData(questionInfoEntity);
            }
        });
    }
}
