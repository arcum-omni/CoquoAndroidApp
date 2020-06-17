package com.ebookfrenzy.myapplication.ui.dishes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DishesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DishesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dishes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}