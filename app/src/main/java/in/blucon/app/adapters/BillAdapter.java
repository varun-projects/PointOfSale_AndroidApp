package in.blucon.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.blucon.app.R;
import in.blucon.app.object.Item;


public class BillAdapter extends RecyclerView.Adapter {


    private Context context_;
    private List<Item> itemList_ = new ArrayList<>();
    private LayoutInflater inflater_;

    public BillAdapter(Context context, List<Item> items) {
        context_ = context;
        inflater_ = LayoutInflater.from(context_);
        itemList_ = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        switch (viewType) {
            case 1: view = inflater_.inflate(R.layout.bill_list_content, parent, false);
                return new CustomViewHolder(view);

            case 2: view = inflater_.inflate(R.layout.bill_total_content, parent, false);
                return new FooterViewHolder(view);

            default:return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof CustomViewHolder) {
            CustomViewHolder viewHolder = (CustomViewHolder) holder;
            viewHolder.itemNameView.setText(itemList_.get(position).getItemName());
        } else {
            FooterViewHolder viewHolder = (FooterViewHolder) holder;

        }

    }




    @Override
    public int getItemViewType(int position) {
        int viewType;
        if (position == itemList_.size()-1){
            viewType = 2;
        } else {
            viewType = 1;
        }
        return viewType;
    }

    @Override
    public int getItemCount() {
        return itemList_ != null ? itemList_.size() : 0;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        private final View view;
        private final TextView itemNameView;
        private final TextView orderIdView;
        private final TextView quantityView;
        private final TextView itemPriceView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            itemNameView = (TextView) itemView.findViewById(R.id.item_name);
            orderIdView = (TextView) itemView.findViewById(R.id.orderId);
            quantityView = (TextView) itemView.findViewById(R.id.quantity);
            itemPriceView = (TextView) itemView.findViewById(R.id.item_price);
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView subTotalView;
        private TextView subTotalTaxView;
        private TextView totalView;

        public FooterViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            subTotalView = (TextView) itemView.findViewById(R.id.subTotalView);
            subTotalTaxView = (TextView) itemView.findViewById(R.id.subTotalTaxView);
            totalView = (TextView) itemView.findViewById(R.id.totalView);
        }
    }
}
