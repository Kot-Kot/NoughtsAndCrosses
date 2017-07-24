package com.example.kot.noughtsandcrosses.Logic;

/**
 * Created by Kot Kot on 13.06.2017.
 */

public interface PCLogic {
    String LOG_TAG = "MY_LOG";

    String FirstPos = "Center";
    String[] SecondPos = {"TopLeft","TopRight","BottomLeft","BottomRight"};
    String[] ThirdPos = {"TopCenter","CenterLeft","CenterRight","BottomCenter"};

    //String[] myPositions = {"TopLeft","TopCenter","TopRight",
            //"CenterLeft","Center","CenterRight",
           //"BottomLeft","BottomCenter","BottomRight"};


    String[][] myWinningCombinations = {{"TopLeft","TopCenter","TopRight"},
            {"CenterLeft","Center","CenterRight"},
            {"BottomLeft","BottomCenter","BottomRight"},

            {"TopLeft","CenterLeft","BottomLeft"},
            {"TopCenter","Center","BottomCenter"},
            {"TopRight","CenterRight","BottomRight"},

            {"TopLeft","Center","BottomRight"},
            {"TopRight","Center","BottomLeft"}};


    String getMyNowClickedButton();

    void setMyNowClickedButton(String myNowClickedButton);

    Integer myPCsClickedButton(String[] strPos, String[] strPosRival);
    Boolean isPosInArray(String pos, String[] posArray);
    Boolean isSomebodyWin(String[] strPos);
}
