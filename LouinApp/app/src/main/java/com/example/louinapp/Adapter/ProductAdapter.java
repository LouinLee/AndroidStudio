package com.example.louinapp.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.louinapp.Model.Product;
import com.example.louinapp.R;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    private ArrayList<Product> productArrayList;

    Context context;

    public ProductAdapter(ArrayList<Product> productArrayList, Context context) {
        super(context, R.layout.item_list, productArrayList);
        this.productArrayList = productArrayList;
        this.context = context;
    }

    private static class MyViewHolder {
        ImageView imageProduct;
        TextView textProductName, textProductPrice;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Product product = getItem(position);

        final View result;
        MyViewHolder myViewHolder;


        if (convertView == null) {

            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list, parent, false);

            myViewHolder.imageProduct = (ImageView) convertView.findViewById(R.id.imageProduct);
            myViewHolder.textProductName = (TextView) convertView.findViewById(R.id.textProductName);
            myViewHolder.textProductPrice = (TextView) convertView.findViewById(R.id.textProductPrice);

            convertView.setTag(myViewHolder);

        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        result = convertView;
        myViewHolder.imageProduct.setImageResource(product.getPicture());
        myViewHolder.textProductName.setText(product.getName());
        myViewHolder.textProductPrice.setText("IDR. "+ product.getPrice());
        return result;
    }
}

