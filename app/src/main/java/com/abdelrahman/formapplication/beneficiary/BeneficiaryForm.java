package com.abdelrahman.formapplication.beneficiary;

import android.text.InputType;

import androidx.fragment.app.Fragment;

import com.abdelrahman.form.formView.FormView;
import com.abdelrahman.form.forms.Form;
import com.abdelrahman.form.forms.FormItem;
import com.abdelrahman.form.forms.edit.EditFormItem;
import com.abdelrahman.form.forms.edit.EditableFormItem;
import com.abdelrahman.form.forms.select.SelectFormItem;
import com.abdelrahman.form.forms.select.SelectableFormItem;
import com.abdelrahman.form.forms.switchitem.SwitchFormItem;
import com.abdelrahman.form.listeners.SelectionObserver;
import com.abdelrahman.form.listeners.ValidationFailedObserver;
import com.abdelrahman.form.listeners.ValueChangeObserver;
import com.abdelrahman.formapplication.R;
import com.abdelrahman.formapplication.model.Beneficiary;
import com.abdelrahman.formapplication.numbers.NumberSelectionType;

import java.util.ArrayList;
import java.util.List;

public class BeneficiaryForm implements Form, ValueChangeObserver, SelectionObserver, ValidationFailedObserver {
    private FormView formView;
    private final Fragment context;

    private final Beneficiary beneficiary = new Beneficiary();
    private final List<FormItem> beneficiaryFormItems = new ArrayList<>();

    private final EditableFormItem accountNumberFormItem =
            new EditFormItem.Builder()
                    .withTitleRes(R.string.account)
                    .withPlaceHolder(R.string.number_iban)
                    .withMaxLength(34)
                    .withDigits("abcdefghijklmnopqrstuvwxyz1234567890")
                    .withValueChangeObserver(this)
                    .withValidationFailedObserver(this)
                    .build();

    private final EditFormItem nameFormItem =
            new EditFormItem.Builder()
                    .withPlaceHolder(R.string.name)
                    .withMaxLength(35)
                    .withValueChangeObserver(this)
                    .build();

    private final EditFormItem phoneNumberFormItem =
            new EditFormItem.Builder()
                    .withPlaceHolder(R.string.phone_number)
                    .withMaxLength(15)
                    .withKeyboardInputType(InputType.TYPE_CLASS_PHONE)
                    .withValueChangeObserver(this)
                    .build();

    private final EditFormItem relationToBeneficiaryFormItem =
            new EditFormItem.Builder()
                    .withMaxLength(50)
                    .withPlaceHolder(R.string.relation_to_beneficiary)
                    .withValueChangeObserver(this)
                    .build();

    private final EditableFormItem addressFormItem =
            new EditFormItem.Builder()
                    .withTitleRes(R.string.address)
                    .withPlaceHolder(R.string.street)
                    .withMaxLength(50)
                    .withValueChangeObserver(this)
                    .withValidationFailedObserver(this)
                    .build();

    private final SelectFormItem currencySelectFormItem =
            new SelectFormItem.Builder(R.string.currency, R.string.select_currency)
                    .withSelectionObserver(this)
                    .withValueChangeObserver(this)
                    .withValidationFailedObserver(this)
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

    private final SwitchFormItem otherBankSwitch =
            new SwitchFormItem.Builder(R.string.other_bank)
                    .withValueChangeObserver(this)
                    .build();

    private final EditFormItem swiftCodeEditFormItem =
            new EditFormItem.Builder()
                    .withMaxLength(11)
                    .withTitleRes(R.string.swift_code)
                    .withPlaceHolder(R.string.swift_code)
                    .withKeyboardInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)
                    .withValueChangeObserver(this)
                    .build();

    private final SelectFormItem swiftCountryFormItem =
            new SelectFormItem.Builder(R.string.country, R.string.select_country)
                    .withValueChangeObserver(this)
                    .withSelectionObserver(this)
                    .build();

    private final SelectFormItem swiftNameFormItem =
            new SelectFormItem.Builder(R.string.name, R.string.select_name)
                    .isSelectable(false)
                    .withValueChangeObserver(this)
                    .withSelectionObserver(this)
                    .build();

    private final SelectFormItem swiftCityFormItem =
            new SelectFormItem.Builder(R.string.city, R.string.select_city)
                    .isSelectable(false)
                    .withValueChangeObserver(this)
                    .withSelectionObserver(this)
                    .build();

    private final SelectFormItem swiftBranchFormItem =
            new SelectFormItem.Builder(R.string.branch, R.string.select_branch)
                    .isSelectable(false)
                    .withValueChangeObserver(this)
                    .withSelectionObserver(this)
                    .build();

    private final SelectFormItem swiftAddressFormItem =
            new SelectFormItem.Builder(R.string.address, R.string.empty)
                    .isSelectable(false)
                    .build();

    public void setFormView(FormView formView) {
        this.formView = formView;
    }

    public BeneficiaryForm(Fragment context) {
        this.context = context;
        beneficiaryFormItems.add(accountNumberFormItem);
        beneficiaryFormItems.add(currencySelectFormItem);
        beneficiaryFormItems.add(nameFormItem);
        beneficiaryFormItems.add(phoneNumberFormItem);
        beneficiaryFormItems.add(relationToBeneficiaryFormItem);
        beneficiaryFormItems.add(addressFormItem);
        beneficiaryFormItems.add(countrySelectFormItem);
        beneficiaryFormItems.add(citySelectFormItem);
        beneficiaryFormItems.add(otherBankSwitch);
    }

    @Override
    public List<FormItem> getFormItems() {
        return beneficiaryFormItems;
    }

    @Override
    public boolean isValid() {
        boolean isValid = true;
        for (FormItem item : beneficiaryFormItems) {
            if (!item.isValid()) {
                if (item.getValidationFailedObserver() != null)
                    item.getValidationFailedObserver().onValidationFailure(item);
                isValid = false;
            }
        }
        return isValid;
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

    //TODO : Enhance the Code and look for CIB IOS Code
    //TODO : make it more generic if u can
    @Override
    public void onValueChange(FormItem formItem, Object changedValue) {
        if (formItem instanceof EditableFormItem)
            ((EditableFormItem) formItem).setError(null);
        if (formItem instanceof SelectableFormItem)
            ((SelectableFormItem) formItem).setError(null);
        if (formItem.equals(addressFormItem)) {
            String changedValueString = (String) changedValue;
            beneficiary.setAddress(changedValueString);
            addressFormItem.setError(null);
            if (changedValueString.length() >= 4) {
                addressFormItem.setError("error");
                formView.updateView(getFormItemPosition(addressFormItem));
            }
        } else if (formItem.equals(currencySelectFormItem)) {
            currencySelectFormItem.setValue(changedValue);
            formView.updateView(getFormItemPosition(currencySelectFormItem));
            beneficiary.setAccountCurrencyCode(Integer.parseInt(changedValue.toString()));
        } else if (formItem.equals(countrySelectFormItem)) {
            countrySelectFormItem.setValue(changedValue);
            formView.updateView(getFormItemPosition(countrySelectFormItem));
            citySelectFormItem.setIsSelectable(true);
            formView.updateView(getFormItemPosition(citySelectFormItem));
            beneficiary.setCountryId(Integer.parseInt(changedValue.toString()));
        } else if (formItem.equals(citySelectFormItem)) {
            citySelectFormItem.setValue(changedValue);
            formView.updateView(getFormItemPosition(citySelectFormItem));
            beneficiary.setCityId(Integer.parseInt(changedValue.toString()));
        } else if (formItem.equals(otherBankSwitch) && (boolean) changedValue) {
            addOtherBankFormItems();
            swiftCodeEditFormItem.setIsRequired(true);
        } else if (formItem.equals(otherBankSwitch) && !((boolean) changedValue)) {
            removeOtherBanksFormItems();
            swiftCodeEditFormItem.setIsRequired(false);
        } else if (formItem.equals(accountNumberFormItem)) {
            beneficiary.setAccountNumber((String) changedValue);
        } else if (formItem.equals(nameFormItem)) {
            beneficiary.setName((String) changedValue);
        } else if (formItem.equals(phoneNumberFormItem)) {
            beneficiary.setPhoneNumber((String) changedValue);
        } else if (formItem.equals(relationToBeneficiaryFormItem)) {
            beneficiary.setRelation((String) changedValue);
        } else if (formItem.equals(swiftCodeEditFormItem)) {
            beneficiary.setSwiftCode((String) changedValue);
        }

    }

    private void removeOtherBanksFormItems() {
        beneficiaryFormItems.remove(swiftCodeEditFormItem);
        beneficiaryFormItems.remove(swiftCountryFormItem);
        beneficiaryFormItems.remove(swiftNameFormItem);
        beneficiaryFormItems.remove(swiftCityFormItem);
        beneficiaryFormItems.remove(swiftBranchFormItem);
        beneficiaryFormItems.remove(swiftAddressFormItem);
        formView.notifyDataChange();
        formView.scrollToPosition(getFormItemPosition(otherBankSwitch));
    }

    private void addOtherBankFormItems() {
        beneficiaryFormItems.add(swiftCodeEditFormItem);
        beneficiaryFormItems.add(swiftCountryFormItem);
        beneficiaryFormItems.add(swiftNameFormItem);
        beneficiaryFormItems.add(swiftCityFormItem);
        beneficiaryFormItems.add(swiftBranchFormItem);
        beneficiaryFormItems.add(swiftAddressFormItem);
        formView.notifyDataChange();
        formView.scrollToPosition(beneficiaryFormItems.size());
    }

    private int getFormItemPosition(FormItem formItem) {
        return beneficiaryFormItems.indexOf(formItem);
    }

    @Override
    public void onUserSelect(FormItem formItem) {
        if (formItem.equals(currencySelectFormItem)) {
            ((BeneficiaryFragment) context).getNavigationController().navigate(
                    BeneficiaryFragmentDirections.actionBeneficiaryFragmentToNumbersFragment((String) currencySelectFormItem.getValue(), NumberSelectionType.CURRENCY)
            );
        } else if (formItem.equals(countrySelectFormItem)) {
            ((BeneficiaryFragment) context).getNavigationController().navigate(
                    BeneficiaryFragmentDirections.actionBeneficiaryFragmentToNumbersFragment((String) countrySelectFormItem.getValue(), NumberSelectionType.COUNTRY)
            );
        } else if (formItem.equals(citySelectFormItem)) {
            ((BeneficiaryFragment) context).getNavigationController().navigate(
                    BeneficiaryFragmentDirections.actionBeneficiaryFragmentToNumbersFragment((String) citySelectFormItem.getValue(), NumberSelectionType.CITY)
            );
        }
    }

    @Override
    public void onValidationFailure(FormItem formItem) {
        if (formItem.equals(accountNumberFormItem)) {
            handleFormItemFailure(accountNumberFormItem, "invalid account number");
        } else if (formItem.equals(addressFormItem)) {
            handleFormItemFailure(addressFormItem, "Invalid Address");
        } else if (formItem.equals(currencySelectFormItem)) {
            handleFormItemFailure(currencySelectFormItem, "currency must be selected");
        }
    }

    private void handleFormItemFailure(EditableFormItem formItem, String errorMessage) {
        int formItemIndex = getFormItemPosition(formItem);
        formItem.setError(errorMessage);
        formView.updateView(formItemIndex);
    }

    private void handleFormItemFailure(SelectableFormItem formItem, String errorMessage) {
        int formItemIndex = getFormItemPosition(formItem);
        formItem.setError(errorMessage);
        formView.updateView(formItemIndex);
    }
}
