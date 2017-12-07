package com.view.hewc.customview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.view.hewc.customview.R;
import com.view.hewc.customview.adapter.MeunAdapter;
import com.view.hewc.customview.base.BaseActivity;
import com.view.hewc.customview.base.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by hewc(破天) on 2017/11/16.
 * 菜单界面
 */
public class MainActivity extends BaseActivity {


    @BindView(R.id.meun_list)
    RecyclerView meunList;

    @Override
    protected void initData() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        meunList.setLayoutManager(gridLayoutManager);
        List<String> list = new ArrayList<>();
        list.add("自定义控件1");
        list.add("自定义控件2");
        list.add("自定义控件3");
        list.add("自定义控件4");
        list.add("自定义控件5");
        list.add("自定义控件6");
        BaseAdapter adapter = new MeunAdapter(list);
        adapter.setOnItemCliclListener(new BaseAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int viewType, Object data, int position) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, CircleActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, CircleTwoActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, MyTextViewActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, data.toString(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        meunList.setAdapter(adapter);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }
}
