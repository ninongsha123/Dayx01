package com.example.textss.base;

import java.util.ArrayList;

/**
 * Created by LENOVO on 2019/6/3.
 */

public class BasePresenter<M extends BaseModel,V extends BaseView> {

    ArrayList<BaseModel> list=new ArrayList<>();
    protected M myModel;
    protected V myView;

    public void initModel(M m) {
        this.myModel=m;
        list.add(m);
    }

    public void initView(V v) {
        this.myView=v;
    }
    public void destroy(){
        if (myView!=null){
            myView=null;
        }
        if (list!=null&&list.size()>0){
            for (BaseModel basemodel :list) {
                 basemodel.clear();
            }
        }
    }
}
