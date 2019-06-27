package com.example.textss.base;

/**
 * Created by LENOVO on 2019/6/27.
 */

public interface CallBack<T> {
    void onSuccess(T t);

    void onFail(String msg);
}
