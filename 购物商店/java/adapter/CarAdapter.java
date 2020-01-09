package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.bean.ShopBean;

import java.util.List;


public class CarAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<ShopBean> list;
    public CarAdapter(Context context,List<ShopBean> list){
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
    }
    @Override
    public int getCount(){

        return list == null ? 0 : list.size();
    }
    @Override
    public Object getItem(int position){

        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.car_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        ShopBean  CarInfo = (ShopBean) getItem(position);
        viewHolder.tvShopTitle.setText(CarInfo.getShopTitle());
        viewHolder.tvShopPrice.setText(CarInfo.getShopPrice());
        return convertView;
    }
    class ViewHolder {
        TextView tvShopTitle;
        TextView tvShopPrice;
        public ViewHolder(View view){
            tvShopTitle = (TextView) view.findViewById(R.id.title);
            tvShopPrice = (TextView) view.findViewById(R.id.price);;
        }
    }
}
