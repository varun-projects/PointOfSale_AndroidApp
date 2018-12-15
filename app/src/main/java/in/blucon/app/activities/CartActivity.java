package in.blucon.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import in.blucon.app.R;
import in.blucon.app.adapters.CartAdapter;
import in.blucon.app.object.Item;

public class CartActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private Button placeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        placeOrderButton = (Button) findViewById(R.id.placeOrderButton);
        recyclerView = (RecyclerView) findViewById(R.id.cartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CartAdapter(this, getCartData()));
        placeOrderButton.setOnClickListener(this);
    }

    private List<Item> getCartData() {

        return null;
    }


    @Override
    protected String getActionBarTitle() {
        return null;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, BillActivity.class));
    }
}
