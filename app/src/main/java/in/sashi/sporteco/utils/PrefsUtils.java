package in.sashi.sporteco.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsUtils {

    private Context context;
    private SharedPreferences coachPrefs;
    private SharedPreferences.Editor editor;

    public static final String LOGGED_IN_KEY = "is_logged_in";

    public PrefsUtils(Context ctx) {
        this.context = ctx;
        coachPrefs = ctx.getSharedPreferences(LOGGED_IN_KEY, Context.MODE_PRIVATE);
        editor = coachPrefs.edit();
    }

    public void saveLoginStatus(boolean hasLoggedIn){
        editor.putBoolean(LOGGED_IN_KEY, hasLoggedIn);
        editor.apply();
    }

    public boolean getLoginStatus(){
        return coachPrefs.getBoolean(LOGGED_IN_KEY, false);
    }

}
