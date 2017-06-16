package henry.code.dagger2sample;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by henry.thetswe on 15/6/17.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context context() {
        return context;
    }
}
