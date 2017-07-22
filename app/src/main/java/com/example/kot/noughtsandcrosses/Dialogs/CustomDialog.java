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

import com.example.kot.noughtsandcrosses.DB_Realm.RealmController;
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
        RealmController myObjForRealmController = new RealmController();
        myObjForRealmController.initializeRealm(myContext);

        LayoutInflater myLI = LayoutInflater.from(myContext);
        View myView = myLI.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder myADB = new AlertDialog.Builder(myContext);
        myADB.setView(myView);

        myEditTextUserName = (EditText) myView.findViewById(R.id.userInputDialog);

        myADB.setCancelable(false);
        myADB.setPositiveButton("Подтвердить", (dialogBox, id) -> {
            myUserName = myEditTextUserName.getText().toString();
            if (myUserName.equals("")){
                Toast myToast = (Toast.makeText(myContext.getApplicationContext(), "Введите Ваше имя!", Toast.LENGTH_SHORT));
                myToast.show();
                //CustomDialog myObjForCustomDialog = new CustomDialog(this,this);
                this.createCustomDialog();

                return;
            }

            Log.d("MYL", "myUserName = " + myUserName);
            Log.d ("MYL", "myObjForRealmController.getAll() = " + myObjForRealmController.getAll());


            myObjForRealmController.setIsCurrentUserAsFalse();
            myObjForRealmController.createNewUser(myUserName, myContext);
            Log.d ("MYL", "myObjForRealmController.getAll() = " + myObjForRealmController.getAll());


        });
        myADB.setNeutralButton("Продолжить предыдущую сессию",(dialogBox, id) -> {
            if (!myObjForRealmController.showLastCurrentUser(myContext)){
                this.createCustomDialog();
            }
            //dialogBox.cancel();
        });


        myADB.setNegativeButton("Закрыть",(dialogBox, id) -> {
            Toast myToast = (Toast.makeText(myContext.getApplicationContext(), "Вы вошли инкогнито! Статистика по игрокам отключена. Работает только общая статистика.", Toast.LENGTH_LONG));
            myToast.show();
            myObjForRealmController.lastCurrentUserIsNotActive();
            dialogBox.cancel();
                });




        AlertDialog myAD = myADB.create();
        myAD.show();


    }
}
