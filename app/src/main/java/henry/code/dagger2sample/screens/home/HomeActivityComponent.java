package henry.code.dagger2sample.screens.home;

import dagger.Component;
import henry.code.dagger2sample.GithubApplicationComponent;
import henry.code.dagger2sample.screens.HomeActivity;

/**
 * Created by henry.thetswe on 16/6/17.
 */

@HomeActivityScope
@Component(modules = HomeActivityModule.class, dependencies = GithubApplicationComponent.class)
public interface HomeActivityComponent {

    HomeActivity injectHomeActivity(HomeActivity homeActivity);

}
