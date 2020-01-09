package com.bw.miaoheng20200109.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.miaoheng20200109.R;
import com.bw.miaoheng20200109.entity.AddressEntity;

import java.util.List;

/**
 * 时间 :2020/1/9  9:14
 * 作者 :苗恒
 * 功能 :
 */
public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.MyViewHolder> {
    Context context;
    List<AddressEntity.ResultBean> list;

    public AddressAdapter(Context context, List<AddressEntity.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(View.inflate(context, R.layout.item, null));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     holder.tv_address.setText(list.get(position).getAddress());
     holder.tv_name.setText(list.get(position).getRealName());
     holder.tv_phone.setText(list.get(position).getPhone()+"");
     holder.tv_zipCode.setText(list.get(position).getZipCode()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv_address;
        private final TextView tv_name;
        private final TextView tv_phone;
        private final TextView tv_zipCode;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_phone = itemView.findViewById(R.id.tv_phone);
            tv_zipCode = itemView.findViewById(R.id.tv_zipCode);
        }
    }
}
