package com.taosx.one.Util.Glide.Utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/**
 * Created by TAO_SX on 2016/11/28/028.
 * android4.3
 */

public class RSBlur {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static Bitmap blur(Context context, Bitmap blurredBitmap, int radius) throws RSRuntimeException {
        try {
            RenderScript rs = RenderScript.create(context);
            Allocation input = Allocation.createFromBitmap(rs, blurredBitmap, Allocation.MipmapControl.MIPMAP_NONE,
                    Allocation.USAGE_SCRIPT);
            Allocation output = Allocation.createTyped(rs, input.getType());
            ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));

            blur.setInput(input);
            blur.setRadius(radius);
            blur.forEach(output);
            output.copyTo(blurredBitmap);
            rs.destroy();
        } catch (RSRuntimeException e) {
            blurredBitmap = FastBlur.blur(blurredBitmap, radius, true);
        }
        return blurredBitmap;
    }
}
