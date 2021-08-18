package com.example.navigationcomponentcodeinger;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


public class SpecifyAmountFragment extends Fragment {

    View view;
    Button Send,Cancel;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_specify_amount, container, false);

        editText = view.findViewById(R.id.editText);

        //to get name from receipient fragment
        SpecifyAmountFragmentArgs.fromBundle(getArguments()).getName();

               // Log.i("dshcjhd", "onCreateView: "+SpecifyAmountFragmentArgs.fromBundle(getArguments()).getName());

        Send = view.findViewById(R.id.send);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Navigation.findNavController(view).navigate(R.id.action_specifyAmountFragment_to_confirmationFragment);

                NavDirections directions = SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(
                        SpecifyAmountFragmentArgs.fromBundle(getArguments()).getName()
                        ,Integer.parseInt(editText.getText().toString()));
                Navigation.findNavController(view).navigate(directions);
            }
        });

        Cancel = view.findViewById(R.id.cancel);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });

        return view;
    }

    
}
