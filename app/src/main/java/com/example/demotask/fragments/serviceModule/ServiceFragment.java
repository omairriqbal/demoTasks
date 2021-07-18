package com.example.demotask.fragments.serviceModule;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demotask.R;
import com.example.demotask.fragments.homeModule.PaymentAdapter;
import com.example.demotask.fragments.homeModule.PaymentModel;

import java.util.ArrayList;
import java.util.List;

public class ServiceFragment extends Fragment {

    List<PaymentModel> paymentModelList = new ArrayList<>();
    ServiceAdapter serviceAdapter;
    RecyclerView recyclerView;
    View rootView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeView();

        getPaymentRecycler();
    }

    private void getPaymentRecycler() {
        paymentModelList.add(new PaymentModel("Picture 1","https://bit.ly/37Rn50u"));
        paymentModelList.add(new PaymentModel("Picture 2","https://bit.ly/2YoJ77H"));
        paymentModelList.add(new PaymentModel("Picture 3","https://bit.ly/2BteuF2"));
        paymentModelList.add(new PaymentModel("Picture 4","https://bit.ly/3fLJf72"));
        paymentModelList.add(new PaymentModel("Picture 5","https://bit.ly/2YoJ77H"));
        paymentModelList.add(new PaymentModel("Picture 6","https://bit.ly/2YoJ77H"));
        paymentModelList.add(new PaymentModel("Picture 7","https://bit.ly/2BteuF2"));
        paymentModelList.add(new PaymentModel("Picture 8","https://bit.ly/3fLJf72"));
        paymentModelList.add(new PaymentModel("Picture 9","https://bit.ly/37Rn50u"));
        paymentModelList.add(new PaymentModel("Picture 10","https://bit.ly/2BteuF2"));
        paymentModelList.add(new PaymentModel("Picture 11","https://bit.ly/3fLJf72"));
        paymentModelList.add(new PaymentModel("Picture 12","https://bit.ly/2YoJ77H"));
        paymentModelList.add(new PaymentModel("Picture 13","https://bit.ly/37Rn50u"));
        paymentModelList.add(new PaymentModel("Picture 14","https://bit.ly/2YoJ77H"));
        paymentModelList.add(new PaymentModel("Picture 15","https://bit.ly/2BteuF2"));
        paymentModelList.add(new PaymentModel("Picture 16","https://bit.ly/3fLJf72"));

        serviceAdapter = new ServiceAdapter(getActivity(), paymentModelList);

        recyclerView.setAdapter(serviceAdapter);
    }

    private void initializeView() {

        recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_service, container, false);
        return rootView;
    }
}