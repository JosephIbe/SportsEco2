package in.sashi.sporteco.rest.api;

import in.sashi.sporteco.models.app.Coach;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GetCoachProfileService {

    @FormUrlEncoded
    @POST("coach_profile_screen")
    Call<Coach> profileCoach(@Field("coach_id") String coachId);

}
