package com.taosx.one.Util.Glide.Utils;


import com.taosx.one.R;

/**
 * Created by TAO_SX on 2016/11/29/029.
 */

public class GlideConfig {
    public final static String CacheFileName = "glide_image_cache";

    //Gilde加载图片配置
    public final static ImageLoadConfig roundeConfig = new ImageLoadConfig.Builder()
            .setCropType(ImageLoadConfig.CENTER_CROP)
            .setAsBitmap(true)
            .setPlaceHolderResId(R.mipmap.ic_launcher)
            .setErrorResId(R.mipmap.ic_launcher)
            .setDiskCacheStrategy(ImageLoadConfig.DiskCache.SOURCE)
            .setPrioriy(ImageLoadConfig.LoadPriority.NORMAL)
            .setRoundedCorners(true)
            .build();
}
