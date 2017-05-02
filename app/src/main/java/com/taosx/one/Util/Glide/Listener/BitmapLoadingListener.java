package com.taosx.one.Util.Glide.Listener;

import android.graphics.Bitmap;

/**
 * Created by TAO_SX on 2016/11/28/028.
 */

public interface BitmapLoadingListener {
    void onSuccess(Bitmap b);

    void onError();
}
