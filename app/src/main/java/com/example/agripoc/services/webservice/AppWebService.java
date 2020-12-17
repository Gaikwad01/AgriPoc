package com.example.agripoc.services.webservice;


import com.rblfinserve.rvf.services.interceptors.DownloadOkHtttpClient;
import com.rblfinserve.rvf.services.interceptors.NullOnEmptyConverterFactory;
import com.rblfinserve.rvf.services.interceptors.UnsafeOkHttpClient;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.rblfinserve.rvf.constant.AppConstant.BASE_URL;

public class AppWebService {

    private static OkHttpClient httpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
//    private static OkHttpClient httpClient = new OkHttpClient();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .addConverterFactory(new NullOnEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .client(httpClient);

    public static void changeApiBaseUrl(String newBASE_URL) {
        BASE_URL = newBASE_URL;
        builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .baseUrl(BASE_URL)
                .client(httpClient);
    }

    public static void changeDownloadBaseUrl(String newBASE_URL,
                                             DownloadOkHtttpClient.ProgressListener progressListener) {
        OkHttpClient downloadHttpClient = DownloadOkHtttpClient.getDownloadOkHttpClient(progressListener);
        BASE_URL = newBASE_URL;
        builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .baseUrl(BASE_URL)
                .client(downloadHttpClient);
    }

    public static <S> S createService(Class<S> serviceClass) {
        return builder.build().create(serviceClass);
    }


}
