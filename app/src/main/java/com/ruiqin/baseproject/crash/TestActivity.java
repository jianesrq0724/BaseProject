package com.ruiqin.baseproject.crash;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ruiqin.baseproject.R;
import com.ruiqin.baseproject.base.BaseActivity;

import butterknife.BindView;

public class TestActivity extends BaseActivity {


    private static final String EXTRA_CONTENT = "content";
    @BindView(R.id.textView)
    TextView textView;

    public static Intent newIntent(Context context, String content) {
        Intent intent = new Intent(context.getApplicationContext(), TestActivity.class);
        intent.putExtra(EXTRA_CONTENT, content);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getIntentData();
    }

    private void getIntentData() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(EXTRA_CONTENT);
            textView.setText(stringExtra);
        }
    }
    @Override
    protected int getFragmentContentId() {
        return 0;
    }
}
