package com.quanao.hanghieu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.quanao.hanghieu.R;
import com.quanao.hanghieu.data.CartItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListItemAdapterManager extends BaseAdapter {
    private List<CartItem> listData;
    private LayoutInflater layoutInflater;

    String date;
    private Context context;


    public ListItemAdapterManager(Context aContext, List<CartItem> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ListHorizontalAdapter.ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_h_layout, null);
            holder = new ListHorizontalAdapter.ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.imageView_h);
            holder.textName = (TextView) view.findViewById(R.id.itemTextName_h);
            holder.textPrice = (TextView) view.findViewById(R.id.itemTextPrice_h);
            holder.textQuantity = (TextView) view.findViewById(R.id.itemQuantity_h);

            view.setTag(holder);
        } else {
            holder = (ListHorizontalAdapter.ViewHolder) view.getTag();
        }



        CartItem product = this.listData.get(i);
        holder.textName.setText(product.getName());
        holder.textPrice.setText("$"+product.getPrice());
        holder.textQuantity.setText("quantity: "+product.getQuantity());
        Picasso.get().load(product.getImageView()).into(holder.imageView);




        return view;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textName;
        TextView textPrice;
        TextView textQuantity;


    }
    public void clear() {
        listData.clear();
    }
    public void addAll(ArrayList arrayList){
        listData = arrayList;
    }
}
