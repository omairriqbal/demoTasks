package com.example.demotask.fragments.homeModule;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.demotask.R;
import com.example.demotask.fragments.postModule.PostAdapter;
import com.example.demotask.fragments.serviceModule.ServiceFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{

 View rootView;
 ImageSlider imageSlider;
 List<SlideModel> slideModelList = new ArrayList<>();
 List<PaymentModel> paymentModelList = new ArrayList<>();
 PaymentAdapter paymentAdapter;
  RecyclerView recyclerView;
  CardView cardView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeView();
        getImageSlider();
        getPaymentRecycler();

    }

    private void getPaymentRecycler() {
        paymentModelList.add(new PaymentModel("Payment \n History","https://bit.ly/37Rn50u"));
        paymentModelList.add(new PaymentModel("Payment \n History","https://bit.ly/2YoJ77H"));
        paymentModelList.add(new PaymentModel("Payment \n History","https://bit.ly/2BteuF2"));
        paymentModelList.add(new PaymentModel("Payment \n History","https://bit.ly/3fLJf72"));
        paymentModelList.add(new PaymentModel("Payment \n History","https://bit.ly/2YoJ77H"));

        paymentAdapter = new PaymentAdapter(getActivity(), paymentModelList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(paymentAdapter);
    }

    private void getImageSlider() {
       slideModelList.add(new SlideModel("https://bit.ly/37Rn50u","Baby Owl"));
       slideModelList.add(new SlideModel("https://bit.ly/2YoJ77H","Baby Lion"));
       slideModelList.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct"));
       slideModelList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that"));
       imageSlider.setImageList(slideModelList,true);
    }

    private void initializeView() {
        imageSlider = rootView.findViewById(R.id.image_slider);

        recyclerView = rootView.findViewById(R.id.paymentRecyler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        cardView = rootView.findViewById(R.id.cardGovt);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ServiceFragment();

                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.framelayout_id, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
    }


}
