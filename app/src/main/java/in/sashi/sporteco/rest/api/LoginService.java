package in.sashi.sporteco.rest.api;

import in.sashi.sporteco.models.app.Coach;
import in.sashi.sporteco.models.app.CoachDetails;
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
