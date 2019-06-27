package com.example.textss.view;

import com.example.textss.base.BaseView;
import com.example.textss.bean.ShopBean;

/**
 * Created by LENOVO on 2019/6/27.
 */

public interface Myview extends BaseView {
    void onSuccess(ShopBean shopBean);

    void onFail(String msg);
}
