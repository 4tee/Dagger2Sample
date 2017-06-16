package henry.code.dagger2sample;

import com.squareup.picasso.Picasso;

import dagger.Component;
import henry.code.dagger2sample.network.GithubService;

/**
 * Created by henry.thetswe on 15/6/17.
 */
@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class, ActivityModule.class})
public interface GithubApplicationComponent {

    Picasso picasso();
    GithubService githubService();

}
