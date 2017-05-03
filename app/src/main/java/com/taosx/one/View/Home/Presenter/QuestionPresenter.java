package com.taosx.one.View.Home.Presenter;

import com.taosx.one.Util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public class QuestionPresenter implements QuestionPresenterInterface {
    @Override
    public List<String> getDateList() {
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        Calendar calendar = Calendar.getInstance();
        List<String> listStr = new ArrayList<>();
        try {
            listStr = DateUtil.getMonthBetween(sdf.parse("2012-10-1"), calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listStr;
    }
}
