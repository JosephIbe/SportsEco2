package in.sashi.sporteco.extras;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(this);
        FlowManager.init(new FlowConfig.Builder(this).build());
    }
}
