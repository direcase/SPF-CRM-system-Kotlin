package com.example.spf_crm_system.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spf_crm_system.R;
import com.example.spf_crm_system.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.inflater = LayoutInflater.from(context);
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.products, parent, false);
        return new ProductAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product=products.get(position);
        holder.product_name.setText(product.getProduct_name());
        holder.price.setText(" "+product.getPrice()+"тг");
        holder.description.setText(product.getDescription());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView product_name, price,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name=(TextView) itemView.findViewById(R.id.product_name);
            price=(TextView) itemView.findViewById(R.id.price);
            description=(TextView) itemView.findViewById(R.id.description);
        }
    }
}
