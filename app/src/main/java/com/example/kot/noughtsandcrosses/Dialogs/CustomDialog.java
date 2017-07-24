package com.example.kot.noughtsandcrosses.Dialogs;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kot.noughtsandcrosses.DB_Realm.RealmControllerImpl;
import com.example.kot.noughtsandcrosses.R;

/**
 * Created by Kot Kot on 26.06.2017.
 */

public class CustomDialog extends AppCompatActivity {
    private EditText myEditTextUserName;
    private String myUserName;
    private Context myContext;
    private Activity myActivity;

    public void setMyUserName(String n){
        myUserName = n;
    }

    public String getMyUserName(){
        return myUserName;
    }

    public CustomDialog(Context c, Activity a) {
        myContext = c;
        myActivity = a;
    }

    public void createCustomDialog() {
        RealmControllerImpl myObjForRealmControllerImpl = new RealmControllerImpl();
        myObjForRealmControllerImpl.initializeRealm(myContext);

        LayoutInflater myLI = LayoutInflater.from(myContext);
        View myView = myLI.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder myADB = new AlertDialog.Builder(myContext);
        myADB.setView(myView);

        myEditTextUserName = (EditText) myView.findViewById(R.id.userInputDialog);

        myADB.setCancelable(false);
        myADB.setPositiveButton(myContext.getResources().getString(R.string.custom_dialog_pb_name), (dialogBox, id) -> {
            myUserName = myEditTextUserName.getText().toString();
            if (myUserName.equals("")){
                Toast myToast = (Toast.makeText(myContext.getApplicationContext(), myContext.getResources().getString(R.string.custom_dialog_pb_empty_name), Toast.LENGTH_SHORT));
                myToast.show();
                //CustomDialog myObjForCustomDialog = new CustomDialog(this,this);
                this.createCustomDialog();

                return;
            }

            Log.d("MYL", "myUserName = " + myUserName);
            Log.d("MYL", "myObjForRealmControllerImpl.getAll() = " + myObjForRealmControllerImpl.getAll());


            myObjForRealmControllerImpl.setIsCurrentUserAsFalse();
            myObjForRealmControllerImpl.createNewUser(myUserName, myContext);
            Log.d("MYL", "myObjForRealmControllerImpl.getAll() = " + myObjForRealmControllerImpl.getAll());


        });
        myADB.setNeutralButton(myContext.getResources().getString(R.string.custom_dialog_neutb_name), (dialogBox, id) -> {
            if (!myObjForRealmControllerImpl.showLastCurrentUser(myContext)) {
                this.createCustomDialog();
            }
            //dialogBox.cancel();
        });


        myADB.setNegativeButton(myContext.getResources().getString(R.string.custom_dialog_negb_name), (dialogBox, id) -> {
            Toast myToast = (Toast.makeText(myContext.getApplicationContext(), myContext.getResources().getString(R.string.custom_dialog_negb_close), Toast.LENGTH_LONG));
            myToast.show();
            myObjForRealmControllerImpl.lastCurrentUserIsNotActive();
            dialogBox.cancel();
                });




        AlertDialog myAD = myADB.create();
        myAD.show();


    }
}
