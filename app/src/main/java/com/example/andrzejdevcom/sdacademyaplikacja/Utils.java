package com.example.andrzejdevcom.sdacademyaplikacja;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Katarzyna on 2017-05-27.
 */

public class Utils {

    //sprawdzamy czy email uzytkownika zawiera znak @
    public static boolean isEmailVavlid(String email) {
        return email.contains("@");
    }
    //sprawdzamy czy uzytkownik przy hasle podał ponad 6 znaków
    public static boolean isPasswordValid(String password) {
        return password.length() > 6;
    }

    //sprawdzanie czy posiadamy dostep do internetu
    static boolean checkInternetConnection(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
