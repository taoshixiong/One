package com.taosx.one.Http;

import com.taosx.one.BaseApplication;
import com.taosx.one.Http.API.Api;
import com.taosx.one.Util.PathUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by zhong on 2016/4/19.
 */
public class NetWorkClient {
    private static final String BASE_CACHE_PATH = "CacheResponse";
    private static final String BASE_URL = "http://v3.wufazhuce.com:8000";

    private static Api api = null;

    private NetWorkClient() {
    }


    public static Api getApiService() {
        if (api == null) {
            api = createService(Api.class);
        }
        return api;
    }


    /**
     * 默认拦截器
     */
    private static Interceptor definterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request compressedRequest = originalRequest.newBuilder().build();

            return chain.proceed(compressedRequest);
        }
    };
    /**
     * 默认拦截器GET
     * 默认拦截器缓存只是针对GET请求，并不缓存POST
     */
    private static Interceptor defcacheInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetWorkUtil.isConnect()) {//没网强制从缓存读取
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            Response responseLatest;
            if (NetWorkUtil.isConnect()) {
                int maxAge = 60 * 60 * 5;
                responseLatest = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 72; // 没网失效72小时
                responseLatest = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }

            return responseLatest;
        }
    };


    /**
     * 缓存
     *
     * @return
     */
    private static Cache defcache() {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(PathUtils.getDiskCacheDir(BaseApplication.getContext(), BASE_CACHE_PATH), cacheSize);
    }


    /**
     * 缺省OKHttp配置
     *
     * @return
     */
    private static OkHttpClient.Builder getdefOkhttp() {
        //Log相关
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(10, TimeUnit.SECONDS);
        okHttpClient.readTimeout(10, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(10, TimeUnit.SECONDS);
        okHttpClient.addInterceptor(definterceptor);

        okHttpClient.addInterceptor(logging);

        //失败重连
        okHttpClient.retryOnConnectionFailure(true);
        return okHttpClient;
    }

    private static <T> T createService(Class<T> serviceClass) {

        //------------------------设置缓存策略------------------------------------
        OkHttpClient.Builder okHttpClient = getdefOkhttp();
        //设置Cache目录
        okHttpClient.cache(defcache());
        //设置缓存
        okHttpClient.addInterceptor(defcacheInterceptor);
        okHttpClient.addNetworkInterceptor(defcacheInterceptor);
        //--------------------------------------------------------------
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //设置OKHttpClient
                .client(okHttpClient.build())
                //gson转化器
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }


}
