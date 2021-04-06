package com.abdelrahman.formapplication.adapter.viewholders;

import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.formapplication.databinding.SwitchableFormItemBinding;
import com.abdelrahman.formapplication.forms.FormBinder;
import com.abdelrahman.formapplication.forms.FormItem;
import com.abdelrahman.formapplication.forms.switchitem.SwitchFormItem;

public class SwitchableViewHolder extends RecyclerView.ViewHolder implements FormBinder, CompoundButton.OnCheckedChangeListener {
    private final SwitchableFormItemBinding binding;
    private final SwitchFormItem item;

    public SwitchableViewHolder(@NonNull View itemView, FormItem item) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
        this.item = (SwitchFormItem) item;
    }

    @Override
    public void bind() {
        if (item.getTitle() != null)
            binding.switchTitle.setText(item.getTitle());
        else
            binding.switchTitle.setVisibility(View.GONE);

        binding.switchable.setChecked((boolean) item.getValue());
        binding.switchable.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        item.setValue(isChecked);
        if(item.getValueChangeObserver() != null){
            item.getValueChangeObserver().onValueChange(item,isChecked);
        }
    }
}
