package in.sashi.sporteco.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.io.ByteArrayOutputStream;

import in.sashi.sporteco.models.coach.CoachDetails;

public class AppUtils {

    public static String getCoachId(){
        CoachDetails details = SQLite.select()
                .from(CoachDetails.class)
                .querySingle();

        return details.coachId;
    }

    public static String bitmapToBase64String(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
        byte[] bytes = stream.toByteArray();
        return android.util.Base64.encodeToString(bytes, android.util.Base64.DEFAULT);
    }

    public static Bitmap base64StringToBitmap(String s){
        byte[] imageBytes = android.util.Base64.decode(s.getBytes(), android.util.Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }

}
