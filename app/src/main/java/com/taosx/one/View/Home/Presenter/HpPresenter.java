package com.taosx.one.View.Home.Presenter;

import com.taosx.one.Util.DateUtil;
import com.taosx.one.View.Home.Entity.HpItemEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by TAO_SX on 2017/4/25/025.
 */

public class HpPresenter implements HpPresenterInterface {
    @Override
    public List<HpItemEntity> getDateList() {
        //容器
        List<HpItemEntity> list = new ArrayList<>();
        HpItemEntity hpItemEntity = null;

        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        Calendar calendar = Calendar.getInstance();
        List<String> listStr = new ArrayList<>();
        try {
            listStr = DateUtil.getMonthBetween(sdf.parse("2012-10-1"), calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(int i=0;i<listStr.size();i++) {
            hpItemEntity = new HpItemEntity();
            hpItemEntity.setName(listStr.get(i));
            hpItemEntity.setUrl("");
            list.add(hpItemEntity);
        }
        return list;

    }
}
