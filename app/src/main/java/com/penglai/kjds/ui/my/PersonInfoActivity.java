package com.penglai.kjds.ui.my;


import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.penglai.kjds.R;
import com.penglai.kjds.model.user.ModifyUserInfoReq;
import com.penglai.kjds.model.user.UserInfo;
import com.penglai.kjds.model.user.UserInfoReq;
import com.penglai.kjds.presenter.impl.GetUserInfoPresenterImpl;
import com.penglai.kjds.presenter.impl.UploadUserImgPresenterImpl;
import com.penglai.kjds.presenter.implView.GetUserInfoView;
import com.penglai.kjds.presenter.implView.UploadUserImgView;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.ui.view.widget.CircleImageView;
import com.penglai.kjds.ui.view.widget.PopWindowView;
import com.penglai.kjds.utils.PickerUtils;
import com.penglai.kjds.utils.SettingPrefUtils;
import com.penglai.kjds.utils.UiUtils;

import java.io.File;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.OptionPicker;

/**
 * 个人信息
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/13 14:05
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class PersonInfoActivity extends BaseActivity implements UploadUserImgView{

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.tv_school)
    TextView tvSchool;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.iv_user_img)
    CircleImageView ivUserImg;
    @BindView(R.id.btn_base)
    Button btnBase;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;

    @BindColor(R.color.common_light_gray_txt)
    int txtColor;
    @BindString(R.string.save)
    String save;
    @BindString(R.string.person_info)
    String title;

    private PopupWindow mPopWindow;



    private UploadUserImgPresenterImpl uploadUserImgPresenter;



    //请求相机
    private static final int REQUEST_CAPTURE = 100;
    //请求相册
    private static final int REQUEST_PICK = 101;
    //请求截图
    private static final int REQUEST_CROP_PHOTO = 102;
    //请求访问外部存储
    private static final int READ_EXTERNAL_STORAGE_REQUEST_CODE = 103;
    //请求写入外部存储
    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 104;

    //修改呢称返回的数值
    private static final int NICKNAME = 0;

    //调用照相机返回图片临时文件
    private File tempFile;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_person_info);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(PersonInfoActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {

        uploadUserImgPresenter = new UploadUserImgPresenterImpl(mContext,this);
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        btnBase.setVisibility(View.VISIBLE);
        btnBase.setTextColor(txtColor);
        tvNickname.setTextColor(txtColor);
        tvSex.setTextColor(txtColor);
        tvBirthday.setTextColor(txtColor);
        tvTitle.setText(title);
        tvTitle.setTextColor(Color.parseColor("#EFEFEF"));
        btnBase.setText(save);
        btnBase.setTextColor(Color.parseColor("#EFEFEF"));
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        UiUtils.showToast(mContext,getIntent().getExtras()+"");
        Intent intent = getIntent();
        UserInfo userInfo = (UserInfo) intent.getSerializableExtra("userInfo");
        if(null != userInfo){
            showUserInfo(userInfo);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createCameraTempFile(savedInstanceState);
    }

    @OnClick({R.id.btn_nickname, R.id.btn_school, R.id.btn_sex,
            R.id.btn_birthday, R.id.btn_user_img, R.id.btn_back,R.id.btn_base})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_nickname:
                Intent intent = new Intent(mContext,PersonNameActivity.class);
                if(!"未填写".equals(tvNickname.getText())) {
                    intent.putExtra("nickName", tvNickname.getText());
                }else {
                    intent.putExtra("nickName", "");
                }
                startActivityForResult(intent,NICKNAME);
                break;
            case R.id.btn_school:
                break;
            case R.id.btn_sex:
//                onConstellationPicker(view);
                OptionPicker picker = PickerUtils.onConstellationPicker(this,view);

                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int index, String item) {
                        tvSex.setText(item);
                        tvSex.setTextColor(Color.parseColor("#24CD9E"));
                    }
                });
                picker.show();
                break;
            case R.id.btn_user_img:
                loadUserImage();
                break;
            case R.id.btn_birthday:
                final DatePicker datePicker = PickerUtils.onYearMonthDayPicker(this,view);
                datePicker.getSubmitButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvBirthday.setText(datePicker.getSelectedYear()+"-"+datePicker.getSelectedMonth()+"-"+datePicker.getSelectedDay());
                        tvBirthday.setTextColor(Color.parseColor("#24CD9E"));
                        datePicker.dismiss();
                    }
                });
                break;
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_base:                                                      //保存信息
                UiUtils.showToast(mContext,"保存");
                break;

        }
    }

    private void loadUserImage(){
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.pop_head_portrait,null);
        mPopWindow = new PopWindowView(PersonInfoActivity.this,PersonInfoActivity.this,contentView);
        mPopWindow.showAtLocation(getContentView(), Gravity.BOTTOM | Gravity.CENTER,0,0);
        contentView.findViewById(R.id.take_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(mContext,"拍照");
                //权限判断


                //动态权限
                if (ContextCompat.checkSelfPermission(PersonInfoActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PersonInfoActivity.this, new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
                }else{
                    //跳转到调用系统相机
                    gotoCarema();
                }
                mPopWindow.dismiss();
            }
        });
        contentView.findViewById(R.id.get_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(mContext,"选择照片");
                //权限判断
                if ((ContextCompat.checkSelfPermission(PersonInfoActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) ||
                        ContextCompat.checkSelfPermission(PersonInfoActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    //申请READ_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(PersonInfoActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA},
                            READ_EXTERNAL_STORAGE_REQUEST_CODE);
                } else {
                    //跳转到调用系统图库
                    gotoPhoto();
                }
                mPopWindow.dismiss();
            }
        });
        contentView.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(mContext,"取消");
                mPopWindow.dismiss();
            }
        });

    }

    /**
     * 外部存储权限申请返回
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                UiUtils.showToast(mContext,"相机启动");
                gotoCarema();
            } else {
                // Permission Denied
                UiUtils.showToast(mContext,"相机启动失败");
            }
        } else if (requestCode == READ_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted

                UiUtils.showToast(mContext,"相机册动");
                gotoPhoto();
            } else {
                // Permission Denied
                UiUtils.showToast(mContext,"相机启动失败");
            }
        }
    }







    /**
     * 跳转到相册
     */
    private void gotoPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "请选择图片"), REQUEST_PICK);
    }


    /**
     * 跳转到照相机
     */
    private void gotoCarema() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        startActivityForResult(intent, REQUEST_CAPTURE);

    }


    /**
     * 创建调用系统照相机待存储的临时文件
     *
     * @param savedInstanceState
     */
    private void createCameraTempFile(Bundle savedInstanceState) {
//        UiUtils.showToast(mContext,"bvcnjdbvjdkfbcvjd");
        if (savedInstanceState != null && savedInstanceState.containsKey("tempFile")) {
            tempFile = (File) savedInstanceState.getSerializable("tempFile");
            UiUtils.showToast(mContext,"第一个:"+tempFile);
        } else {
            tempFile = new File(checkDirPath(Environment.getExternalStorageDirectory().getPath() + "/image/"),
                    System.currentTimeMillis() + ".jpg");
            UiUtils.showToast(mContext,"第二个:"+tempFile);
        }
    }

    /**
     * 检查文件是否存在
     */
    private static String checkDirPath(String dirPath) {
        if (TextUtils.isEmpty(dirPath)) {
            return "";
        }
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dirPath;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putSerializable("tempFile", tempFile);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case REQUEST_CAPTURE: //调用系统相机返回
                if (resultCode == RESULT_OK) {
                    gotoClipActivity(Uri.fromFile(tempFile));
                }
                break;
            case REQUEST_PICK:  //调用系统相册返回
                if (resultCode == RESULT_OK) {
                    Uri uri = intent.getData();
                    gotoClipActivity(uri);
                }
                break;
            case REQUEST_CROP_PHOTO:  //剪切图片返回
                if (resultCode == RESULT_OK) {
                    final Uri uri = intent.getData();
                    if (uri == null) {
                        return;
                    }
                    String cropImagePath = getRealFilePathFromUri(getApplicationContext(), uri);
                    Bitmap bitMap = BitmapFactory.decodeFile(cropImagePath);
                    ivUserImg.setImageBitmap(bitMap);
                    //此处后面可以将bitMap转为二进制上传后台网络
                    //......

                }
                break;
            case NICKNAME:
                if (resultCode == RESULT_OK) {
                    String strNickName = intent.getStringExtra("nickName");
                    if (null != strNickName && !"".equals(strNickName)) {
                        tvNickname.setText(strNickName);
                        tvNickname.setTextColor(Color.parseColor("#24CD9E"));
                    }
                }
                break;

        }
    }


    /**
     * 打开截图界面
     *
     * @param uri
     */
    public void gotoClipActivity(Uri uri) {
        if (uri == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, ClipImageActivity.class);
        intent.setData(uri);
        startActivityForResult(intent, REQUEST_CROP_PHOTO);
    }


    /**
     * 根据Uri返回文件绝对路径
     * 兼容了file:///开头的 和 content://开头的情况
     *
     * @param context
     * @param uri
     * @return the file path or null
     */
    public static String getRealFilePathFromUri(final Context context, final Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }



    @Override
    public void showError(String error) {

    }

    /**
     * 保存下图片的信息
     * @param path
     */
    @Override
    public void saveUserImgPath(String path) {

    }


    public void showUserInfo(UserInfo userInfo) {
        Glide.with(mContext)
             .load(userInfo.getUserImage())
             .placeholder(R.drawable.icon_user_img)
             .error(R.drawable.icon_user_img)
             .into(ivUserImg);
        String nickName = userInfo.getNickName();
        if(null != nickName && !"".equals(nickName)) {
            tvNickname.setText(nickName);
            tvNickname.setTextColor(Color.parseColor("#24CD9E"));
        }
        String school = userInfo.getSchool();
        if(null != school && !"".equals(school)) {
            tvSchool.setText(school);
            tvSchool.setTextColor(Color.parseColor("#24CD9E"));
        }
        int sex = Integer.parseInt(userInfo.getSex());
        if(0 == sex || 1 == sex) {
            String userSex = sex==0 ? "男" : "女";
            tvSex.setText(userSex);
            tvSex.setTextColor(Color.parseColor("#24CD9E"));
        }
        String birthday = userInfo.getBirthday();
        if(null != birthday && !"".equals(birthday)) {
            birthday = birthday.substring(0,10);
            tvBirthday.setText(birthday);
            tvBirthday.setTextColor(Color.parseColor("#24CD9E"));
        }
    }
}




