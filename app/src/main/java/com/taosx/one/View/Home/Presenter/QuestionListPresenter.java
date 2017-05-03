package com.taosx.one.View.Home.Presenter;

import com.taosx.one.View.Home.Entity.QuestionListEntity;
import com.taosx.one.View.Home.Model.OnQuestionListModelListener;
import com.taosx.one.View.Home.Model.QuestionListModel;
import com.taosx.one.View.Home.Model.QuestionListModelInterface;

/**
 * Created by TAO_SX on 2017/5/3/003.
 */

public class QuestionListPresenter implements QuestionListPresenterInterface {
    private QuestionListModelInterface questionListModelInterface;
    private OnQuestionListPresenterListener onQuestionListPresenterListener;

    public QuestionListPresenter(OnQuestionListPresenterListener listener) {
        onQuestionListPresenterListener = listener;
        questionListModelInterface = new QuestionListModel();
    }
    @Override
    public void getdata(String date) {
        questionListModelInterface.getdata(date, new OnQuestionListModelListener() {
            @Override
            public void onData(QuestionListEntity data) {
                onQuestionListPresenterListener.onLoadData(data);
            }
        });
    }
}
