package com.example.demoapirequestapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.demoapirequestapplication.model.Model;

import java.util.HashMap;
import java.util.Map;

public class ChiTietActivity extends AppCompatActivity {
    TextView textViewID;
    TextView textViewProduct_name;
    TextView textViewPrice;
    TextView textViewDescription;
    TextView textViewProducer;
    Button btn_Edit;
    Button btn_Update;
    Button btn_Back;
    Map<String,String> mMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        onInit();
        Intent intent = getIntent();
        final Model item = ((Model) intent.getSerializableExtra("CTMH"));
        textViewProduct_name.setText(String.valueOf(item.getId()));
        textViewProduct_name.setText(item.getProduct_name());
        textViewPrice.setText(String.valueOf(item.getPrice()));
        textViewDescription.setText(item.getDescription());
        textViewProducer.setText(item.getProducer());

    }

    private void onInit() {
        textViewID = findViewById(R.id.txt_id);
        textViewProduct_name = findViewById(R.id.txt_product_name);
        textViewPrice = findViewById(R.id.txt_price);
        textViewDescription =findViewById(R.id.txt_description);
        textViewProducer = findViewById(R.id.txt_producer);
    }
    void onEdit(){
        textViewID.setEnabled(true);
        textViewProduct_name.setEnabled(true);
        textViewPrice.setEnabled(true);
        textViewDescription.setEnabled(true);
        textViewProducer.setEnabled(true);
    }

}
