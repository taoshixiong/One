package com.taosx.one.View.Home.Presenter;

import com.taosx.one.View.Home.Entity.SerialcontentInfoEntity;
import com.taosx.one.View.Home.Model.OnSerialcontentListInfoModelInterfaceListener;
import com.taosx.one.View.Home.Model.SerialcontentListInfoModel;
import com.taosx.one.View.Home.Model.SerialcontentListInfoModelInterface;

/**
 * Created by TAO_SX on 2017/4/28/028.
 */

public class SerialcontentListInfoPresenter {
    private OnSerialcontentListInfoPresenterListener onSerialcontentListInfoPresenterListener;
    private SerialcontentListInfoModelInterface serialcontentListInfoModelInterface;

    public SerialcontentListInfoPresenter(OnSerialcontentListInfoPresenterListener onSerialcontentListInfoPresenterListener) {
        this.onSerialcontentListInfoPresenterListener = onSerialcontentListInfoPresenterListener;
        serialcontentListInfoModelInterface = new SerialcontentListInfoModel();
    }

    public void getData(String id){
        serialcontentListInfoModelInterface.getdata(id, new OnSerialcontentListInfoModelInterfaceListener() {
            @Override
            public void OnSuccess(SerialcontentInfoEntity serialcontentInfoEntity) {
                onSerialcontentListInfoPresenterListener.OnLoadDate(serialcontentInfoEntity);
            }
        });
    }

}
