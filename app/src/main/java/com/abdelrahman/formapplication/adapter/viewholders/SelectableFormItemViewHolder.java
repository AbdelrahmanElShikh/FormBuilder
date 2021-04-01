package com.abdelrahman.formapplication.adapter.viewholders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.formapplication.databinding.SelectableFormItemBinding;
import com.abdelrahman.formapplication.forms.FormBinder;
import com.abdelrahman.formapplication.forms.FormItem;
import com.abdelrahman.formapplication.forms.select.SelectableFormItem;

public class SelectableFormItemViewHolder extends RecyclerView.ViewHolder implements FormBinder, View.OnClickListener {
    private final SelectableFormItemBinding binding;
    private final SelectableFormItem item;

    public SelectableFormItemViewHolder(@NonNull View itemView, FormItem item) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
        this.item = (SelectableFormItem) item;
    }

    @Override
    public void bind() {
        /* Binding Logic */
        binding.selectableItemTitle.setText(item.getTitle());
        if (item.getValue() == null)
            binding.selectableItemValue.setText(item.getHint());
        else
            binding.selectableItemValue.setText(String.valueOf(item.getValue()));
        binding.selectableItemParent.setClickable(item.isSelectable());
        binding.selectableItemParent.setAlpha(item.isSelectable() ? 1 : 0.4f);
        binding.selectableItemParent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (item.getSelectionObserver() != null && item.isSelectable())
            item.getSelectionObserver().onUserSelect(item);
    }
}
