package farcry3.android.com.caioapi.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import farcry3.android.com.caioapi.POJO.Post;
import farcry3.android.com.caioapi.R;

public class RomarioAdapter extends RecyclerView.Adapter<RomarioAdapter.ViewHolder>{

    List<Post> listaDePosts;
    Context c;

    public RomarioAdapter(Context c,List<Post> lista){
        this.c = c;
        this.listaDePosts = lista;

    }

    @Override
    public RomarioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflate.inflate(R.layout.item, parent, false));

    }

    @Override
    public void onBindViewHolder(RomarioAdapter.ViewHolder holder, int position) {
        Post p1 = listaDePosts.get(position);
        holder.bind(p1.getUserId(), p1.getId(), p1.getTitle(), p1.getBody());
    }

    @Override
    public int getItemCount() {
        return this.listaDePosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView userId;
        TextView id;
        TextView title;
        TextView body;

        public ViewHolder(View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.userId);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);

        }

        public void bind(String userId, String id, String title, String body){
            this.userId.setText(userId);
            this.id.setText(id);
            this.title.setText(title);
            this.body.setText(body);
        }
    }
}


