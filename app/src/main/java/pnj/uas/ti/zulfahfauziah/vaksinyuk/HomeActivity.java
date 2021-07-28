package pnj.uas.ti.zulfahfauziah.vaksinyuk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences preferences;
    Button buttonLokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        preferences = getSharedPreferences("profile", MODE_PRIVATE);
        buttonLokasi = findViewById(R.id.buttonLokasi);
        buttonLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });
//        txtNama = findViewById(R.id.txtNama);
//
//        actionInternalStorage = findViewById(R.id.actionInternal);
//        actionEksternalStorage = findViewById(R.id.actionEksternalStorage);

//        txtEmail.setText(preferences.getString("email", ""));
//        txtNama.setText(preferences.getString("nama", ""));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.menu_tambah) {
            Intent tambah = new Intent(pnj.uas.ti.zulfahfauziah.vaksinyuk.HomeActivity.this, VaksinasiMain.class);
            startActivity(tambah);
        }else {
        }

        return super.onOptionsItemSelected(item);
    }

}