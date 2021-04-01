package com.abdelrahman.formapplication.beneficiary;

import android.text.InputType;

import androidx.fragment.app.Fragment;

import com.abdelrahman.formapplication.R;
import com.abdelrahman.formapplication.forms.Form;
import com.abdelrahman.formapplication.forms.FormItem;
import com.abdelrahman.formapplication.forms.edit.EditFormItem;
import com.abdelrahman.formapplication.forms.edit.EditableFormItem;
import com.abdelrahman.formapplication.forms.select.SelectFormItem;
import com.abdelrahman.formapplication.listeners.SelectionObserver;
import com.abdelrahman.formapplication.listeners.UpdateView;
import com.abdelrahman.formapplication.listeners.ValueChangeObserver;
import com.abdelrahman.formapplication.numbers.NumberSelectionType;

import java.util.ArrayList;
import java.util.List;

public class BeneficiaryForm implements Form, ValueChangeObserver, SelectionObserver {
    private final UpdateView listener;
    private final Fragment context;

    private final List<FormItem> beneficiaryFormItems = new ArrayList<>();

    private final EditableFormItem accountNumberFormItem =
            new EditFormItem.Builder()
                    .withTitleRes(R.string.account)
                    .withPlaceHolder(R.string.number_iban)
                    .withMaxLength(34)
                    .withDigits("abcdefghijklmnopqrstuvwxyz1234567890")
                    .build();

    private final EditFormItem nameFormItem =
            new EditFormItem.Builder()
                    .withPlaceHolder(R.string.name)
                    .withMaxLength(35)
                    .build();

    private final EditFormItem phoneNumberFormItem =
            new EditFormItem.Builder()
                    .withPlaceHolder(R.string.phone_number)
                    .withMaxLength(15)
                    .withKeyboardInputType(InputType.TYPE_CLASS_PHONE)
                    .build();

    private final EditFormItem relationToBeneficiaryFormItem =
            new EditFormItem.Builder()
                    .withMaxLength(50)
                    .withPlaceHolder(R.string.relation_to_beneficiary)
                    .build();

    private final EditableFormItem addressFormItem =
            new EditFormItem.Builder()
                    .withTitleRes(R.string.address)
                    .withPlaceHolder(R.string.street)
                    .withMaxLength(50)
                    .withValueChangeObserver(this)
                    .build();

    private final SelectFormItem currencySelectFormItem =
            new SelectFormItem.Builder(R.string.currency, R.string.select_currency)
                    .withSelectionObserver(this)
                    .withValueChangeObserver(this)
                    .build();


    private final SelectFormItem countrySelectFormItem =
            new SelectFormItem.Builder(R.string.country, R.string.select_country)
                    .withSelectionObserver(this)
                    .withValueChangeObserver(this)
                    .build();


    private final SelectFormItem citySelectFormItem =
            new SelectFormItem.Builder(R.string.city, R.string.select_city)
                    .isSelectable(false)
                    .withValueChangeObserver(this)
                    .withSelectionObserver(this)
                    .build();


    public BeneficiaryForm(UpdateView listener, Fragment context) {
        this.listener = listener;
        this.context = context;
        beneficiaryFormItems.add(accountNumberFormItem);
        beneficiaryFormItems.add(currencySelectFormItem);
        beneficiaryFormItems.add(nameFormItem);
        beneficiaryFormItems.add(phoneNumberFormItem);
        beneficiaryFormItems.add(relationToBeneficiaryFormItem);
        beneficiaryFormItems.add(addressFormItem);
        beneficiaryFormItems.add(countrySelectFormItem);
        beneficiaryFormItems.add(citySelectFormItem);
    }

    @Override
    public List<FormItem> getFormItems() {
        return beneficiaryFormItems;
    }

    @Override
    public boolean isValid() {
        return false;
    }


    public EditableFormItem getAddressFormItem() {
        return addressFormItem;
    }

    public EditableFormItem getNameFormItem() {
        return nameFormItem;
    }

    public SelectFormItem getCurrencySelectFormItem() {
        return currencySelectFormItem;
    }

    public SelectFormItem getCountrySelectFormItem() {
        return countrySelectFormItem;
    }

    public SelectFormItem getCitySelectFormItem() {
        return citySelectFormItem;
    }

    @Override
    public void onValueChange(FormItem formItem, Object changedValue) {
        if (formItem.equals(addressFormItem)) {
            String changedValueString = (String) changedValue;
            if (changedValueString.length() >= 4) {
                addressFormItem.setError("error");
                listener.updateView(getFormItemPosition(addressFormItem));
            } else {
                addressFormItem.setError(null);
            }
        } else if (formItem.equals(currencySelectFormItem)) {
            currencySelectFormItem.setValue(changedValue);
            listener.updateView(getFormItemPosition(currencySelectFormItem));
        } else if (formItem.equals(countrySelectFormItem)) {
            countrySelectFormItem.setValue(changedValue);
            listener.updateView(getFormItemPosition(countrySelectFormItem));
            citySelectFormItem.setIsSelectable(true);
            listener.updateView(getFormItemPosition(citySelectFormItem));
        } else if (formItem.equals(citySelectFormItem)){
            citySelectFormItem.setValue(changedValue);
            listener.updateView(getFormItemPosition(citySelectFormItem));
        }

    }

    private int getFormItemPosition(FormItem formItem) {
        return beneficiaryFormItems.indexOf(formItem);
    }

    @Override
    public void onUserSelect(FormItem formItem) {
        if (formItem.equals(currencySelectFormItem)) {
            ((BeneficiaryFragment) context).getNavigationController().navigate(
                    BeneficiaryFragmentDirections.actionBeneficiaryFragmentToNumbersFragment((Integer) currencySelectFormItem.getValue(), NumberSelectionType.CURRENCY)
            );
        } else if (formItem.equals(countrySelectFormItem)) {
            ((BeneficiaryFragment) context).getNavigationController().navigate(
                    BeneficiaryFragmentDirections.actionBeneficiaryFragmentToNumbersFragment((Integer) countrySelectFormItem.getValue(),NumberSelectionType.COUNTRY)
            );
        } else if (formItem.equals(citySelectFormItem)){
            ((BeneficiaryFragment) context).getNavigationController().navigate(
                    BeneficiaryFragmentDirections.actionBeneficiaryFragmentToNumbersFragment((Integer) citySelectFormItem.getValue(),NumberSelectionType.CITY)
            );
        }
    }
}
