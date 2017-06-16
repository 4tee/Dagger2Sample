package henry.code.dagger2sample.screens.home;

import com.squareup.picasso.Picasso;

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
    public AdapterRepos adapterRepos(Picasso picasso) {
        return new AdapterRepos(homeActivity, picasso);
    }
}
