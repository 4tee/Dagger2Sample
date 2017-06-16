package henry.code.dagger2sample.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import henry.code.dagger2sample.GithubApplication;
import henry.code.dagger2sample.R;
import henry.code.dagger2sample.models.GithubRepo;
import henry.code.dagger2sample.network.GithubService;
import henry.code.dagger2sample.screens.home.AdapterRepos;
import henry.code.dagger2sample.screens.home.DaggerHomeActivityComponent;
import henry.code.dagger2sample.screens.home.HomeActivityComponent;
import henry.code.dagger2sample.screens.home.HomeActivityModule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.repo_home_list)
    ListView listView;

    GithubService githubService;
    Picasso picasso;

    Call<List<GithubRepo>> reposCall;

    AdapterRepos adapterRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);



        HomeActivityComponent component = DaggerHomeActivityComponent.builder()
                .homeActivityModule(new HomeActivityModule(this))
                .githubApplicationComponent(GithubApplication.get(this).getComponent())
                .build();

        githubService = component.githubService();
        picasso = component.picasso();

        adapterRepos = component.adapterRepos();
        listView.setAdapter(adapterRepos);

        reposCall = githubService.getAllRepos();
        reposCall.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                adapterRepos.swapData(response.body());
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Error getting repos " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(reposCall != null) {
            reposCall.cancel();
        }
    }
}
