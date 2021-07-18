package com.example.demotask.fragments.postModule;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demotask.R;
import com.example.demotask.webservice.ApiClient;
import com.example.demotask.webservice.ApiInterface;
import com.example.demotask.webservice.apimodel.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostFragment extends Fragment {
    RecyclerView recyclerView;

    ApiInterface apiService;
    ProgressDialog progressDialog;
    PostAdapter adapter;
    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_post, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeView();
        getApiCall();
    }


    private void getApiCall() {
        apiService = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        progressDialog.show();

        Call<List<PostModel>> call = apiService.getAllPosts();
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                progressDialog.dismiss();
                System.out.println("res123" + response.body());
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                progressDialog.dismiss();
            }

        });
    }

    private void initializeView() {

        recyclerView = rootView.findViewById(R.id.postRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("loading.....");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
    }

    private void generateDataList(List<PostModel> postModels) {

        adapter = new PostAdapter(getActivity(), postModels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}