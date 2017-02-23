package com.example.administrator.test;

import android.content.Intent;
import android.os.Bundle;

import com.example.qrlibrary.qrcode.activity.DefaultQRScanActivity;

/**
 * Created by ShuWen on 2017/2/16.
 */

public class QRCodeScanAtivity extends DefaultQRScanActivity {

    //对控件的自定义，可以修改隐藏默认控件
    @Override
    protected void initCustomViewAndEvents() {

    }

    //扫描图片结果解析回调 recode二维码字符串
    @Override
    protected void onAlbumResult(int requestCode, int resultCode, String recode) {
        Bundle bundle = new Bundle();
        bundle.putString("result",recode);
        startActivity(new Intent(QRCodeScanAtivity.this,ResultActivity.class).putExtras(bundle));
        finish();
    }
    //二维码图片解析回调  rawResult 二维码字符串
    @Override
    protected void handleDecodeResult(String rawResult, Bundle bundle) {
        bundle.putString("result",rawResult);
        startActivity(new Intent(QRCodeScanAtivity.this,ResultActivity.class).putExtras(bundle));
        finish();
    }
}
