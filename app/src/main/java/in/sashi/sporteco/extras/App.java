package in.sashi.sporteco.extras;

import android.app.Application;

//import com.activeandroid.ActiveAndroid;
import com.androidnetworking.AndroidNetworking;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(this);
//        ActiveAndroid.initialize(this);
    }
}
