package ng.cheo.android.singaporeguide.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ng.cheo.android.singaporeguide.models.Item;
import ng.cheo.android.singaporeguide.R;
import ng.cheo.android.singaporeguide.models.SubCategory;
import ng.cheo.android.singaporeguide.SubCategoryActivity;
import ng.cheo.android.singaporeguide.adapters.SubCategoryAdapter;

/**
 * Created by mickey on 31/10/16.
 */

public class FestivalsEventsFragment extends Fragment {

    private ArrayList<Item> janToMarEvents;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        janToMarEvents = new ArrayList<Item>();

        Item christmaswonderland = new Item(getString(R.string.events_christmas_wonderland_name), getString(R.string.events_christmas_wonderland_desc), R.raw.christmaswonderland);
        christmaswonderland.setAddress(getString(R.string.events_christmas_wonderland_address));
        christmaswonderland.setTime(getString(R.string.events_christmas_wonderland_time));
        janToMarEvents.add(christmaswonderland);

        Item pongal = new Item(getString(R.string.events_pongal_name), getString(R.string.events_pongal_desc), R.raw.pongal);
        pongal.setTime(getString(R.string.events_pongal_time));
        janToMarEvents.add(pongal);

        Item riverhongbao = new Item(getString(R.string.events_river_hongbao_name), getString(R.string.events_river_hongbao_desc), R.raw.riverhongbao);
        riverhongbao.setAddress(getString(R.string.events_river_hongbao_address));
        riverhongbao.setTime(getString(R.string.events_river_hongbao_time));
        janToMarEvents.add(riverhongbao);

        final ArrayList<SubCategory> subCategories = new ArrayList<SubCategory>();
        subCategories.add(new SubCategory(getString(R.string.category_festivals_events_jantomar), janToMarEvents, R.drawable.calendar));
        subCategories.add(new SubCategory(getString(R.string.category_festivals_events_aprtojun), R.drawable.calendar));
        subCategories.add(new SubCategory(getString(R.string.category_festivals_events_jultosep), R.drawable.calendar));
        subCategories.add(new SubCategory(getString(R.string.category_festivals_events_octtodec), R.drawable.calendar));

        SubCategoryAdapter adapter = new SubCategoryAdapter(getActivity(), subCategories);

        ListView listView = (ListView) rootView.findViewById(R.id.category_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SubCategory subCategory = subCategories.get(position);
                if (subCategory.hasItems()) {
                    Intent subCategoryIntent = new Intent(getActivity(), SubCategoryActivity.class);
                    subCategoryIntent.putExtra(getString(R.string.extra_title), subCategory.getName());
                    subCategoryIntent.putExtra(getString(R.string.extra_items), subCategory.getItems());
                    startActivity(subCategoryIntent);
                }
                else {
                    CharSequence text = getString(R.string.workinprogress);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getActivity(), text, duration);
                    toast.show();
                }
            }
        });

        return listView;
    }
}
