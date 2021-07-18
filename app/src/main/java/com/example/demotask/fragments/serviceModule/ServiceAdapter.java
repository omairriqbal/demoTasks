package com.example.demotask.fragments.serviceModule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demotask.R;
import com.example.demotask.fragments.homeModule.PaymentAdapter;
import com.example.demotask.fragments.homeModule.PaymentModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ProductViewHolder> {
        private List<PaymentModel> responses;
        Context context;

        public ServiceAdapter(Context _context, List<PaymentModel> responses) {
            this.context = _context;
            this.responses = responses;
        }

        @Override
        public ServiceAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_adapter, null);
            return new ServiceAdapter.ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ServiceAdapter.ProductViewHolder holder, final int position) {

            PaymentModel response = responses.get(position);

            holder.titleView.setText(response.getTitle());
            Glide.with(context)
                    .load(response.getImage())
//                .placeholder(R.drawable.ic_default_image)
                    .centerCrop()
//                .error(R.drawable.ic_default_image)
                    .into(holder.imageView);

        }

        @Override
        public int getItemCount() {
            return responses.size();
        }

        class ProductViewHolder extends RecyclerView.ViewHolder {

            TextView titleView;
            CircleImageView imageView;

            public ProductViewHolder(View itemView) {
                super(itemView);

                titleView = itemView.findViewById(R.id.title);
                imageView = itemView.findViewById(R.id.image);


            }

        }

    }
