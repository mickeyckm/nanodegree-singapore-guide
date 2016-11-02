package ng.cheo.android.singaporeguide.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ng.cheo.android.singaporeguide.R;
import ng.cheo.android.singaporeguide.models.Item;

/**
 * Created by mickey on 31/10/16.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Activity context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    static class ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView descTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.name);
            viewHolder.descTextView = (TextView) convertView.findViewById(R.id.desc);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Item item = getItem(position);

        if (item.hasImage()) {
            viewHolder.imageView.setImageResource(item.getImageResourceId());
            viewHolder.imageView.setVisibility(View.VISIBLE);
        } else {
            viewHolder.imageView.setVisibility(View.GONE);
        }

        viewHolder.nameTextView.setText(item.getName());
        viewHolder.descTextView.setText(item.getDesc());

        return convertView;
    }
}
