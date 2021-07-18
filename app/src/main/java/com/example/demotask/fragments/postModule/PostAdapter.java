package com.example.demotask.fragments.postModule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demotask.R;
import com.example.demotask.webservice.apimodel.PostModel;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ProductViewHolder> {
    private List<PostModel> responses;
    Context context;

    public PostAdapter(Context _context, List<PostModel> responses) {
        this.context = _context;
        this.responses = responses;
    }

    @Override
    public PostAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_adapter, null);
        return new PostAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostAdapter.ProductViewHolder holder, final int position) {
        //   Response jokeResponse = response.get(position);
        // holder.Image.setImageDrawable(jokeResponse.getImage());
        PostModel response = responses.get(position);
        /*Glide
                .with(context)
                .load(ApiClient.IMAGE_BASE_URL + response.get(position).getImage())
                .into(holder.Image);*/

        holder.TitleView.setText(response.getTitle());
        holder.DescView.setText(response.getBody());
       /* GlideApp.with(context)
                .load(response.getImageUrl() + response.getImage())
                .placeholder(R.drawable.ic_default_image)
                .centerCrop()
                .error(R.drawable.ic_default_image)
                .into(holder.imageView);*/

    }


    @Override
    public int getItemCount() {
        return responses.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView TitleView, DescView;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            TitleView = itemView.findViewById(R.id.post_title);
            DescView = itemView.findViewById(R.id.post_desc);


        }

    }

}
