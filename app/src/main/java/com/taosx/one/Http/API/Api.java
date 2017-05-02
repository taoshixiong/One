package com.taosx.one.Http.API;

import com.taosx.one.View.Home.Entity.EssayEntity;
import com.taosx.one.View.Home.Entity.EssayInfoEntity;
import com.taosx.one.View.Home.Entity.ImageTextEntity;
import com.taosx.one.View.Home.Entity.SeriacontentListEntity;
import com.taosx.one.View.Home.Entity.SerialcontentInfoEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by TAO_SX on 2017/4/25/025.
 */

public interface Api {
    /**
     * 依据月份获取图文内容
     * @param mDate
     * @return
     */
    @GET("/api/hp/bymonth/{mDate}")
    Call<ImageTextEntity>getImageTextByDate(
            @Path("mDate") String mDate
    );

    /**
     * 依据月份获得阅读数据
     * @param mDate
     * @return
     */
    @GET("/api/essay/bymonth/{mDate}")
    Call<EssayEntity>getEssayByDate(
            @Path("mDate") String mDate
    );
    /**
     * 依据阅读Id获得内容
     * @param id
     * @return
     */
    @GET("/api/essay/{id}?version=999")
    Call<EssayInfoEntity>getEssayInfoByid(
            @Path("id") String id
    );

    /**
     * 依据月份获得连载数据
     * @param mDate
     * @return
     */
    @GET("/api/serialcontent/bymonth/{mDate}")
    Call<SeriacontentListEntity>getSeriacontentByDate(
            @Path("mDate") String mDate
    );
    /**
     * 依据阅读Id获得连载内容
     * @param id
     * @return
     */
    @GET("/api/serialcontent/{id}?version=999")
    Call<SerialcontentInfoEntity>getSerialcontentInfoByid(
            @Path("id") String id
    );

}
