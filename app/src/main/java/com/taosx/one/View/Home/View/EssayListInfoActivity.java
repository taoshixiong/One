package com.taosx.one.View.Home.View;

import android.os.Bundle;
import android.widget.TextView;

import com.taosx.one.Base.BaseActivity;
import com.taosx.one.R;
import com.taosx.one.Util.logger.Logger;
import com.taosx.one.View.Home.Entity.EssayInfoEntity;
import com.taosx.one.View.Home.Presenter.EssayInfoPresenter;
import com.taosx.one.View.Home.Presenter.EssayInfoPresenterInterface;
import com.taosx.one.View.Home.Presenter.OnEssayInfoListener;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.callback.OnImageClickListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

public class EssayListInfoActivity extends BaseActivity implements OnEssayInfoListener{
    private EssayInfoPresenterInterface Eipi;
    private TextView textView;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay_list_info);
        initToolbar(getIntent().getStringExtra("Title"));
        Eipi = new EssayInfoPresenter(this);
        Eipi.getdata(getIntent().getStringExtra("Id"));
        initview();
    }

    private void initview() {
        textView = (TextView) findViewById(R.id.text_content);
    }

    @Override
    public void onLoadData(EssayInfoEntity essayInfoEntity) {

        Document doc = Jsoup.parse(essayInfoEntity.getData().getHp_content());

        RichText.fromHtml(doc.getElementsByTag("body").toString())
                .imageClick(new OnImageClickListener() {
                    @Override
                    public void imageClicked(List<String> imageUrls, int position) {
                        Logger.d(imageUrls.get(position));
                    }
                })
                .into(textView);
    }
}
