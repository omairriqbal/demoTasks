package com.example.demotask.fragments.homeModule;

public class PaymentModel {
    String title;
    String image;

    public PaymentModel(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String text) {
        this.image = text;
    }
}
