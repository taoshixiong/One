package com.taosx.one.View.Home.Presenter;

import com.taosx.one.View.Home.Entity.DataEntity;
import com.taosx.one.Util.logger.Logger;
import com.taosx.one.View.Home.Model.HpInfoModel;
import com.taosx.one.View.Home.Model.HpInfoModelInterface;
import com.taosx.one.View.Home.Model.OnImageTextCallBack;

import java.util.List;

/**
 * Created by TAO_SX on 2017/4/26/026.
 */

public class HpInfoPresenter {

    private HpInfoPresenterInterface hpInfoPresenterInterface;
    private HpInfoModelInterface hpInfoModelInterface;

    public HpInfoPresenter(HpInfoPresenterInterface hpInfoPresenterInterface) {
        this.hpInfoPresenterInterface = hpInfoPresenterInterface;
        this.hpInfoModelInterface = new HpInfoModel();
    }



    public void getImageTextInfo(String date){
        hpInfoModelInterface.getImageTextInfoByDate(date, new OnImageTextCallBack() {
            @Override
            public void OnSuccess(List<DataEntity> dataEntities) {
                hpInfoPresenterInterface.setData(dataEntities);
            }

            @Override
            public void OnFail(String msg) {
                Logger.e(msg);
            }
        });
    }
}
