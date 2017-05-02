package com.taosx.one;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.taosx.one.Base.BaseActivity;
import com.taosx.one.Util.Permission.PermissionListener;
import com.taosx.one.Util.logger.Logger;
import com.taosx.one.View.Home.View.HomeFragment;

import java.util.List;

public class MainActivity extends BaseActivity implements PermissionListener{
    private final String[] Permission = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};

    // 定义FragmentManager对象
    private FragmentManager fManager;
    private FragmentTransaction transaction;

    private Fragment homeFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            transaction = fManager.beginTransaction();
            hidefragment(transaction);

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (homeFragment == null) {
                        homeFragment = HomeFragment.newInstance();
                        transaction.add(R.id.content, homeFragment,"Home");
                    }else{
                        transaction.show(homeFragment);
                    }
                    transaction.commit();
                    return true;
                case R.id.navigation_dashboard:

                    transaction.commit();
                    return true;
                case R.id.navigation_notifications:

                    transaction.commit();
                    return true;
            }


            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getSupportFragmentManager();
        if (savedInstanceState != null) {  // “内存重启”时调用  解决重叠问题
            homeFragment = (Fragment) getSupportFragmentManager().findFragmentByTag("Home");
            transaction = fManager.beginTransaction();
            hidefragment(transaction);
            transaction.commit();
        }
        requestRuntimePermission(Permission, new PermissionListener() {
            @Override
            public void onGranted() {
                Logger.d("获得了所有权限");
            }

            @Override
            public void onDenied(List<String> deniedPermission) {
                for (String item : deniedPermission) {
                    Logger.d("( ﹁ ﹁ ) ~→" + item);
                }
            }
        });


        initView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    //初始化View
    private void initView() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
    }

    /**
     * 隐藏Fragment
     * @param transaction
     */
    private void hidefragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
    }

    @Override
    public void onGranted() {

    }

    @Override
    public void onDenied(List<String> deniedPermission) {

    }
}
