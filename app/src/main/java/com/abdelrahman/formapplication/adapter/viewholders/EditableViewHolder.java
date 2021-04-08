package com.abdelrahman.formapplication.adapter.viewholders;

import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.formapplication.R;
import com.abdelrahman.formapplication.databinding.EditableFormItemBinding;
import com.abdelrahman.formapplication.forms.FormBinder;
import com.abdelrahman.formapplication.forms.FormItem;
import com.abdelrahman.formapplication.forms.edit.EditableFormItem;

import java.util.Objects;

public class EditableViewHolder extends RecyclerView.ViewHolder implements FormBinder, TextWatcher {
    private final EditableFormItemBinding binding;
    private final EditableFormItem item;

    public EditableViewHolder(@NonNull View itemView, FormItem item) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
        this.item = (EditableFormItem) item;
    }

    @Override
    public void bind() {
        /* Binding Logic */
        if (item.getTitle() == null) {
            binding.header.setVisibility(View.GONE);
        } else {
            binding.header.setText(item.getTitle());
        }
        if (item.getMaxLength() > 0)
            binding.editTextLayout.setFilters(new InputFilter[]{new InputFilter.LengthFilter(item.getMaxLength())});

        if (item.getDigits() != null && !item.getDigits().isEmpty()) {
            binding.editTextLayout.setKeyListener(DigitsKeyListener.getInstance(item.getDigits()));
            binding.editTextLayout.setRawInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        } else {
            binding.editTextLayout.setInputType(item.getKeyboardType());
        }
        binding.editTextLayout.setText((String) item.getValue());
        binding.editTextLayout.setSelection(Objects.requireNonNull(binding.editTextLayout.getText()).length());
        binding.editTextLayout.setHint(item.getPlaceHolder() == null ? R.string.empty : item.getPlaceHolder());
        binding.textInputLayout.setError(item.getError());
        binding.editTextLayout.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (binding.editTextLayout.hasFocus() && item.getValueChangeObserver() != null) {
            item.getValueChangeObserver().onValueChange(item, s.toString());
            binding.textInputLayout.setError(item.getError());
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        item.setValue(s.toString());
    }
}
