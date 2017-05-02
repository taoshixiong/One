package com.taosx.one.Base;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.taosx.one.R;
import com.taosx.one.Util.Permission.PermissionListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TAO_SX on 2017/4/26/026.
 */

public class BaseActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 1;
    private PermissionListener mListener;

    private TextView textView;
    private ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initToolbar(String title) {
        textView = (TextView) findViewById(R.id.text_title);
        textView.setText(title);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 注册权限
     *
     * @param permissions
     * @param listener
     */
    protected void requestRuntimePermission(String[] permissions, PermissionListener listener) {
        mListener = listener;
        List<String> permissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission);
            }
        }
        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(this, permissionList.toArray(new String[permissionList.size()]), REQUEST_CODE);
        } else {
            if (mListener != null) {
                mListener.onGranted();
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0) {
                    List<String> deniedpermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            deniedpermissions.add(permission);
                        }
                    }
                    if (deniedpermissions.isEmpty()) {
                        if (mListener != null) {
                            mListener.onGranted();
                        }
                    } else {
                        if (mListener != null) {
                            mListener.onDenied(deniedpermissions);
                        }
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }

}
