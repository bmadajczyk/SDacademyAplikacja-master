package com.example.andrzejdevcom.sdacademyaplikacja.presenters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Katarzyna on 2017-05-27.
 */

public class RegisterPresenter {

    //firebaseAuth
    private FirebaseAuth firebaseAuth;

    //construktor bezargumentowy RegisterPresenter
    public RegisterPresenter() {
    }

    public void registerUser(final Activity activity, String email, String password) {
    //inicjalizacja firebase
        firebaseAuth = FirebaseAuth.getInstance();

        //tworzenie konta za pomoca firebase
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(activity,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //tutaj logika odpowiedzialna za to co sie stanie gdy konto uda sie tworzyc
                            //stworzymy sobie intent do nastepnej aktywnosci odpowiedzialnej za ekran z gra
                            Toast.makeText(activity, "Account created", Toast.LENGTH_SHORT).show();

                        } else {
                            //tutaj problematyczne niestworzenie konta w firebase
                            //wyswietlamy jednynie informacje, ze coś poszło nie tak
                            Toast.makeText(activity, "Something went wrong... try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
