package com.example.assignment1_danielgelfand;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {
    private SharedPreferences sharedPreferences;
    public SharedPreferenceHelper(Context context)
    {
        sharedPreferences=context.getSharedPreferences(String.valueOf(R.string.user_name),context.MODE_PRIVATE);

    }
    public void saveProfileName(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(String.valueOf(R.string.user_name),name);
        editor.commit();

    }

    public String getProfileName()
    {
        return sharedPreferences.getString(String.valueOf(R.string.user_name),null);

    }
    public void saveProfileID(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(String.valueOf(R.string.user_id),name);
        editor.commit();

    }

    public String getProfileID()
    {
        return sharedPreferences.getString(String.valueOf(R.string.user_id),null);

    }
    public void saveProfileAge(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(String.valueOf(R.string.user_age),name);
        editor.commit();

    }

    public String getProfileAge()
    {
        return sharedPreferences.getString(String.valueOf(R.string.user_age),null);

    }

}
