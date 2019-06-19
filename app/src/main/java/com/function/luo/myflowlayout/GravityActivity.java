package com.function.luo.myflowlayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by luo on 2019/6/18.
 *
 * 对齐方式
 */

public class GravityActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gravity_flow_layout);
    }



    public static void launch(Context context) {
        Intent intent = new Intent(context, GravityActivity.class);
        context.startActivity(intent);
    }
}
