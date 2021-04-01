package com.abdelrahman.formapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.formapplication.R;
import com.abdelrahman.formapplication.databinding.TextItemBinding;
import com.abdelrahman.formapplication.numbers.OnNumberClick;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {
    private final OnNumberClick listener;
    private final Integer selectedNumber;

    public NumberAdapter(OnNumberClick listener, Integer selectedNumber) {
        this.listener = listener;
        this.selectedNumber = selectedNumber;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_item, parent, false);
        return new NumberViewHolder(view.getRootView(), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder {
        private final TextItemBinding binding;
        private final OnNumberClick listener;

        public NumberViewHolder(@NonNull View itemView, OnNumberClick listener) {
            super(itemView);
            this.binding = DataBindingUtil.bind(itemView);
            this.listener = listener;
        }

        public void bind(int position) {
            binding.text.setText(String.valueOf(position));
            if (selectedNumber != null)
                binding.imgCheck.setVisibility(selectedNumber.equals(position) ? View.VISIBLE : View.GONE);
            binding.textItemParent.setOnClickListener(v -> listener.onNumberClick(position));
        }
    }
}

