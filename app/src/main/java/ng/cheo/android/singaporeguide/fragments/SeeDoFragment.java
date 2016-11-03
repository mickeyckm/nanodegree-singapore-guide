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

public class SeeDoFragment extends Fragment {

    private ArrayList<Item> neighbourhoodsItems;
    private ArrayList<Item> artsItems;
    private ArrayList<Item> historicalItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        // Load data
        loadContents();

        final ArrayList<SubCategory> subCategories = new ArrayList<SubCategory>();
        subCategories.add(new SubCategory(getString(R.string.category_see_do_neighbourhood), neighbourhoodsItems, R.drawable.neighbourhood));
        subCategories.add(new SubCategory(getString(R.string.category_see_do_arts), artsItems, R.drawable.arts));
        subCategories.add(new SubCategory(getString(R.string.category_see_do_history), historicalItems, R.drawable.history));
        subCategories.add(new SubCategory(getString(R.string.category_see_do_architecture), R.drawable.architecture));
        subCategories.add(new SubCategory(getString(R.string.category_see_do_culture), R.drawable.culture));
        subCategories.add(new SubCategory(getString(R.string.category_see_do_recreation), R.drawable.recreation));
        subCategories.add(new SubCategory(getString(R.string.category_see_do_nature), R.drawable.wildlife));

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

    private void loadContents() {

        // Neighbourhoods data

        neighbourhoodsItems = new ArrayList<Item>();

        Item littleindia = new Item(getString(R.string.neighbourhood_littleindia_name), getString(R.string.neighbourhood_littleindia_desc), R.raw.littleindia);
        littleindia.setAddress(getString(R.string.neighbourhood_littleindia_address));
        neighbourhoodsItems.add(littleindia);

        Item chinatown = new Item(getString(R.string.neighbourhood_chinatown_name), getString(R.string.neighbourhood_chinatown_desc), R.raw.chinatown);
        chinatown.setAddress(getString(R.string.neighbourhood_chinatown_address));
        neighbourhoodsItems.add(chinatown);

        Item marinabay = new Item(getString(R.string.neighbourhood_marinabay_name), getString(R.string.neighbourhood_marinabay_desc), R.raw.marinabay);
        marinabay.setAddress(getString(R.string.neighbourhood_marinabay_address));
        neighbourhoodsItems.add(marinabay);

        Item kampongglam = new Item(getString(R.string.neighbourhood_kampongglam_name), getString(R.string.neighbourhood_kampongglam_desc), R.raw.kampongglam);
        kampongglam.setAddress(getString(R.string.neighbourhood_kampongglam_address));
        neighbourhoodsItems.add(kampongglam);

        // Arts data

        artsItems = new ArrayList<Item>();

        Item esplanade = new Item(getString(R.string.arts_esplanade_name), getString(R.string.arts_esplanade_desc), R.raw.esplanade);
        esplanade.setAddress(getString(R.string.arts_esplanade_address));
        esplanade.setOpeningHours(getString(R.string.arts_esplanade_opening_hours));
        artsItems.add(esplanade);

        Item gillman = new Item(getString(R.string.arts_gillman_name), getString(R.string.arts_gillman_desc), R.raw.gillman);
        gillman.setAddress(getString(R.string.arts_gillman_address));
        gillman.setOpeningHours(getString(R.string.arts_gillman_opening_hours));
        artsItems.add(gillman);

        Item reddot = new Item(getString(R.string.arts_reddot_name), getString(R.string.arts_reddot_desc), R.raw.reddot);
        reddot.setAddress(getString(R.string.arts_reddot_address));
        reddot.setOpeningHours(getString(R.string.arts_reddot_opening_hours));
        artsItems.add(reddot);

        // History data

        historicalItems = new ArrayList<Item>();

        Item asianCiv = new Item(getString(R.string.history_asian_name), getString(R.string.history_asian_desc), R.raw.asianciv);
        asianCiv.setAddress(getString(R.string.history_asian_address));
        asianCiv.setOpeningHours(getString(R.string.history_asian_opening_hours));
        historicalItems.add(asianCiv);

        Item nationalMuseum = new Item(getString(R.string.history_national_name), getString(R.string.history_national_desc), R.raw.nationalmuseum);
        nationalMuseum.setAddress(getString(R.string.history_national_address));
        nationalMuseum.setOpeningHours(getString(R.string.history_national_opening_hours));
        historicalItems.add(nationalMuseum);

        Item civWar = new Item(getString(R.string.history_civilianwar_name), getString(R.string.history_civilianwar_desc), R.raw.civwar);
        civWar.setAddress(getString(R.string.history_civilianwar_address));
        civWar.setOpeningHours(getString(R.string.history_civilianwar_opening_hours));
        historicalItems.add(civWar);
    }
}
