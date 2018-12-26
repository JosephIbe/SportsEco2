package in.sashi.sporteco.rest.api;

import in.sashi.sporteco.models.app.Players;
import in.sashi.sporteco.models.app.Programs;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProgramsCoachService {

    @FormUrlEncoded
    @POST("coach_programs_screen")
    Call<Programs> getProgramsCoach(
            @Field("coach_id") String coachId
    );

}
