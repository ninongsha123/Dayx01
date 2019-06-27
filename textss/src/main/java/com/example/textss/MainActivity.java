package com.example.textss;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.textss.adapter.ShopAdapter;
import com.example.textss.base.BaseMvpActivity;
import com.example.textss.bean.ShopBean;
import com.example.textss.model.Mymodel;
import com.example.textss.presenter.Mypresenter;
import com.example.textss.view.Myview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity<Mypresenter, Mymodel, Myview> implements Myview, ShopAdapter.CbCheck {
    @BindView(R.id.lv)
    RecyclerView lv;
    public ArrayList<ShopBean.DataBean> list;
    public ShopAdapter adapter;
    @BindView(R.id.texs)
    TextView texs;

    private int nums=0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        adapter = new ShopAdapter(this, list);
        lv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        lv.setAdapter(adapter);
        adapter.setCbCheck(this);

    }

    @Override
    protected void initData() {
        myPresenter.getData();
    }

    @Override
    protected Myview initMvpView() {
        return this;
    }

    @Override
    protected Mymodel initMvpModel() {
        return new Mymodel();
    }

    @Override
    protected Mypresenter initMvpPresenter() {
        return new Mypresenter();
    }

    @Override
    public void onSuccess(ShopBean shopBean) {
        List<ShopBean.DataBean> data = shopBean.getData();
        list.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {
        Log.e("MainActivity", "onFail: " + msg);
    }

    @Override
    public void isChecked(int p, ShopBean.DataBean bean) {
        int num = bean.getNum();
        nums+=num;
        texs.setText("总价:"+nums+"元");

    }

    @Override
    public void noChecked(int p, ShopBean.DataBean bean) {
        int num = bean.getNum();
        nums-=num;
        texs.setText("总价:"+nums+"元");
    }
}
