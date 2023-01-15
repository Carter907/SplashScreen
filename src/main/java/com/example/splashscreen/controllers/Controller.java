package com.example.splashscreen.controllers;


import com.example.splashscreen.view.View;

public abstract class Controller {

    protected View view;

    protected Controller(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
