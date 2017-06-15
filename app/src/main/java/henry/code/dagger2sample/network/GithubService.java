package henry.code.dagger2sample.network;

import java.util.List;

import henry.code.dagger2sample.models.GithubRepo;
import henry.code.dagger2sample.models.GithubUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

  @GET("users/{username}/repos")
  Call<List<GithubRepo>> getReposForUser(@Path("username") String username);

  @GET("repositories")
  Call<List<GithubRepo>> getAllRepos();

  @GET("users/{username}")
  Call<GithubUser> getUser(@Path("username") String username);
}
