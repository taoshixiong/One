package com.taosx.one.View.Home.View;

import android.os.Bundle;
import android.widget.TextView;

import com.taosx.one.Base.BaseActivity;
import com.taosx.one.R;
import com.taosx.one.Util.logger.Logger;
import com.taosx.one.View.Home.Entity.QuestionInfoEntity;
import com.taosx.one.View.Home.Presenter.OnQuestionInfoListener;
import com.taosx.one.View.Home.Presenter.QuestionInfoPresenter;
import com.taosx.one.View.Home.Presenter.QuestionInfoPresenterInterface;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.callback.OnImageClickListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

public class QuestionInfoActivity extends BaseActivity implements OnQuestionInfoListener {
    private QuestionInfoPresenterInterface Qipi;
    private TextView tv_question;
    private TextView tv_Answer;
    private String id = "";
    private String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_info);
        id = getIntent().getStringExtra("Id");
        title = getIntent().getStringExtra("Title");
        Qipi = new QuestionInfoPresenter(this);
        initToolbar(title);
        initView();

    }

    private void initView() {
        tv_question = (TextView) findViewById(R.id.tv_question);
        tv_Answer = (TextView) findViewById(R.id.text_content);
        Qipi.getdata(id);
    }

    @Override
    public void onLoadData(QuestionInfoEntity data) {
        tv_question.setText(data.getData().getQuestion_content());

        Document doc = Jsoup.parse(data.getData().getAnswer_content());
        RichText.fromHtml(doc.getElementsByTag("body").toString())
                .imageClick(new OnImageClickListener() {
                    @Override
                    public void imageClicked(List<String> imageUrls, int position) {
                        Logger.d(imageUrls.get(position));
                    }
                })
                .into(tv_Answer);
    }
}
