package com.taosx.one.View.Home.View;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.taosx.one.Base.BaseActivity;
import com.taosx.one.View.Home.Entity.DataEntity;
import com.taosx.one.View.Home.Entity.ImageTextEntity;
import com.taosx.one.R;
import com.taosx.one.Util.Glide.ImageLoader;
import com.taosx.one.Util.PhotoView.PhotoView;

import java.util.ArrayList;
import java.util.List;

public class GalleryImageActivity extends BaseActivity
        implements ViewPager.OnPageChangeListener {

    private List<DataEntity> list = new ArrayList<>();
    private int index = 0;

    private ViewPager viewPager;
    private TextView titleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_gallery_image);

        setTitle(null);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageTextEntity imageTextEntity = getIntent().getParcelableExtra(HpInfoActivity.class.getName());
        list.addAll(imageTextEntity.getData());

        index = getIntent().getIntExtra("index", 0);

        titleView = (TextView) findViewById(R.id.painting_title);


        viewPager = (ViewPager) findViewById(R.id.paintings_view_pager);

        viewPager.setAdapter(new SamplePagerAdapter(list));
        viewPager.addOnPageChangeListener(this);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.view_pager_margin));

        if (index > 0) {
//        onPageSelected(index); // Manually calling for first item
            viewPager.setCurrentItem(index);
        }else{
            titleView.setText(list.get(index).getHp_content());
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        titleView.setText(list.get(position).getHp_content());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class SamplePagerAdapter extends PagerAdapter {

        private List<DataEntity> list = new ArrayList<>();
        private PhotoView photoView;

        public SamplePagerAdapter(List<DataEntity> list) {
            this.list.addAll(list);

        }

        public void setNewData(List<DataEntity> list) {
            list.clear();
            list.addAll(list);
            this.notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            photoView = new PhotoView(container.getContext());
            ImageLoader.loadStringRes(photoView, list.get(position).getHp_img_url());

            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}
