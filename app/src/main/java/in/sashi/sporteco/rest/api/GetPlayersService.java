package in.sashi.sporteco.rest.api;

import in.sashi.sporteco.models.app.Players;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetPlayersService {

    @GET("")
    Call<Players> getPlayersUnderCoach(
            //add fields
    );

}
