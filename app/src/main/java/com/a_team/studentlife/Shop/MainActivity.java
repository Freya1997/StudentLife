package com.studentlife.shopstudentlife;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.a_team.studentlife.R;
import com.a_team.studentlife.Shop.adapters.ProductsAdapter;
import com.a_team.studentlife.Shop.helpers.EndlessScrollListener;
import com.a_team.studentlife.Shop.helpers.Space;
import com.a_team.studentlife.Shop.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ProductsAdapter productsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        productsAdapter = new ProductsAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewProducts.setLayoutManager(gridLayoutManager);
        EndlessScrollListener endlessScrollListener = new EndlessScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                if (!productsAdapter.loading)
                    feedData();
            }
        };
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (productsAdapter.getItemViewType(position)) {
                    case ProductsAdapter.PRODUCT_ITEM:
                        return 1;
                    case ProductsAdapter.LOADING_ITEM:
                        return 2;
                    default:
                        return -1;
                }
            }
        });
        recyclerViewProducts.addOnScrollListener(endlessScrollListener);
        recyclerViewProducts.addItemDecoration(new Space(2, 20, true, 0));
        recyclerViewProducts.setAdapter(productsAdapter);
        endlessScrollListener.onLoadMore(0, 0);
    }
    private void feedData() {
        productsAdapter.showLoading();
        final List<Product> products = new ArrayList<>();
        int[] imageUrls = new int[5];
        String[] ProductName = {"Kingsmon Top", "Adidas Top", "Butterfly Top", "White Top","Kek"};
        String[] ProductPrice = {"₹594", "₹5000", "₹200", "₹1999", "₹999"};
        boolean[] isNew = {true, false, false, true,true};
        for (int i = 0; i < imageUrls.length; i++) {
            Product product = new Product(imageUrls[i], ProductName[i], ProductPrice[i], isNew[i]);
            products.add(product);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                productsAdapter.hideLoading();
                productsAdapter.addProducts(products);
            }
        }, 2000);
    }
}