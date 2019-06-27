package com.example.textss.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.textss.R;
import com.example.textss.bean.ShopBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LENOVO on 2019/6/27.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ShopBean.DataBean> list;
    private Map<Integer,Boolean> map=new TreeMap<>();


    public ShopAdapter(Context context, ArrayList<ShopBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.lv_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txt.setText(list.get(position).getTitle());
        holder.num.setText(list.get(position).getNum()+"元");
        Glide.with(context).load(list.get(position).getPic())
                .into(holder.img);
        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbCheck.isChecked(position,list.get(position));
                    map.put(position,true);
                }else {
                    cbCheck.noChecked(position,list.get(position));
                    map.remove(position);
                }
            }
        });
        if(map!=null&&map.containsKey(position)){
            holder.cb.setChecked(true);
        }else {
            holder.cb.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        public CheckBox cb;
        private TextView txt;
        private TextView num;
        public ViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            cb=itemView.findViewById(R.id.cb);
            txt=itemView.findViewById(R.id.txt);
            num=itemView.findViewById(R.id.num);
        }
    }

    public CbCheck cbCheck;

    public void setCbCheck(CbCheck cbCheck) {
        this.cbCheck = cbCheck;
    }

    public interface CbCheck{
        void isChecked(int p, ShopBean.DataBean bean);

        void noChecked(int p,ShopBean.DataBean bean);
    }
}
