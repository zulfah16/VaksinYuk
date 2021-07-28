package pnj.uas.ti.zulfahfauziah.vaksinyuk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
   private List<PesertaVaksinasi> pList;
   private Activity activity;
   DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public RecyclerAdapter(List<PesertaVaksinasi> pList, Activity activity) {
        this.pList = pList;
        this.activity = activity;
    }

    public RecyclerAdapter(List<PesertaVaksinasi>pList){this.pList=pList;}
    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView= inflater.inflate(R.layout.layout_item,parent,false);
    return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PesertaVaksinasi pVaksinasi = pList.get(position);
        holder.nik.setText("NIK :"+pVaksinasi.getNik());
        holder.nama.setText("Nama :"+pVaksinasi.getNama());
        holder.alamat.setText("Alamat :"+pVaksinasi.getAlamat());
        holder.nohp.setText("No HP :"+pVaksinasi.getNohp());
        holder.hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        database.child("Data").child(pVaksinasi.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(activity, "Delete Success", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(activity, "Delete Failed", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setMessage("are you sure you want to delete " + pVaksinasi.getNama()+"?");
                builder.show();

            }
        });

        holder.card_view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FragmentManager manager =((AppCompatActivity)activity).getSupportFragmentManager();
                DialogForm dialogForm = new DialogForm(pVaksinasi.getNik(),pVaksinasi.getNama(),pVaksinasi.getAlamat(),pVaksinasi.getNohp(),pVaksinasi.getKey(),"Ubah");
                dialogForm.show(manager, "form");
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nik;
        TextView nama;
        TextView alamat;
        TextView nohp;
        CardView card_view;
        ImageView hapus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nik = itemView.findViewById(R.id.nik);
            nama = itemView.findViewById(R.id.nama);
            alamat = itemView.findViewById(R.id.alamat);
            nohp = itemView.findViewById(R.id.nohp);
            card_view = itemView.findViewById(R.id.card_view);
            hapus = itemView.findViewById(R.id.hapus);
        }
    }
}
