package com.bw.miaoheng20200109;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.miaoheng20200109.api.Api;
import com.bw.miaoheng20200109.api.Main2ApiService;
import com.bw.miaoheng20200109.entity.Main2Entity;

import java.net.URLEncoder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

    private EditText et_address;
    private EditText et_name;
    private EditText et_phone;
    private EditText et_zipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //查询控件id
        et_address = findViewById(R.id.et_address);
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_zipCode = findViewById(R.id.et_zipCode);
        Button button = findViewById(R.id.sure);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //获取输入的内容
                 String address = et_address.getText().toString();




                 String name = et_name.getText().toString();

                 String phone = et_phone.getText().toString();

                 String zipCode = et_zipCode.getText().toString();

                 OkHttpClient okHttpClient=new OkHttpClient.Builder()
                         .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//日志拦截器
                         .build();
                 Retrofit retrofit=new Retrofit.Builder()
                         .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                         .addConverterFactory(GsonConverterFactory.create())
                         .baseUrl(Api.BASE_RL)
                         .build();
                 retrofit.create(Main2ApiService.class)
                         .getData("13387","157853026016113387",name,phone,address,zipCode)
                         .subscribeOn(Schedulers.io())
                         .observeOn(AndroidSchedulers.mainThread())
                         .subscribe(new Observer<Main2Entity>() {
                             @Override
                             public void onSubscribe(Disposable d) {

                             }

                             @Override
                             public void onNext(Main2Entity main2Entity) {
                                 Toast.makeText(Main2Activity.this, "添加成功", Toast.LENGTH_SHORT).show();
                             }

                             @Override
                             public void onError(Throwable e) {
                                 Toast.makeText(Main2Activity.this, "添加失败", Toast.LENGTH_SHORT).show();
                             }

                             @Override
                             public void onComplete() {

                             }
                         });
                 finish();
             }
         });

    }


}
