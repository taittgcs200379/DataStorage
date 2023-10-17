package com.example.stotedata_cw2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private ArrayList<DetailModel> List;
    private DatabaseHelper databaseHelper;
    public Adapter(Context context, ArrayList<DetailModel> List){
        this.context=context;
        this.List=List;
        databaseHelper= new DatabaseHelper(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.detail_item,parent,false);
        ViewHolder vh= new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetailModel detailModel= List.get(position);
        String id= detailModel.getId();
        String name=detailModel.getName();
        String dob=detailModel.getDob();
        String email=detailModel.getEmail();

        holder.Name.setText(name);
        holder.Dob.setText(dob);
        holder.Email.setText(email);

    }

    @Override
    public int getItemCount() {
       return List.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView Name, Dob, Email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.Name);
            Dob=itemView.findViewById(R.id.Dob);
            Email=itemView.findViewById(R.id.Email);


        }
    }
}
