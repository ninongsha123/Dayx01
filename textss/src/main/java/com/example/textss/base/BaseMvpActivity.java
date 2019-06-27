package com.example.textss.base;

/**
 * Created by LENOVO on 2019/6/27.
 */

public abstract class BaseMvpActivity<P extends BasePresenter,M extends BaseModel,V extends BaseView> extends BaseActivity{

    protected P myPresenter;

    @Override
    protected void initMvp() {
          myPresenter=initMvpPresenter();
          if (myPresenter!=null){
              myPresenter.initModel(initMvpModel());
              myPresenter.initView(initMvpView());
          }
    }

    protected abstract V initMvpView();

    protected abstract M initMvpModel();

    protected abstract P initMvpPresenter();
}
