package com.bw.miaoheng20200109;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bw.miaoheng20200109.adapter.AddressAdapter;
import com.bw.miaoheng20200109.api.AddressApiService;
import com.bw.miaoheng20200109.api.Api;
import com.bw.miaoheng20200109.api.Main2ApiService;
import com.bw.miaoheng20200109.entity.AddressEntity;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdressActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress);
        //查询控件id
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//日志拦截器
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.BASE_RL)
                .build();
         retrofit.create(AddressApiService.class)
                 .getData("13387","157853026016113387")
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<AddressEntity>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(AddressEntity addressEntity) {
                            //成功
                         List<AddressEntity.ResultBean> result = addressEntity.getResult();
                         AddressAdapter addressAdapter = new AddressAdapter(AdressActivity.this, result);
                         recyclerView.setAdapter(addressAdapter);
                     }

                     @Override
                     public void onError(Throwable e) {

                     }

                     @Override
                     public void onComplete() {

                     }
                 });
    }

    public void zaitiao(View view) {
           startActivity(new Intent(this,Main2Activity.class));
    }
}
