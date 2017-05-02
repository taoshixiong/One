package com.taosx.one.Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by TAO_SX on 2017/4/25/025.
 */

public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    /**
     * 获取Date区间的月份
     * @param minDate
     * @param maxDate
     * @return
     */
    public static List<String> getMonthBetween(Date minDate, Date maxDate) {
        ArrayList<String> result = new ArrayList<String>();


        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(minDate);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(maxDate);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = max;
        //curr大于min
        while (curr.after(min)) {
            //时间加入数组
            result.add(sdf.format(curr.getTime()));
            //curr减一个月
            curr.add(Calendar.MONTH, -1);
        }
        //颠倒
//        Collections.reverse(result);
        return result;
    }

    /**
     * 时间展示样式如2012-10<---->Oct. 2012
     *
     * @param paramString
     * @return
     */
    public static String format(String paramString)
    {
        try
        {
            paramString = new SimpleDateFormat("MMM. yyyy", Locale.ENGLISH).format(sdf.parse(paramString));
            return paramString;
        }
        catch (Exception e) {}
        return null;
    }

}
