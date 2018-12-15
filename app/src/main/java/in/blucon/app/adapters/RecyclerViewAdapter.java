package in.blucon.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.blucon.app.R;
import in.blucon.app.activities.DetailActivity;
import in.blucon.app.object.Item;
import in.blucon.app.object.Order;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private Context context_;
    private ItemSelected itemSelected_;

    private List<Item> itemList_;
    private LayoutInflater inflater_;
    private List<Item> selectedList_ = new ArrayList<>();

    public RecyclerViewAdapter(Context context, List<Item> items, ItemSelected itemSelected) {
        context_ = context;
        inflater_ = LayoutInflater.from(context_);
        itemList_ = items;
        itemSelected_ = itemSelected;
    }


    public interface ItemSelected {
         void onItemSelected();
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater_.inflate(R.layout.item_list_content, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
        final int[] quantity = {0};

        holder.itemName.setText(itemList_.get(position).getItemName());
        if(itemList_.get(position).getDescription() != null) {
            holder.description.setText(itemList_.get(position).getDescription());
        } else {
            holder.description.setText(context_.getResources().getString(R.string.no_description));
        }

        holder.addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                quantity[0] += 1;
                holder.productQty.setText(String.valueOf(quantity[0]));
                itemSelected_.onItemSelected();
            }
        });

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity[0] >0) {
                    quantity[0] = quantity[0] - 1;
                    holder.productQty.setText(String.valueOf(quantity[0]));
                }
            }
        });

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context_, DetailActivity.class);
//                intent.putExtra(TaskDetailActivity.EXTRA_TASK_ID, viewHolder.taskListResponse.getTaskId());
                context_.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList_ != null ? itemList_.size(): 0;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        private final View view;
        private final TextView itemName;
        private final TextView description;
        private final ImageView removeButton;
        private final ImageView addButton;
        private final TextView productQty;

        public CustomViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            itemName = (TextView) itemView.findViewById(R.id.itemName);
            description = (TextView) itemView.findViewById(R.id.description);
            removeButton = (ImageView) itemView.findViewById(R.id.removeButton);
            addButton = (ImageView) itemView.findViewById(R.id.addButton);
            productQty = (TextView) itemView.findViewById(R.id.product_quantity);
        }
    }
}
