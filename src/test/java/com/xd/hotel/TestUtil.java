package com.xd.hotel;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

/**
 * @author jiaqi
 * @date 2019/6/25
 * @contact jqhu340@gmail.com
 */

@Slf4j
public class TestUtil {

    public static void postSend(String url, RequestBody body) {
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                log.debug("onFailure:");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                log.debug(response.protocol() + " " + response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    log.debug(headers.name(i) + ":" + headers.value(i));
                }
                log.debug("onResponse: " + response.body().string());
            }
        });
    }

    public static void getSend(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                log.debug("onFailure:");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                log.debug("onResponse: " + response.body().string());
            }
        });
    }
}
