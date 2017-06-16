package henry.code.dagger2sample.screens.home;

import com.squareup.picasso.Picasso;

import dagger.Component;
import henry.code.dagger2sample.GithubApplicationComponent;
import henry.code.dagger2sample.network.GithubService;

/**
 * Created by henry.thetswe on 16/6/17.
 */

@HomeActivityScope
@Component(modules = HomeActivityModule.class, dependencies = GithubApplicationComponent.class)
public interface HomeActivityComponent {

    AdapterRepos adapterRepos();
    GithubService githubService();
    Picasso picasso();

}
