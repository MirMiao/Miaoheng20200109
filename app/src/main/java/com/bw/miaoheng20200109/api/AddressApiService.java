package com.bw.miaoheng20200109.api;

import com.bw.miaoheng20200109.entity.AddressEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * 时间 :2020/1/9  9:10
 * 作者 :苗恒
 * 功能 :
 */
public interface AddressApiService {
    @GET("small/user/verify/v1/receiveAddressList")
    Observable<AddressEntity> getData(@Header("userId") String userId, @Header("sessionId")String sessionId);
}
