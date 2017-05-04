package com.bo.yang.myretrofit.acy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.bo.yang.myretrofit.R;
import com.bo.yang.myretrofit.config.Constants;
import com.bo.yang.myretrofit.http.Request;
import com.bo.yang.myretrofit.http.YbHttp;
import com.bo.yang.myretrofit.info.HomeEntranceBean;
import com.bo.yang.myretrofit.listener.HttpResponseListener;
import com.bo.yang.myretrofit.utils.LogUtils;
import java.util.List;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDate();
    }

    private void initDate() {

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
                LogUtils.s("   homeEntranceBean  "+object.size());
                LogUtils.s("   homeEntranceBean  "+objectBean.contentURL);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {
                super.onFailure(call, e);
                LogUtils.s("   走这里了。／／／" +
                        "  ");
            }
        });

    }
}
