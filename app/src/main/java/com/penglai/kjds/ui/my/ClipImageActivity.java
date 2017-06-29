package com.penglai.kjds.ui.my;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.ui.view.widget.ClipViewLayout;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by m199 on 2017/3/22.
 */

public class ClipImageActivity extends BaseActivity {
    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;


    @BindView(R.id.clipViewLayout)
    ClipViewLayout clipViewLayout;


    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_clip_image);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(ClipImageActivity.this);
        initData();
    }

    private void initData() {
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        tvTitle.setText("移动和缩放");
    }


    @OnClick({R.id.btn_back,R.id.btn_cancel,R.id.bt_ok})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.bt_ok:
                generateUriAndReturn();
                break;
            default:break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        clipViewLayout.setImageSrc(getIntent().getData());
    }

    /**
     * 生成Uri并且通过setResult返回给打开的activity
     */
    private void generateUriAndReturn() {
        //调用返回剪切图
        Bitmap zoomedCropBitmap = clipViewLayout.clip();

        if (zoomedCropBitmap == null) {
            Log.e("android", "zoomedCropBitmap == null");
            return;
        }
        Uri mSaveUri = Uri.fromFile(new File(getCacheDir(), "cropped_1.jpg"));
        if (mSaveUri != null) {
            OutputStream outputStream = null;
            try {
                outputStream = getContentResolver().openOutputStream(mSaveUri);
                if (outputStream != null) {
                    zoomedCropBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                }
            } catch (IOException ex) {
                Log.e("android", "Cannot open file: " + mSaveUri, ex);
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            Intent intent = new Intent();
            intent.setData(mSaveUri);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
