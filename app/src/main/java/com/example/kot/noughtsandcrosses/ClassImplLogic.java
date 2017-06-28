package com.example.kot.noughtsandcrosses;

import android.content.Context;
import android.util.Log;

import java.util.Arrays;






/**
 * Created by Kot Kot on 13.06.2017.
 */

//отвечает за логику хода ПК
public class ClassImplLogic implements IntfLogic {
    private String myNowClickedButton = "";
    private Context myContext;

    public String getMyNowClickedButton() {
        return myNowClickedButton;
    }

    public void setMyNowClickedButton(String myNowClickedButton) {
        this.myNowClickedButton = myNowClickedButton;
    }

    ClassImplLogic(Context c){
        myContext = c;
    }


    @Override
    public Integer myPCsClickedButton(String[] strPos, String[] strPosRival) {
        Integer btnId = 0;
        String tempStr = FirstPos;

        int number;

        for (int i=0; i < myWinningCombinations.length; i++){

            number = 0;
            int[] pos = {0,0,0};
            for(int j = 0; j < 3; j++){
                for (int k = 0; k < 5; k++){
                    if(myWinningCombinations[i][j].equalsIgnoreCase(strPos[k])){
                        number++;
                        pos[j] = 1;
                        if (number == 2){
                            for(int p = 0; p < pos.length; p++){
                                if (pos[p]==0 & !isPosInArray(myWinningCombinations[i][p], strPosRival)){
                                    tempStr = myWinningCombinations[i][p];
                                    myNowClickedButton = tempStr;
                                    btnId = myContext.getResources().getIdentifier("iv"+tempStr,"id", myContext.getPackageName());
                                    return  btnId;
                                    //return  tempStr;

                                }

                            }

                        }
                    }
                }

            }


        }


        for (int i=0; i < myWinningCombinations.length; i++){

            number = 0;
            int[] pos = {0,0,0};
            for(int j = 0; j < 3; j++){
                for (int k = 0; k < 5; k++){
                    if(myWinningCombinations[i][j].equalsIgnoreCase(strPosRival[k])){
                        //Log.d(LOG_TAG, "myWinningCombinations[i][j] =" + myWinningCombinations[i][j]);
                        //Log.d(LOG_TAG, "rivalPositions[k] =" + rivalPositions[k]);
                        //Log.d(LOG_TAG, "---                   ---");
                        number++;
                        pos[j] = 1;
                        if (number == 2){
                            //Log.d(LOG_TAG, "i = " + i);
                            //Log.d(LOG_TAG, "pos[] = " + Arrays.toString(pos));
                            for(int p = 0; p < pos.length; p++){
                                if (pos[p]==0 & !isPosInArray(myWinningCombinations[i][p], strPos)){
                                    tempStr = myWinningCombinations[i][p];
                                    myNowClickedButton = tempStr;
                                    btnId = myContext.getResources().getIdentifier("iv"+tempStr,"id", myContext.getPackageName());
                                    return  btnId;
                                    //return  tempStr;

                                }

                            }

                        }
                    }
                }

            }


        }






        for (int i = 0; i < strPos.length; i++){
            if (tempStr.equalsIgnoreCase(strPos[i]) || tempStr.equalsIgnoreCase(strPosRival[i])){
                //Log.d(LOG_TAG, "tempStr.equalsIgnoreCase(strPos[i]) || tempStr.equalsIgnoreCase(strPosRival[i]) , i = " +i);
                break;
            }else if(i==4){
                myNowClickedButton = tempStr;
                btnId = myContext.getResources().getIdentifier("iv"+tempStr,"id", myContext.getPackageName());
                return  btnId;
                //return  tempStr;
            }
        }

        String[] tempSecondPos = new String[SecondPos.length];
        for (int k = 0; k < SecondPos.length; k++){
            for (int i = 0; i < strPos.length; i++){
                if (SecondPos[k].equalsIgnoreCase(strPos[i]) || SecondPos[k].equalsIgnoreCase(strPosRival[i])){
                    break;
                }else if (i==4){
                    tempSecondPos[k] = SecondPos[k];
                }
            }
        }
        Log.d(LOG_TAG, " tempSecondPos[] = " + Arrays.toString(tempSecondPos));
        for (String s : tempSecondPos){
            if(s != null){
                Log.d(LOG_TAG, " tempSecondPos[] = " + Arrays.toString(tempSecondPos));
                do{
                    tempStr = tempSecondPos[(int)(Math.random()*tempSecondPos.length)];
                }while (tempStr == null);
                myNowClickedButton = tempStr;
                btnId = myContext.getResources().getIdentifier("iv"+tempStr,"id", myContext.getPackageName());
                return  btnId;
                //return tempStr;
            }

        }

        String[] tempThirdPos = new String[ThirdPos.length];
        for (int k = 0; k < ThirdPos.length; k++){
            for (int i = 0; i < strPos.length; i++){
                if (ThirdPos[k].equalsIgnoreCase(strPos[i]) || ThirdPos[k].equalsIgnoreCase(strPosRival[i])){
                    break;
                }else if (i==4){
                    tempThirdPos[k] = ThirdPos[k];
                }
            }
        }
        Log.d(LOG_TAG, " tempThirdPos[] = " + Arrays.toString(tempThirdPos));
        for (String s : tempThirdPos){
            if(s != null){
                Log.d(LOG_TAG, " tempThirdPos[] = " + Arrays.toString(tempThirdPos));
                do{
                    tempStr = tempThirdPos[(int)(Math.random()*tempThirdPos.length)];
                }while (tempStr == null);
                myNowClickedButton = tempStr;
                btnId = myContext.getResources().getIdentifier("iv"+tempStr,"id", myContext.getPackageName());
                return  btnId;
                //return tempStr;
            }

        }

        myNowClickedButton = tempStr;
        Log.d(LOG_TAG, " btnId = " + btnId);
        return btnId;
        //return tempStr;


    }

    @Override
    public Boolean isPosInArray(String pos, String[] posArray) {

        for (int i=0; i<posArray.length;i++){
            if (posArray[i].equalsIgnoreCase(pos)){
                return true;
            }
        }
        return false;
    }



    @Override
    public Boolean isSomebodyWin(String[] strPos) {

        int number;

        for (int i=0; i < myWinningCombinations.length; i++){

            number = 0;
            int[] pos = {0,0,0};
            for(int j = 0; j < 3; j++){
                for (int k = 0; k < 5; k++){
                    if(myWinningCombinations[i][j].equalsIgnoreCase(strPos[k])){
                        number++;
                        //pos[j] = 1;
                        if (number == 3){
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

}
