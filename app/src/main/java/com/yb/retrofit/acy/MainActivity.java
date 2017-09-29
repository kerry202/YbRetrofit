package com.yb.retrofit.acy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yb.retrofit.R;
import com.yb.retrofit.config.Constants;
import com.yb.retrofit.http.Request;
import com.yb.retrofit.http.YbHttp;
import com.yb.retrofit.info.Demo;
import com.yb.retrofit.info.HomeEntranceBean;
import com.yb.retrofit.info.MessageEvent;
import com.yb.retrofit.listener.HttpResponseListener;
import com.yb.retrofit.utils.LogUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        findViewById(R.id.call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("tel:" + "15010090621"));
                startActivity(intent);
            }
        });




        initDate();

    }

    // This method will be called when a MessageEvent is posted (in the UI thread for Toast)
// 当MessageEvent被当做参数发送的时候这个方法将会被触发.
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {

        Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show();

    }


    private void initDate() {

        EventBus.getDefault().post(new Demo());


        Request request = YbHttp.newPostRequest(Constants.URL_HOME_ENTRANCE);
        request.putParams("appName", "鲜花中国");
        request.putParams("platform", "Android");
        request.putParams("isNationwide", "true");
        request.putParams("version", Constants.VERSION_CONFIG);


        YbHttp.send(request, new HttpResponseListener<HomeEntranceBean>() {

            @Override
            public void onResponse(HomeEntranceBean homeEntranceBean, Headers headers) {

                List<HomeEntranceBean.ObjectBean> object = homeEntranceBean.object;
                HomeEntranceBean.ObjectBean objectBean = object.get(0);
                LogUtils.s("   homeEntranceBean  " + object.size());
                LogUtils.s("   homeEntranceBean  " + objectBean.contentURL);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {
                super.onFailure(call, e);

            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//取消注册
    }
}
