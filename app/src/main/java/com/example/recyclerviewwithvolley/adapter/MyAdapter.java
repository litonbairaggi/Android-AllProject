package com.example.recyclerviewwithvolley.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewwithvolley.R;
import com.example.recyclerviewwithvolley.model.DataModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<DataModel> dataModelList;

    public MyAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final DataModel dataModelPosition = dataModelList.get(position);
        holder.headText.setText(dataModelPosition.getHedText());
        holder.detailText.setText(dataModelPosition.getDetailText());

/*        Log.d("url", "loding error"+dataModelPosition.getDetailText());*/
/*        Picasso.get().load(dataModelPosition.getImgUrl()).into(holder.imageView);
        Picasso.with(this).load("www.journaldev.com").placeholder(R.drawable.placeholder).into(imageView);*/

        Picasso.get().load(dataModelPosition.getHedText()).into(holder.imageView);


        holder.headText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, dataModelPosition.getHedText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView headText, detailText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            headText = itemView.findViewById(R.id.hedarTextViewId);
            imageView = itemView.findViewById(R.id.imageViewId);
            detailText = itemView.findViewById(R.id.detailTextViewId);
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
