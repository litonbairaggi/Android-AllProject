package com.example.recyclerviewwithvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerviewwithvolley.adapter.MyAdapter;
import com.example.recyclerviewwithvolley.model.DataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private String url ="https://www.json-generator.com/api/json/get/ckKCKbPIde?indent=2";
    private MyAdapter adapter;
    private List<DataModel> dataModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRecyclerViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataModelList = new ArrayList<>();
        loadData();
    }

    private void loadData() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("myData");
                    for (int i=0; i<array.length(); i++){
                        JSONObject receive = array.getJSONObject(i);

                        // here dataModel as a Constructor
                        DataModel dataItem = new  DataModel(

                                receive.getString("hedText"),
                                receive.getString("detailText"),
                                receive.getString("imgUrl")

                        );
                        dataModelList.add(dataItem);
                    }
                    // here RecyclerView with add Adapter
                    adapter = new MyAdapter(getApplicationContext(), dataModelList);
                    recyclerView.setAdapter(adapter);

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Server Error !", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}