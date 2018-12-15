package in.blucon.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import in.blucon.app.object.ServiceCard;


public class ServiceCardAdapter extends ArrayAdapter<ServiceCard> {

    private static final String TAG = "CardArrayAdapter";
    private List<ServiceCard> cardList = new ArrayList<ServiceCard>();

    static class CardViewHolder {
        TextView line1;
        TextView line2;
    }

    public ServiceCardAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(ServiceCard serviceCard) {
        cardList.add(serviceCard);
        super.add(serviceCard);
    }

    @Override
    public int getCount() {
        return cardList.size();
    }

    @Override
    public ServiceCard getItem(int index) {
        return cardList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CardViewHolder viewHolder;
//        if (row == null) {
//            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            row = inflater.inflate(R.layout.list_item_card, parent, false);
//            viewHolder = new CardViewHolder();
////            viewHolder.line1 = (TextView) row.findViewById(R.id.line1);
////            viewHolder.line2 = (TextView) row.findViewById(R.id.line2);
//            row.setTag(viewHolder);
//        } else {
//            viewHolder = (CardViewHolder) row.getTag();
//        }
//        ServiceCard serviceCard = getItem(position);
//        viewHolder.line1.setText(serviceCard.getIpAddress());
//        viewHolder.line2.setText(String.valueOf(serviceCard.getPort()));
        return row;
    }
}
