package com.a_team.studentlife.Shop.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a_team.studentlife.R;
import com.squareup.picasso.Picasso;
import com.a_team.studentlife.Shop.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter {
    List<Product> mProducts;
    Context mContext;
    public static final int LOADING_ITEM = 0;
    public static final int PRODUCT_ITEM = 1;
    int LoadingItemPos;
    public boolean loading = false;

    public ProductsAdapter(Context mContext) {
        mProducts = new ArrayList<>();
        this.mContext = mContext;
    }

    public void addProducts(List<Product> products) {
        int lastPos = mProducts.size();
        this.mProducts.addAll(products);
        notifyItemRangeInserted(lastPos, mProducts.size());
    }

    @Override
    public int getItemViewType(int position) {
        Product currentProduct = mProducts.get(position);
        if (currentProduct.isLoading()) {
            return LOADING_ITEM;
        } else {
            return PRODUCT_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == LOADING_ITEM) {
            View row = inflater.inflate(R.layout.custom_row_loading, parent, false);
            return new LoadingHolder(row);
        } else if (viewType == PRODUCT_ITEM) {
            View row = inflater.inflate(R.layout.custom_row_product, parent, false);
            return new ProductHolder(row);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Product currentProduct = mProducts.get(position);
        if (holder instanceof ProductHolder) {
            final ProductHolder productHolder = (ProductHolder) holder;
            Picasso.with(mContext).load("http://www.fnordware.com/superpng/pnggrad16rgb.png").into(productHolder.imageViewProductThumb);
            productHolder.textViewProductName.setText(currentProduct.getProductName());
            productHolder.textViewProductPrice.setText(currentProduct.getProductPrice());
            if (currentProduct.isNew())
                productHolder.textViewNew.setVisibility(View.VISIBLE);
            else
                productHolder.textViewNew.setVisibility(View.GONE);
            if (currentProduct.isAdded())
                productHolder.textViewAdded.setVisibility(View.VISIBLE);
            else
                productHolder.textViewAdded.setVisibility(View.GONE);
            productHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Selected " + currentProduct.getProductName(), Toast.LENGTH_SHORT).show();
                    if (currentProduct.isAdded())
                        Toast.makeText(mContext, "Selected " + currentProduct.getProductName() + " was added", Toast.LENGTH_SHORT).show();
                    else {
                        productHolder.textViewAdded.setVisibility(View.VISIBLE);
                        currentProduct.setAdded(true);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    private class ProductHolder extends RecyclerView.ViewHolder {
        ImageView imageViewProductThumb;
        TextView textViewProductName, textViewProductPrice, textViewNew, textViewAdded;

        public ProductHolder(View itemView) {
            super(itemView);
            imageViewProductThumb = itemView.findViewById(R.id.imageViewProductThumb);
            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            textViewProductPrice = itemView.findViewById(R.id.textViewProductPrice);
            textViewNew = itemView.findViewById(R.id.textViewNew);
            textViewAdded = itemView.findViewById(R.id.textViewAdded);
        }
    }

    private class LoadingHolder extends RecyclerView.ViewHolder {
        public LoadingHolder(View itemView) {
            super(itemView);
        }
    }

    public void showLoading() {
        Product product = new Product();
        product.setLoading(true);
        mProducts.add(product);
        LoadingItemPos = mProducts.size();
        notifyItemInserted(mProducts.size());
        loading = true;
    }

    public void hideLoading() {
        if (LoadingItemPos <= mProducts.size()) {
            mProducts.remove(LoadingItemPos - 1);
            notifyItemRemoved(LoadingItemPos);
            loading = false;
        }
    }
}