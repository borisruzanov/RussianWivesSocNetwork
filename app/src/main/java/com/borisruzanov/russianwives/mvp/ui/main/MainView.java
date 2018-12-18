package com.borisruzanov.russianwives.mvp.ui.main;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;

public interface MainView extends MvpView{

    void callAuthWindow();
    void setAdapter(boolean isUserExist);
    void showNecessaryInfoDialog(String image, String gender, String age);
    void showAdditionalInfoDialog();
    void openSlider(ArrayList<String> stringList);
}
