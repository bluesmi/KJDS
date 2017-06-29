package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.index.IndexService;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.index.CarouselRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.CarouselImageView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m199 on 2017/6/29.
 */

public class CarouselImagePresenterImpl implements Presenter {
    private Context mContext;
    private CarouselImageView carouselImageView;

    public CarouselImagePresenterImpl(Context mContext, CarouselImageView carouselImageView) {
        this.mContext = mContext;
        this.carouselImageView = carouselImageView;
    }

    @Override
    public void initialized() {

    }

    public void carouselImage(String opSign,String strJson){
        IndexService.carouselImage(opSign, strJson, new RequestCallback<BaseResArray<CarouselRes>>() {
            @Override
            public void onSuccess(BaseResArray<CarouselRes> carouselResBaseResArray) {
                if(carouselResBaseResArray ==null){
                    return;
                }
                int code = carouselResBaseResArray.getCode();
                String msg = carouselResBaseResArray.getMsg();
                List<CarouselRes> data = carouselResBaseResArray.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+data);
                    List<String> stringList = new ArrayList<String>();
                    for (CarouselRes c:data) {
                        stringList.add(c.getPath());
                    }
                    carouselImageView.getCarouselImageListSuccess(stringList);
                    //存储用户id和用户名
//                    delEduInfoView.delEduInfoViewSuccess();
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                carouselImageView.showError(message);
            }
        });
    }
}
