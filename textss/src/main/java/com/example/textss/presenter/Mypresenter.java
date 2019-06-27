package com.example.textss.presenter;

import com.example.textss.base.BasePresenter;
import com.example.textss.base.CallBack;
import com.example.textss.bean.ShopBean;
import com.example.textss.model.Mymodel;
import com.example.textss.view.Myview;

/**
 * Created by LENOVO on 2019/6/27.
 */

public class Mypresenter extends BasePresenter<Mymodel,Myview> implements CallBack<ShopBean> {
    public void getData(){
        if (myModel!=null){
            myModel.getData(this);
        }
    }

    @Override
    public void onSuccess(ShopBean shopBean) {
         myView.onSuccess(shopBean);
    }

    @Override
    public void onFail(String msg) {
        myView.onFail(msg);
    }
}
