package farcry3.android.com.caioapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import farcry3.android.com.caioapi.Adapter.RomarioAdapter;
import farcry3.android.com.caioapi.POJO.Post;
import farcry3.android.com.caioapi.Retrofit.RetrofitConfig;
import farcry3.android.com.caioapi.Retrofit.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RomarioAdapter romarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler);


        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);

        Call<List<Post>> call = service.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                configuradorRecyclerView(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

    }

    private void configuradorRecyclerView(List<Post> postList) {
        recyclerView = findViewById(R.id.recycler);
        romarioAdapter = new RomarioAdapter(this,postList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(romarioAdapter);
    }
}
