package in.sashi.sporteco.rest;

import in.sashi.sporteco.models.app.Coach;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {

    @FormUrlEncoded
    @POST("coach_login")
    Call<Coach> loginCoach(
            @Field("username") String username,
            @Field("password") String password     );

}
