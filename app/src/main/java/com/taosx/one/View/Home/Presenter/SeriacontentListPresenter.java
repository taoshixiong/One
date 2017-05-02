package com.taosx.one.View.Home.Presenter;

import com.taosx.one.View.Home.Entity.SeriacontentListEntity;
import com.taosx.one.View.Home.Model.SeriacontentListModel;
import com.taosx.one.View.Home.Model.SeriacontentListModelInterface;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public class SeriacontentListPresenter implements SeriacontentListPresenterInterface {
    private SeriacontentListModelInterface seriacontentListModelInterface;
    private OnSeriacontentListPresenterListener onSeriacontentListPresenterListener;

    public SeriacontentListPresenter(OnSeriacontentListPresenterListener onSeriacontentListPresenterListener) {
        this.onSeriacontentListPresenterListener = onSeriacontentListPresenterListener;
        seriacontentListModelInterface = new SeriacontentListModel();
    }

    @Override
    public void getEssayData(String date) {
        seriacontentListModelInterface.getdata(date, new OnSeriacontentListPresenterListener() {
            @Override
            public void OnLoadData(SeriacontentListEntity seriacontentListEntity) {
                onSeriacontentListPresenterListener.OnLoadData(seriacontentListEntity);
            }
        });
    }
}
