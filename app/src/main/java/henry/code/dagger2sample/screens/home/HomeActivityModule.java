package henry.code.dagger2sample.screens.home;

import dagger.Module;
import dagger.Provides;
import henry.code.dagger2sample.screens.HomeActivity;

/**
 * Created by henry.thetswe on 16/6/17.
 */

@Module
public class HomeActivityModule {

    private HomeActivity homeActivity;

    public HomeActivityModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Provides
    @HomeActivityScope
    public HomeActivity adapterRepos() {
        return homeActivity;
    }
}
