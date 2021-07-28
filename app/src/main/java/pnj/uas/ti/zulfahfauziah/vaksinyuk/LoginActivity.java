package pnj.uas.ti.zulfahfauziah.vaksinyuk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    EditText edtEmail,edtPassword;
    Button actionLogin;
    TextView txtRegister;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = getSharedPreferences("profile", MODE_PRIVATE);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        actionLogin = findViewById(R.id.actionLogin);
        txtRegister = findViewById(R.id.txtRegister);

        actionLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtEmail.getText().toString().length() > 0 && edtPassword.getText().toString().length()>0) {
                    //cek login
                    if(edtEmail.getText().toString().equals("zulfahpak@mail.com") && edtPassword.getText().toString().equals("1234")) {
                        //sukses login

                        SharedPreferences.Editor edit = preferences.edit();

                        edit.putString("email", "zulfahpak@mail.com");
                        edit.putString("nama", "Zulfah Fauziah");
                        edit.putBoolean("isLogin", true);
                        edit.commit();

                        Intent intent = new Intent(pnj.uas.ti.zulfahfauziah.vaksinyuk.LoginActivity.this, pnj.uas.ti.zulfahfauziah.vaksinyuk.HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(pnj.uas.ti.zulfahfauziah.vaksinyuk.LoginActivity.this, "Mohon Maaf Email dan Password Salah", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(pnj.uas.ti.zulfahfauziah.vaksinyuk.LoginActivity.this, "Mohon Lengkapi Data", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}