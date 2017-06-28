package com.example.kot.noughtsandcrosses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Arrays;

/**
 * Created by Kot Kot on 22.06.2017.
 */

public class ClassModeFragment extends Fragment implements View.OnClickListener, RadioButton.OnCheckedChangeListener {


   // interface OnCheckedRadioButtons {
        //void isRadioButtonsChanged(Boolean flag);
        //void whatRadioButtonsChanged(int flag);

    //}


    //OnCheckedRadioButtons onCheckedRadioButtonsListener;

    private View myRootView;



    ///private RadioGroup myRG;

    //private RadioButton myRB1;
    //private RadioButton myRB2;
    //private RadioButton myRB3;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        myRootView = inflater.inflate(R.layout.mode_fragment, container, false);

        //myRG = (RadioGroup) myRootView.findViewById(R.id.rg);
        //myRB1 = (RadioButton) myRootView.findViewById(R.id.rb1);
        //myRB2 = (RadioButton) myRootView.findViewById(R.id.rb2);
        //myRB3 = (RadioButton) myRootView.findViewById(R.id.rb3);
        //onCheckedRadioButtonsListener =(OnCheckedRadioButtons)getActivity();
/*
        myRG.setOnCheckedChangeListener((group, checkedId) -> {
            //myClearScreen();
            onCheckedRadioButtonsListener.isRadioButtonsChanged(true);
            switch (checkedId){
                case R.id.rb1:
                    onCheckedRadioButtonsListener.whatRadioButtonsChanged(1);
                    break;
                case R.id.rb2:
                    onCheckedRadioButtonsListener.whatRadioButtonsChanged(2);
                    break;
                case R.id.rb3:
                    onCheckedRadioButtonsListener.whatRadioButtonsChanged(3);
                    break;
                default:
                    break;

            }
        });
*/

        //return super.onCreateView(inflater, container, savedInstanceState);
        return myRootView;
    }



    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
/*
    public interface OnClickedClearButton {
        //public void methClearScreen();
        public void methPcVsPcIsChecked();
    }


    public int whatRbIsChecked(int id){
        int index = -1;
        switch (id) {
            case R.id.rb1:
                index = 1;
                break;
            case R.id.rb2:
                index = 2;
                break;
            case R.id.rb3:
                index = 3;
                break;
        }
        return index;
    }

    */
}
