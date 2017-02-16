package com.example.administrator.test;

import android.content.Intent;
import android.os.Bundle;

import com.example.qrlibrary.qrcode.activity.DefaultQRScanActivity;

/**
 * Created by ShuWen on 2017/2/16.
 */

public class QRCodeScanAtivity extends DefaultQRScanActivity {

    @Override
    protected void initCustomViewAndEvents() {

    }

    @Override
    protected void onAlbumResult(int requestCode, int resultCode, String recode) {
        Bundle bundle = new Bundle();
        bundle.putString("result",recode);
        startActivity(new Intent(QRCodeScanAtivity.this,ResultActivity.class).putExtras(bundle));
        finish();
    }

    @Override
    protected void handleDecodeResult(String rawResult, Bundle bundle) {
        bundle.putString("result",rawResult);
        startActivity(new Intent(QRCodeScanAtivity.this,ResultActivity.class).putExtras(bundle));
        finish();
    }
}
