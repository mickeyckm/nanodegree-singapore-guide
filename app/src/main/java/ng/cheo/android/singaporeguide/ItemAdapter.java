package ng.cheo.android.singaporeguide;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mickey on 31/10/16.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Activity context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_item, parent, false);
        }

        Item item = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (item.hasImage()) {
            imageView.setImageResource(item.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(item.getName());

        TextView descTextView = (TextView) listItemView.findViewById(R.id.desc);
        descTextView.setText(item.getDesc());

        return listItemView;
    }
}
