package com.taosx.one.View.Home.Model;

import com.taosx.one.View.Home.Presenter.OnQuestionInfoPresenterListener;

/**
 * Created by TAO_SX on 2017/5/3/003.
 */

public interface QuestionInfoModelInterface {
    void getdata(String id, OnQuestionInfoPresenterListener listener);
}
