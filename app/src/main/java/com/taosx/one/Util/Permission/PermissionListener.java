package com.taosx.one.Util.Permission;

import java.util.List;


public interface PermissionListener {

    void onGranted();
    void onDenied(List<String> deniedPermission);
}
