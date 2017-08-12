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

public class FragmentChooseMode extends Fragment implements View.OnClickListener, RadioButton.OnCheckedChangeListener {




    private View myRootView;



    ///private RadioGroup myRG;

    //private RadioButton myRB1;
    //private RadioButton myRB2;
    //private RadioButton myRB3;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        myRootView = inflater.inflate(R.layout.mode_fragment, container, false);


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
