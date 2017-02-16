package com.example.administrator.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        test2 = (TextView) findViewById(R.id.test2);
        if (getIntent() != null){
            Bundle bundle = getIntent().getExtras();
            String result = bundle.getString("result");
            test2.setText(result);
        }
    }
}
