package com.abdelrahman.form.forms.edit;


import com.abdelrahman.form.forms.FormItem;
import com.abdelrahman.form.listeners.ValueChangeObserver;

public interface EditableFormItem extends FormItem {

    Integer getPlaceHolder();

    void setPlaceHolder(Integer placeHolder);

    String getError();

    void setError(String error);

    int getMaxLength();

    void setMaxLength(int maxLength);

    int getKeyboardType();

    void setKeyBoardType(int keyboardType);

    String getDigits();

    void setDigits(String digits);

    ValueChangeObserver getValueChangeObserver();

    void setChangeObserver(ValueChangeObserver observer);

}
