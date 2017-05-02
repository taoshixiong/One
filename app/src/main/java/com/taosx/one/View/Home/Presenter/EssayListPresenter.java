package com.taosx.one.View.Home.Presenter;

import com.taosx.one.View.Home.Entity.EssayEntity;
import com.taosx.one.View.Home.Model.EssayListModel;
import com.taosx.one.View.Home.Model.EssayListModelInterface;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public class EssayListPresenter implements EssayListPresenterInterface {
    private EssayListModelInterface essayListModelInterface;
    private OnEssayListPresenterListener onEssayListPresenterListener;

    public EssayListPresenter(OnEssayListPresenterListener onEssayListPresenterListener) {
        essayListModelInterface = new EssayListModel();
        this.onEssayListPresenterListener = onEssayListPresenterListener;
    }
    @Override
    public void getEssayData(String date) {
        essayListModelInterface.getdata(date, new OnEssayListPresenterListener() {
            @Override
            public void OnLoadData(EssayEntity essayEntity) {
                onEssayListPresenterListener.OnLoadData(essayEntity);
            }
        });
    }
}
