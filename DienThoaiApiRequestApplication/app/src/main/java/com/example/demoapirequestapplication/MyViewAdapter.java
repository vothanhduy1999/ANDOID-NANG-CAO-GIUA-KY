package com.example.demoapirequestapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.demoapirequestapplication.model.Model;

import java.util.List;

public class MyViewAdapter extends RecyclerView.Adapter<MyViewAdapter.ViewHolder> {
    List<Model> models;
    int mResource;
    Context mContext;
    public MyViewAdapter(Context context,int resource, List<Model> objects){
        this.mContext = context;
        this.mResource = resource;
        this.models = objects;
    }
    @NonNull
    @Override
    public MyViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(mResource,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewAdapter.ViewHolder viewHolder, int i) {
        final Model model = models.get(i);
        viewHolder.edtID.setText(String.valueOf(model.getId()));
        viewHolder.edtProduct_name.setText(model.getProduct_name());
        viewHolder.edtPrice.setText(String.valueOf(model.getPrice()));
        viewHolder.edtDescription.setText(model.getDescription());
        viewHolder.edtProducer.setText(model.getProducer());
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ChiTietActivity.class);
                intent.putExtra("CTMH", model);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private EditText edtID;
        private EditText edtProduct_name;
        private  EditText edtPrice;
        private EditText edtDescription;
        private EditText edtProducer;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.edtID = itemView.findViewById(R.id.student_edt_id);
            this.edtProduct_name = itemView.findViewById(R.id.student_edt_product_name);
            this.edtPrice = itemView.findViewById(R.id.student_edt_price);
            this.edtDescription = itemView.findViewById(R.id.student_edt_description);
            this.edtProducer = itemView.findViewById(R.id.student_edt_producer);
            this.linearLayout = itemView.findViewById(R.id.detil);
        }
    }
}
