package farcry3.android.com.caioapi.Retrofit;

import java.util.List;

import farcry3.android.com.caioapi.POJO.Post;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.POST;

public interface Service {

    @GET("/posts")
    public Call<List<Post>> getPosts();

}
