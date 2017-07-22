package com.example.kot.noughtsandcrosses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

/**
 * Created by Kot Kot on 22.06.2017.
 */

public class FragmentButtonClear extends Fragment implements View.OnClickListener, RadioButton.OnCheckedChangeListener {

    //interface OnClickedClearButton {
        //void clickedClearButton(Boolean flag);

    //}

    //OnClickedClearButton onClickedClearButtonListener;


/*
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onClickedClearButtonListener = (OnClickedClearButton) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement Listener");
        }
    }
*/




    private View myRootView;

    //private Button myClearScreen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        myRootView = inflater.inflate(R.layout.button_fragment, container, false);
        //myClearScreen = (Button) myRootView.findViewById(R.id.btnClear);

        //myOnClickedClearButton =(OnClickedClearButton)getActivity();

        //myClearScreen.setOnClickListener(v -> {
            //onClickedClearButtonListener.clickedClearButton(true);

        //});

        //return super.onCreateView(inflater, container, savedInstanceState);
        return myRootView;
    }



    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    // @Override
   // public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

   // }


}
