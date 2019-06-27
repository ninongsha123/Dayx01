package com.example.textss.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by LENOVO on 2019/6/27.
 */

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        initMvp();
        initData();
        initView();
        initLister();

    }

    private void initLister() {

    }

    protected void initView() {

    }

    protected void initData() {

    }

    protected void initMvp() {

    }

    protected abstract int getLayoutId();
}
