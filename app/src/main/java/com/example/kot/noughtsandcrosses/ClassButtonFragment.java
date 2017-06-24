package com.example.kot.noughtsandcrosses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Kot Kot on 22.06.2017.
 */

public class ClassButtonFragment extends Fragment implements View.OnClickListener, RadioButton.OnCheckedChangeListener {



    OnClickedClearButton myOnClickedClearButton;

    private View myRootView;

    private Button myClearScreen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        myRootView = (View) inflater.inflate(R.layout.button_fragment, container, false);



        myClearScreen = (Button) myRootView.findViewById(R.id.btnClear);

        myOnClickedClearButton =(OnClickedClearButton)getActivity();

        myClearScreen.setOnClickListener(v -> {
            myOnClickedClearButton.methClearScreen();
            //if (myRB1.isChecked()){
                //myOnClickedClearButton.methPcVsPcIsChecked();
            //};
        });

        //return super.onCreateView(inflater, container, savedInstanceState);
        return myRootView;
    }



    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    public interface OnClickedClearButton {
        public void methClearScreen();
        //public void methPcVsPcIsChecked();
    }

}
