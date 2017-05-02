package com.taosx.one.View.Home.Model;

import com.taosx.one.View.Home.Presenter.OnSeriacontentListPresenterListener;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public interface SeriacontentListModelInterface {
    void getdata(String date, OnSeriacontentListPresenterListener listener);
}
