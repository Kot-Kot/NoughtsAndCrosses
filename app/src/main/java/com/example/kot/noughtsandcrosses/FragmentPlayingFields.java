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

    /*
    private ImageView myIVTopLeft;
    private ImageView myIVTopCenter;
    private ImageView myIVTopRight;
    private ImageView myIVCenterLeft;
    private ImageView myIVCenter;
    private ImageView myIVCenterRight;
    private ImageView myIVBottomLeft;
    private ImageView myIVBottomCenter;
    private ImageView myIVBottomRight;
*/

    private View myRootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        myRootView = inflater.inflate(R.layout.fields_fragment, container, false);
/*
        myIVTopLeft = (ImageView) myRootView.findViewById(R.id.ivTopLeft);
        myIVTopCenter = (ImageView) myRootView.findViewById(R.id.ivTopCenter);
        myIVTopRight = (ImageView) myRootView.findViewById(R.id.ivTopRight);
        myIVCenterLeft = (ImageView) myRootView.findViewById(R.id.ivCenterLeft);
        myIVCenter = (ImageView) myRootView.findViewById(R.id.ivCenter);
        myIVCenterRight = (ImageView) myRootView.findViewById(R.id.ivCenterRight);
        myIVBottomLeft = (ImageView) myRootView.findViewById(R.id.ivBottomLeft);
        myIVBottomCenter = (ImageView) myRootView.findViewById(R.id.ivBottomCenter);
        myIVBottomRight = (ImageView) myRootView.findViewById(R.id.ivBottomRight);


        myIVTopLeft.setOnClickListener(this);
        myIVTopCenter.setOnClickListener(this);
        myIVTopRight.setOnClickListener(this);
        myIVCenterLeft.setOnClickListener(this);
        myIVCenter.setOnClickListener(this);
        myIVCenterRight.setOnClickListener(this);
        myIVBottomLeft.setOnClickListener(this);
        myIVBottomCenter.setOnClickListener(this);
        myIVBottomRight.setOnClickListener(this);
*/
        //return super.onCreateView(inflater, container, savedInstanceState);
        return myRootView;
    }


    @Override
    public void onClick(View v) {

    }


     /*SaveStatisticsWithSP myObjForSaveStatistics = new SaveOverallStatisticsWithSP(getContext(),getActivity());

        myObjForSaveStatistics.loadSkin();
        Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme1);
        switch (myObjForSaveStatistics.getSkin()){
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
