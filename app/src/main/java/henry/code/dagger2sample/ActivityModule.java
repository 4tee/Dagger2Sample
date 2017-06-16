package henry.code.dagger2sample;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by henry.thetswe on 16/6/17.
 */

@Module
public class ActivityModule {

    private final Activity context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @Provides
    @GithubApplicationScope
    @Named("activity_context")
    public Context context() {
        return context;
    }
}
