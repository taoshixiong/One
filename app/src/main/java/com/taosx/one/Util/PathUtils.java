package com.taosx.one.Util;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by TAO_SX on 2016/11/28/028.
 */

public class PathUtils {

    public static File getDiskCacheDir(Context context, String CacheFileName) {
        String cachePath;
        if (isExternalStorageWritable()) {
            cachePath = context.getExternalCacheDir().getPath();//如果挂载了sdcard，获取外部存储私有区域路径 内部存储/Android/包名/Cache/...
        } else {
            cachePath = context.getCacheDir().getPath();//如果没有挂载sdcard，则获取内部存储缓存区域
        }
        return new File(cachePath + File.separator + CacheFileName);
    }

    public static File getDiskDir(Context context, String path) {
        String cachePath;
        if (isExternalStorageWritable()) {
            cachePath = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC).getPath();//如果挂载了sdcard
        } else {
            cachePath = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC).getPath();//如果没有挂载sdcard
        }
        File file = new File(cachePath + File.separator + path);

        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /**
     * 检查外部存储是否可用
     *
     * @return
     */
    private static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;//挂载了sdcard，返回真
        } else {
            return false;//否则返回假
        }
    }


    /**
     * 判断文件是否存在，存在返回true
     * @param path
     * @return
     */
    public static boolean checkFileIsExists(String path){
        File f=new File(path);
        if(!f.exists()){
            return false;
        }
        return true;
    }
}
