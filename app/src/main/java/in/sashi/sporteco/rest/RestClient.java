package in.sashi.sporteco.rest;

import in.sashi.sporteco.rest.api.LoginService;
import in.sashi.sporteco.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static RestClient mInstance;
    private Retrofit retrofit;

    public RestClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(new
//                        GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
                .build();
    }

    public static synchronized RestClient getRestInstance(){
        if (mInstance == null){
            mInstance = new RestClient();
        }
        return mInstance;
    }

    public LoginService getLoginService(){
        return retrofit.create(LoginService.class);
    }

}
