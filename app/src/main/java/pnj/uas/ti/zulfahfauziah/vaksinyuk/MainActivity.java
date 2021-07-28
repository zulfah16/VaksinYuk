package pnj.uas.ti.zulfahfauziah.vaksinyuk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("profile", MODE_PRIVATE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(preferences.getBoolean("isLogin", false)) {
                    Intent intent = new Intent(pnj.uas.ti.zulfahfauziah.vaksinyuk.MainActivity.this, pnj.uas.ti.zulfahfauziah.vaksinyuk.HomeActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(pnj.uas.ti.zulfahfauziah.vaksinyuk.MainActivity.this, pnj.uas.ti.zulfahfauziah.vaksinyuk.LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, 3000);
    }

}


