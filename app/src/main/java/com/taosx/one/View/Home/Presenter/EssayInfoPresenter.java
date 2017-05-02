package com.taosx.one.View.Home.Presenter;

import com.taosx.one.View.Home.Entity.EssayInfoEntity;
import com.taosx.one.View.Home.Model.EssayInfoModel;
import com.taosx.one.View.Home.Model.EssayInfoModelInterface;
import com.taosx.one.View.Home.Model.OnEssayInfoModelInterfaceListener;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public class EssayInfoPresenter implements EssayInfoPresenterInterface {
    private EssayInfoModelInterface essayInfoModelInterface;
    private OnEssayInfoListener onEssayInfoListener;

    public EssayInfoPresenter(OnEssayInfoListener onEssayInfoListener) {
        essayInfoModelInterface = new EssayInfoModel();
        this.onEssayInfoListener = onEssayInfoListener;
    }

    @Override
    public void getdata(String id) {
        essayInfoModelInterface.getData(id, new OnEssayInfoModelInterfaceListener() {
            @Override
            public void OnSuccess(EssayInfoEntity essayInfoEntity) {
                if (essayInfoEntity != null) {
                    onEssayInfoListener.onLoadData(essayInfoEntity);
                }

            }
        });
    }
}
