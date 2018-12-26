package in.sashi.sporteco.rest;

import in.sashi.sporteco.rest.api.LoginService;
import in.sashi.sporteco.rest.api.ProgramsCoachService;
import in.sashi.sporteco.rest.api.ResponseInterceptor;
import in.sashi.sporteco.utils.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static RestClient mInstance;
    private Retrofit retrofit;

    public RestClient() {

//        OkHttpClient client = new OkHttpClient();
//        client.interceptors().add(new ResponseInterceptor());

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
                .build();
    }

    public static synchronized RestClient getRestInstance() {
        if (mInstance == null) {
            mInstance = new RestClient();
        }
        return mInstance;
    }

    public LoginService getLoginService() {
        return retrofit.create(LoginService.class);
    }

    public ProgramsCoachService getProgramsService() {
        return retrofit.create(ProgramsCoachService.class);
    }

}
