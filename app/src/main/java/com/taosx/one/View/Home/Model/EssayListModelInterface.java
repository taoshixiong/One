package com.taosx.one.View.Home.Model;

import com.taosx.one.View.Home.Presenter.OnEssayListPresenterListener;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public interface EssayListModelInterface {
    void getdata(String date,OnEssayListPresenterListener listener);
}
