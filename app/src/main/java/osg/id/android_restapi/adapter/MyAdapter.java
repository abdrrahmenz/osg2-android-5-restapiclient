package osg.id.android_restapi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

import osg.id.android_restapi.R;
import osg.id.android_restapi.model.MyModel;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<MyModel> listData;
    private final onItemClickListener listener;


    public interface onItemClickListener{
        void onItemClick();
    }

    public MyAdapter(List<MyModel> listData, onItemClickListener listener) {
        this.listData = listData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewRoot = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new MyViewHolder(viewRoot);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
                MyModel myModel = listData.get(i);
                myViewHolder.itemName.setText(myModel.name);
                myViewHolder.itemUsername.setText(myModel.username);
                myViewHolder.itemEmail.setText(myModel.email);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView itemName, itemUsername, itemEmail;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemUsername = (TextView) itemView.findViewById(R.id.item_username);
            itemEmail = (TextView) itemView.findViewById(R.id.item_email);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick();
                }
            });
        }


    }
}
