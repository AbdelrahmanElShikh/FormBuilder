package com.abdelrahman.formapplication.numbers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.abdelrahman.formapplication.R;
import com.abdelrahman.formapplication.SharedViewModel;
import com.abdelrahman.formapplication.adapter.NumberAdapter;
import com.abdelrahman.formapplication.databinding.FragmentNumbersBinding;

public class NumbersFragment extends Fragment implements OnNumberClick {
    private SharedViewModel viewModel;
    private Integer selectedNumber;
    private NumberSelectionType SELECTION_TYPE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        selectedNumber = NumbersFragmentArgs.fromBundle(getArguments()).getSelectedNumber();
        SELECTION_TYPE = NumbersFragmentArgs.fromBundle(getArguments()).getSelectedType();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentNumbersBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_numbers, container, false);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rv.setAdapter(new NumberAdapter(this, selectedNumber));
        return binding.getRoot();
    }

    @Override
    public void onNumberClick(int clickedNumber) {
        switch (SELECTION_TYPE) {
            case CURRENCY:
                viewModel.selectCurrency(clickedNumber);
                break;
            case CITY:
                viewModel.selectCity(clickedNumber);
                break;
            case COUNTRY:
                viewModel.selectCountry(clickedNumber);
                break;
        }

        getNavigationController().navigateUp();

    }

    public NavController getNavigationController() {
        return Navigation.findNavController(requireView());
    }
}