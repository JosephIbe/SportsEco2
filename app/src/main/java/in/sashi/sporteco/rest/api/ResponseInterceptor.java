package in.sashi.sporteco.rest.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ResponseInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        String raw = response.body().string();
        return response.newBuilder().body(ResponseBody.create(response.body().contentType(), raw)).build();
    }
}
