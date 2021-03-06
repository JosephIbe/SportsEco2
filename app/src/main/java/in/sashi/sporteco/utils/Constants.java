package in.sashi.sporteco.utils;

public class Constants {

    public static final String YOUTUBE_API_KEY = "AIzaSyAEl2evPV8CFJlNUVSU5ruXFC5jChs0ctk";

    /***
     *  Prefs Keys
     * **/
    public static String VIDEO_OF_DAY_PREFS_KEY = "check_vod";
    public static String SET_THEME_PREFS_KEY = "check_vod";

    /***
     *  API URLS
     * **/

    public static final String BASE_URL = "http://devsports.copycon.in/api/";

    public static final String SUCCESS_MSG = "success";

    public static final String VID_OF_DAY_URL = BASE_URL + "get_video_today";

    public static final String LOGIN_COACH = BASE_URL + "coach_login";


//    public static final String COACH_BATCH_LIST = BASE_URL + "coach_batch_list/";
//
//    public static final String COACH_PROGRAM_LIST = BASE_URL + "coach_program_list/";
//
//    public static final String SESSION_LIST = BASE_URL + "coach_program_session_list";
//
//    public static final String COACH_PLAYER_LIST = BASE_URL + "players_under_coach";
//
//    public static final String COACH_PLAYER_LIST_SESSION = BASE_URL + "coach_player_list";
//
//    public static final String SESSION_DRILLS_API = BASE_URL + "session_drills"; // prg_session_id, prg_id
//
//    public static final String PLAYER_ATTENDANCE = BASE_URL + "program_player_attendance";
//    //prg_user_map_id, prg_session_id, batch_id, coach_id (int), player_id (str arr), att_status (str_arr)
//
//    public static final String UPLOAD_PLAYER_IMAGE = BASE_URL + "player_image_upload"; //file name: player_image
//
//    public static final String UPLOAD_PLAYER_VIDEO = BASE_URL + "player_video_upload"; //file name: player_video
//
//    public static final String COACH_PLAYER_FEEDBACK = BASE_URL + "coach_player_feedback";
//
//    public static final String PROFILE_COACH = BASE_URL + "get_coach_profile";
//
//    public static final String GET_PLAYER_PROFILE = BASE_URL + "get_player_profile";
//
//    public static final String MARK_SESSION_COMPLETE = BASE_URL + "session_complete";
//
//    public static final String PLAYER_ATTENDANCE_STATS = BASE_URL + "attendance_statistics'";
//
//    public static final String GET_COMPLETED_SESSIONS = BASE_URL + "completed_sessions'";

    /**
     *  Session Constanta
     * **/

    public static final String SESSION_NAME_KEY = "session_name";
    public static final String SESSION_ID_KEY = "session_id";

    /**
     *  Player Constants
     *
     * */

    public static final String PLAYER_KEY_USER_ID = "user_id";
    public static final String PLAYER_KEY_IMAGE_URL = "player_img_url";
    public static final String PLAYER_KEY_NAME = "player_name";
    public static final String PLAYER_KEY_ADDRESS = "player_address";
    public static final String PLAYER_KEY_STATE = "player_state";

    /**
     *  Program Constants
     *
     * */

    public static final String PROGRAM_ID_KEY = "program_id";
    public static final String PROGRAM_NAME_KEY = "program_name";
    public static final String PROGRAM_DESC_KEY = "program_desc";
    public static final String PROGRAM_PLACE_NAME_KEY = "program_place_name";

    /**
     *  Program Session Constants
     *
     * */
    public static final String PROGRAM_SESSION_ID_KEY = "program_session_id";

    /**
     *  Drills Constants
     * **/

    public static final String DRILL_TITLE_KEY = "drill_title";
    public static final String DRILL_DURATION_KEY = "drill_duration";


}
