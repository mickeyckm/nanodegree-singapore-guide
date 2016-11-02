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
import ng.cheo.android.singaporeguide.models.SubCategory;

/**
 * Created by mickey on 31/10/16.
 */

public class SubCategoryAdapter extends ArrayAdapter<SubCategory> {

    static class ViewHolder {
        ImageView imageView;
        TextView nameTextView;
    }

    public SubCategoryAdapter(Activity context, ArrayList<SubCategory> subCategories) {
        super(context, 0, subCategories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.subcategory_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SubCategory subCategory = getItem(position);

        if (subCategory.hasImage()) {
            viewHolder.imageView.setImageResource(subCategory.getImageResourceId());
            viewHolder.imageView.setVisibility(View.VISIBLE);
        } else {
            viewHolder.imageView.setVisibility(View.GONE);
        }

        viewHolder.nameTextView.setText(subCategory.getName());

        return convertView;
    }
}
