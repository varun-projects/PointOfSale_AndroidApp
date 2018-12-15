package in.blucon.app.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.blucon.app.R;
import in.blucon.app.adapters.BillAdapter;
import in.blucon.app.object.Item;

public class BillActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        recyclerView = (RecyclerView) findViewById(R.id.billRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BillAdapter(this, getBillData()));

    }

    private List<Item> getBillData() {

        return null;
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }
}
