package com.example.kot.noughtsandcrosses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kot Kot on 22.06.2017.
 */

public class FragmentPlayingFields extends Fragment implements View.OnClickListener {


    private View myRootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        myRootView = inflater.inflate(R.layout.fields_fragment, container, false);

        return myRootView;
    }


    @Override
    public void onClick(View v) {

    }


     /*SaveGeneralStatisticsWithSP myObjForSaveGeneralStatistics = new SaveGeneralStatisticsWithSPImpl(getContext(),getActivity());

        myObjForSaveGeneralStatistics.loadSkin();
        Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme1);
        switch (myObjForSaveGeneralStatistics.getSkin()){
            case 1:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme1);
                break;
            case 2:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme2);
                break;
            case 3:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme3);
                break;
        }
        // create ContextThemeWrapper from the original Activity Context with the custom theme
        //final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme1);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
*/


}
