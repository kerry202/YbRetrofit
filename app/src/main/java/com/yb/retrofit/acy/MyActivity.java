package com.yb.retrofit.acy;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.yb.retrofit.R;
import com.yb.retrofit.info.Demo;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by yangbo on 2017/6/21.
 */

public class MyActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);


    }


    @Subscribe          //订阅事件FirstEvent
    public void onEventMainThread(Demo event) {
        event.name = "nihao";

        Toast.makeText(this, event.name, Toast.LENGTH_LONG).show();//获取事件中传递的参数
    }


}
