package com.bw.miaoheng20200109.api;

import com.bw.miaoheng20200109.entity.Main2Entity;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * 时间 :2020/1/9  9:03
 * 作者 :苗恒
 * 功能 :
 */
public interface Main2ApiService {
     @POST("small/user/verify/v1/addReceiveAddress")
    Observable<Main2Entity> getData(@Header("userId") String userId, @Header("sessionId")String sessionId, @Field("realName") String realName ,@Field("phone") String phone,@Field("address") String address,@Field("zipCode") String zipCode);
}
