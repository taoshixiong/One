package com.taosx.one.View.Home.Model;

import com.taosx.one.View.Home.Entity.DataEntity;

import java.util.List;

/**
 * Created by TAO_SX on 2017/4/26/026.
 */

public interface OnImageTextCallBack {
    void OnSuccess(List<DataEntity> dataEntities);
    void OnFail(String msg);
}
