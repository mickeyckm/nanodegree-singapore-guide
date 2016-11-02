package ng.cheo.android.singaporeguide;

import android.app.Activity;
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

public class SubCategoryAdapter extends ArrayAdapter<SubCategory> {

    public SubCategoryAdapter(Activity context, ArrayList<SubCategory> subCategories) {
        super(context, 0, subCategories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.subcategory_item, parent, false);
        }

        SubCategory subCategory = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (subCategory.hasImage()) {
            imageView.setImageResource(subCategory.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(subCategory.getName());

        return listItemView;
    }
}
