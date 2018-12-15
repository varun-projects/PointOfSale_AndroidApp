package in.blucon.app.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.SocketHandler;

import in.blucon.app.activities.CartActivity;
import in.blucon.app.datasource.ItemDataSource;
import in.blucon.app.object.Item;
import in.blucon.app.R;
import in.blucon.app.adapters.RecyclerViewAdapter;
import in.blucon.app.object.ItemType;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShotsFragment extends Fragment implements View.OnClickListener, RecyclerViewAdapter.ItemSelected {

    private static final String LOG_TAG = ShotsFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private Button checkOutButton;


    public ShotsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_starter, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.starterRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter(getActivity(), getItemList(), this));
        checkOutButton = (Button) view.findViewById(R.id.checkOutButton);
        checkOutButton.setOnClickListener(this);
        return view;
    }

    private List<Item> getItemList() {
        List<Item> itemList = new ArrayList<>();
        itemList = ItemDataSource.getItems();
        return itemList;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(), CartActivity.class));
    }

    @Override
    public void onItemSelected() {
        checkOutButton.setVisibility(View.VISIBLE);
        Toast.makeText(getActivity(), "Item Selected", Toast.LENGTH_SHORT).show();

    }
}
