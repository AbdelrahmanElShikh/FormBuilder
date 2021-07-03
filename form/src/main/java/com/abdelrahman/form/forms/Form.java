package com.abdelrahman.form.forms;

import java.util.List;

public interface Form {
    List<FormItem> getFormItems();

    boolean isValid();
}
