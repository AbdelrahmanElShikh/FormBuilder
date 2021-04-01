package com.abdelrahman.formapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Object> selectedCurrency = new MutableLiveData<>();
    private final MutableLiveData<Object> selectedCountry = new MutableLiveData<>();
    private final MutableLiveData<Object> selectedCity = new MutableLiveData<>();

    public void selectCurrency(Object item) {
        selectedCurrency.setValue(item);
    }

    public LiveData<Object> getSelectedCurrency() {
        return selectedCurrency;
    }

    public void selectCountry(Object item) {
        selectedCountry.setValue(item);
    }

    public LiveData<Object> getSelectedCountry() {
        return selectedCountry;
    }

    public void selectCity(Object item) {
        selectedCity.setValue(item);
    }

    public LiveData<Object> getSelectedCity() {
        return selectedCity;
    }

}
