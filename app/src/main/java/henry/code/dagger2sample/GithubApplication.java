package henry.code.dagger2sample;

import android.app.Activity;
import android.app.Application;

import com.squareup.picasso.Picasso;

import henry.code.dagger2sample.network.GithubService;
import timber.log.Timber;

/**
 * Created by henry.thetswe on 15/6/17.
 */

public class GithubApplication extends Application {

    public static GithubApplication get(Activity activity) {
        return (GithubApplication) activity.getApplication();
    }

    private GithubService githubService;
    private Picasso picasso;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        GithubApplicationComponent component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        githubService = component.githubService();
        picasso = component.picasso();
    }

    public GithubService getGithubService() {
        return githubService;
    }

    public Picasso getPicasso() {
        return picasso;
    }


}
