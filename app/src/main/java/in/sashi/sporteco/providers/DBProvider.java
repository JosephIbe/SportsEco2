package in.sashi.sporteco.providers;

import com.activeandroid.Configuration;
import com.activeandroid.content.ContentProvider;

import in.sashi.sporteco.models.app.Players;
import in.sashi.sporteco.models.app.Batch;
import in.sashi.sporteco.models.app.Coach;
import in.sashi.sporteco.models.app.PlayerSession;
import in.sashi.sporteco.models.app.Sessions;

public class DBProvider extends ContentProvider {

    @Override
    protected Configuration getConfiguration() {
        Configuration.Builder builder = new Configuration.Builder(getContext());
        builder.addModelClass(Coach.class);
        builder.addModelClass(Batch.class);
        builder.addModelClass(Sessions.class);
        builder.addModelClass(Players.class);
        builder.addModelClass(PlayerSession.class);
        return builder.create();
    }
}
