package com.abdelrahman.formapplication.forms.edit;

import com.abdelrahman.formapplication.listeners.ValueChangeObserver;
import com.abdelrahman.formapplication.forms.FormItem;

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
