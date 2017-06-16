package henry.code.dagger2sample;

import android.app.Activity;
import android.app.Application;

import timber.log.Timber;

/**
 * Created by henry.thetswe on 15/6/17.
 */

public class GithubApplication extends Application {

    public static GithubApplication get(Activity activity) {
        return (GithubApplication) activity.getApplication();
    }

    GithubApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

    }

    public GithubApplicationComponent getComponent() {
        return component;
    }


}
