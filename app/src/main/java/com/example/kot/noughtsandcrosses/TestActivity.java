package com.example.kot.noughtsandcrosses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        myClass myObj1 = new myClass();
        myClass myObj2 = new myClass(1);
        myClass myObj3 = new myClass('A');
        myClass myObj4 = new myClass("SomeText1");
        myClass myObj5 = new myClass(2,'B',"3 arguments");

        //myClass myObj2 = new myClass(2,'B',"SomeText2");

        //myObj1.mySet(1,'A',"SomeText1");
        //myObj2.mySet(2,'B',"SomeText2");

        //myObj1.myShowTags();
        //myObj2.myShowTags();

        //myObj.myInt = 5;
        //myObj.myChar = 'A';
        //myObj.myString = "SomeText";

        //Log.d ("MYL", "myObj = "+ myObj);
        //Log.d ("MYL", "myObj.myInt = "+ myObj.myInt);
        //Log.d ("MYL", "myObj.myChar = "+ myObj.myChar);
        //Log.d ("MYL", "myObj.myString = "+ myObj.myString);

        //--------------------------------------------------------
        myClass2 objA = new myClass2();
        myClass2 objB = new myClass2("Second object!");

        objA.myShowText("objA");
        objB.myShowText("objB");

        objA=objB;
        objA.myShowText("objA");
        objB.myString = "objB has been changed";
        objA.myShowText("objA");
    }

    class myClass {
        int myInt;
        char myChar;
        String myString;

        myClass(){
            mySet();
            myShowTags();
        }

        myClass(int n){
            mySet(n);
            myShowTags();
        }

        myClass(char c){
            mySet(c);
            myShowTags();
        }

        myClass(String s){
            mySet(s);
            myShowTags();
        }

        myClass(int n, char c, String s){
            mySet(n,c,s);
            myShowTags();
        }



        void mySet (){
            myInt = 1;
            myChar = 'A';
            myString = "SomeString1";
        }

        void mySet (int nn){
            myInt = nn;
            myChar = 'A';
            myString = "SomeString1";
        }

        void mySet (char cc){
            myInt = 1;
            myChar = cc;
            myString = "SomeString1";
        }

        void mySet (String ss){
            myInt = 1;
            myChar = 'A';
            myString = ss;
        }


        void mySet (int nn, char cc, String ss){
            myInt = nn;
            myChar = cc;
            myString = ss;
        }



        void myShowTags(){


            //Log.d ("MYL", "myObj = "+ s);
            Log.d ("MYL", "myObj.myInt = "+ myInt);
            Log.d ("MYL", "myObj.myChar = "+ myChar);
            Log.d ("MYL", "myObj.myString = "+ myString);
        }
    }

    class myClass2{
        String myString;
        myClass2(){
            myString = "new object";
        }

        myClass2(String s){
            myString = s;
        }

        void myShowText(String s){
            Log.d("MYL", "myString from myClass2, from "+ s +" = " + myString);
        }
    }
}
