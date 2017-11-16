package com.view.hewc.customview;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.view.hewc.customview.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by hewc(破天) on 2017/11/16.
 * 菜单界面
 */
public class MainActivity extends BaseActivity {


    private String[] meun = new String[]{"自定义控件"};

    @BindView(R.id.meun_list)
    RecyclerView meunList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
//        meunList.setLayoutManager(gridLayoutManager);


    }
}
