package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.penglai.kjds.R;
import com.penglai.kjds.ui.view.widget.banner.CustomerTopBanner;

/**
 *  * 作者：朋来-GZQ on 2017/1/8 13:06
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class TopBannerHolder {

    public static View getCustomHeaderView(final Context context) {
        View headerView = View.inflate(context, R.layout.view_custom_header, null);
        final CustomerTopBanner banner = (CustomerTopBanner) headerView.findViewById(R.id.banner);
        banner.setAdapter(new CustomerTopBanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(CustomerTopBanner banner, ImageView itemView, String model, int position) {
                Glide.with(itemView.getContext())
                        .load(model)
                        .placeholder(R.drawable.icon_my)
                        .error(R.drawable.icon_my)
                        .dontAnimate()
                        .centerCrop()
                        .into(itemView);
            }
        });
        banner.setDelegate(new CustomerTopBanner.Delegate<ImageView, String>() {
            @Override
            public void onBannerItemClick(CustomerTopBanner banner, ImageView imageView, String model, int position) {
                Toast.makeText(banner.getContext(), "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
            }
        });

        /*AppManager.getInstance().getEngine().getBannerModel().enqueue(new Callback<BannerModel>() {
            @Override
            public void onResponse(Call<BannerModel> call, Response<BannerModel> response) {
                BannerModel bannerModel = response.body();
                banner.setData(R.layout.view_image, bannerModel.imgs, bannerModel.tips);
            }

            @Override
            public void onFailure(Call<BannerModel> call, Throwable t) {
            }
        });*/
        return headerView;
    }
}