package in.sashi.sporteco.utils;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import in.sashi.sporteco.models.app.CoachDetails;

public class AppUtils {

    public static String getCoachId(){
        CoachDetails details = SQLite.select()
                .from(CoachDetails.class)
                .querySingle();

        return details.coachId;
    }

}
