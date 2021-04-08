package com.abdelrahman.formapplication.listeners;

import com.abdelrahman.formapplication.forms.FormItem;

public interface ValidationFailedObserver {
    void onValidationFailure(FormItem formItem);
}
