package com.example.textss;

import com.example.textss.bean.ShopBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by LENOVO on 2019/6/27.
 */

public interface Myserver {
    String Url="http://www.qubaobei.com/ios/cf/";

    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Observable<ShopBean> getData();
}
