package com.example.welcomescreen;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {


    Context context;
    String saveName;
    SharedPreferences sharedPreferences;


    public PreferenceManager(Context context , String saveName) {
        this.context = context;
        this.saveName = saveName;
        sharedPreferences = context.getSharedPreferences(saveName,context.MODE_PRIVATE);

    }


public void setFirstTimeLaunch(int key){
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt("key",key);
    editor.apply();
}

public int isfirstTimeChecl(){
        return sharedPreferences.getInt("key",0);
}

}
