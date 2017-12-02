package com.upn.trabajo3.appjct3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.upn.trabajo3.appjct3.Controlador.LoginController;
import com.upn.trabajo3.appjct3.Entidades.Usuario;


import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements OnClickListener {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    EditText txtUsuario;
    EditText txtPassword;
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */


    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.



        Button btnIniciar = (Button) findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        System.out.println("lineaa  ");
        if(v.getId()==R.id.btnIniciar)
        {  System.out.println("lineaa 444");
            LoginController login=new LoginController();
            Usuario usuario=new Usuario();
            txtPassword=findViewById(R.id.txtusuario);
            txtUsuario=findViewById(R.id.txtpass);

            usuario.setSesion(txtUsuario.getText().toString());
            usuario.setPassword(txtPassword.getText().toString());
            Toast.makeText(this,"Ingresando... "+usuario.getSesion(),Toast.LENGTH_LONG).show();
            login.setDatos(getApplicationContext(),usuario,this);
            login.execute();
        }
    }
}


