package com.example.textss.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by LENOVO on 2019/6/3.
 */

public class BaseModel {
    protected CompositeDisposable compositeDisposable=new CompositeDisposable();
    public void clear() {
         compositeDisposable.clear();
    }
}
