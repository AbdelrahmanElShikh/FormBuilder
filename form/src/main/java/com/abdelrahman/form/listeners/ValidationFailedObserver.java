package com.abdelrahman.form.listeners;


import com.abdelrahman.form.forms.FormItem;

public interface ValidationFailedObserver {
    void onValidationFailure(FormItem formItem);
}