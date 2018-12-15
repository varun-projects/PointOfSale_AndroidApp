package in.blucon.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import in.blucon.app.R;
import in.blucon.app.object.Item;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CustomViewHolder> {

    private Context context_;
    private List<Item> itemList_;
    private LayoutInflater inflater_;

    public CartAdapter(Context context, List<Item> items) {
        context_ = context;
        inflater_ = LayoutInflater.from(context_);
        itemList_ = items;
    }

    @Override
    public CartAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater_.inflate(R.layout.cart_list_content, parent, false);
        return new CartAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
//        holder.itemTitleView.setText(itemList_.get(position).getTitle());
//        int price = itemList_.get(position).getQuantity() * itemList_.get(position).getPrice_();
//        holder.priceView.setText(String.valueOf(price));
//        final int[] quantity = {itemList_.get(position).getQuantity()};
//
//        holder.addButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                quantity[0] += 1;
//                holder.productQty.setText(String.valueOf(quantity[0]));
//            }
//        });
//
//        holder.removeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (quantity[0] >0) {
//                    quantity[0] = quantity[0] - 1;
//                    holder.productQty.setText(String.valueOf(quantity[0]));
//                }
//            }
//        });
    }

    private void delete(int position) {
        itemList_.remove(position);
        notifyItemRemoved(position);
        Toast.makeText(context_, "Item removed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return itemList_ != null ? itemList_.size() : 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final View view;
        private TextView itemTitleView;
        private TextView priceView;
        private Button deleteButton;
        private final ImageView removeButton;
        private final ImageView addButton;
        private final TextView productQty;


        public CustomViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            itemTitleView = (TextView) itemView.findViewById(R.id.item_title);
            priceView =  (TextView) itemView.findViewById(R.id.price);
            deleteButton =  (Button) itemView.findViewById(R.id.deleteButton);
            removeButton = (ImageView) itemView.findViewById(R.id.removeButton);
            addButton = (ImageView) itemView.findViewById(R.id.addButton);
            productQty = (TextView) itemView.findViewById(R.id.product_quantity);
            deleteButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            delete(getAdapterPosition());
        }
    }
}
