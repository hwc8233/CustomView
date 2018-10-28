package com.view.hewc.customview.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.view.hewc.customview.R;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * Created by hewc(破天) on 2017/12/6.
 */

@SuppressLint("AppCompatCustomView")
public class MyTextView extends AutoLinearLayout {

    TextView desText, hour1Text, hour2Text, minter1Text, minter2Text, second1Text, second2Text;

    View lineView;

    public MyTextView(Context context) {
        super(context);

    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_timer_layout, this);
        lineView = findViewById(R.id.mytext_line);
        desText = (TextView) findViewById(R.id.mytext_desc);
        hour1Text = (TextView) findViewById(R.id.mytext_hour_1);
        hour2Text = (TextView) findViewById(R.id.mytext_hour_2);
        minter1Text = (TextView) findViewById(R.id.mytext_minter_1);
        minter2Text = (TextView) findViewById(R.id.mytext_minter_2);
        second1Text = (TextView) findViewById(R.id.mytext_second_1);
        second2Text = (TextView) findViewById(R.id.mytext_second_2);
    }

    public void setLineV(boolean isV) {
        lineView.setVisibility(isV ? VISIBLE : GONE);
    }

    public void setDesText(boolean isStart, int countDown) {
        if (countDown > 356400) {
            Log.e("hewc", "传输秒数超过最大值");
            return;
        }
        int startHours = countDown / 3600;
        int startMinutes = (countDown % 3600) / 60;
        int startSeconds = (countDown % 3600) % 60;

        if (isStart) {
            desText.setText("距本场结束还有");
        } else {
            desText.setText("距本场开始还有");
        }

        try {
            hour1Text.setText("" + startHours / 10);
            hour2Text.setText("" + startHours % 10);
            minter1Text.setText("" + startMinutes / 10);
            minter2Text.setText("" + startMinutes % 10);
            second1Text.setText("" + startSeconds / 10);
            second2Text.setText("" + startSeconds % 10);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("hewc--自定义控件", e.getMessage());
        }


    }
}
