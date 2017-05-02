package com.taosx.one.View.Home.View;

import android.os.Bundle;
import android.widget.TextView;

import com.taosx.one.Base.BaseActivity;
import com.taosx.one.R;
import com.taosx.one.Util.logger.Logger;
import com.taosx.one.View.Home.Entity.SerialcontentInfoEntity;
import com.taosx.one.View.Home.Presenter.OnSerialcontentListInfoPresenterListener;
import com.taosx.one.View.Home.Presenter.SerialcontentListInfoPresenter;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.callback.OnImageClickListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

public class SerialcontentListInfoActivity extends BaseActivity implements OnSerialcontentListInfoPresenterListener {
    private SerialcontentListInfoPresenter Slip;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serialcontent_list_info);
        initToolbar(getIntent().getStringExtra("Title"));
        Slip = new SerialcontentListInfoPresenter(this);
        Slip.getData(getIntent().getStringExtra("Id"));
        initview();
    }
    private void initview() {
        textView = (TextView) findViewById(R.id.text_content);
    }

    @Override
    public void OnLoadDate(SerialcontentInfoEntity serialcontentInfoEntity) {
        Document doc = Jsoup.parse(serialcontentInfoEntity.getData().getContent());

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
