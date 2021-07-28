package pnj.uas.ti.zulfahfauziah.vaksinyuk;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VaksinasiMain extends AppCompatActivity {
    FloatingActionButton addButton;
    RecyclerAdapter recyclerAdapter;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<PesertaVaksinasi> listPeserta;
    RecyclerView rv_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaksinasi_main);
        addButton = findViewById(R.id.addButton);
        rv_view = findViewById(R.id.rv_view);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        rv_view.setLayoutManager(mLayout);
        rv_view.setItemAnimator(new DefaultItemAnimator());

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogForm dialogForm = new DialogForm("","","","","","Tambah");
                dialogForm.show(getSupportFragmentManager(), "form");
            }
        });
        showData();

    }
    private void showData(){
        database.child("Data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listPeserta = new ArrayList<>();
                for (DataSnapshot item : snapshot.getChildren()){
                    PesertaVaksinasi pv = item.getValue(PesertaVaksinasi.class);
                    pv.setKey(item.getKey());
                    listPeserta.add(pv);
                }
                recyclerAdapter = new RecyclerAdapter(listPeserta, VaksinasiMain.this);
                rv_view.setAdapter(recyclerAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

