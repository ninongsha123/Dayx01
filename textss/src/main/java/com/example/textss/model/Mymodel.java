package com.example.textss.model;

import com.example.textss.Myserver;
import com.example.textss.base.BaseModel;
import com.example.textss.base.CallBack;
import com.example.textss.bean.ShopBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LENOVO on 2019/6/27.
 */

public class Mymodel extends BaseModel{
    public void getData(final CallBack<ShopBean> callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Myserver.Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Myserver myserver = retrofit.create(Myserver.class);
        Observable<ShopBean> data = myserver.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopBean shopBean) {
                        callBack.onSuccess(shopBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
