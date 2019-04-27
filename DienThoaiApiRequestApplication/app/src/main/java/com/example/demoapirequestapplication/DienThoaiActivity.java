package com.example.demoapirequestapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.demoapirequestapplication.IHolder.IView;
import com.example.demoapirequestapplication.model.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DienThoaiActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Model> models = new ArrayList<>();
    String userid = LoginAsyncTask.result_id + "";
    Map<String,String> map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dienthoai);
        recyclerView = findViewById(R.id.dienthoai_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        map.put("id",String.valueOf(userid));
        new DienThoaiAsyncTask(new IView() {
           @Override
           public void onRequestSuccess(Bitmap bitmap) {

           }
           @Override
           public void onGetDataSuccess(JSONArray jsonArray) {
                for (int i = 0;i < jsonArray.length(); i++){
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Model model = new Model();
                        model.setId(Integer.parseInt(jsonObject.getString("id")));
                        model.setProduct_name(jsonObject.getString("product_name"));
                        model.setPrice(Integer.valueOf(jsonObject.getString("price")));
                        model.setDescription(jsonObject.getString("description"));
                        model.setProducer(jsonObject.getString("producer"));
                        models.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

           }
       },map).execute(" http://www.vidophp.tk/api/account/getdata");
        MyViewAdapter adapter = new MyViewAdapter(DienThoaiActivity.this,R.layout.dienthoai_item,models);
        recyclerView.setAdapter(adapter);
    }
}
