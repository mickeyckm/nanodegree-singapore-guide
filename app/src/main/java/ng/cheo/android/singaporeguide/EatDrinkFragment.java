package ng.cheo.android.singaporeguide;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mickey on 31/10/16.
 */

public class EatDrinkFragment extends Fragment {

    private ArrayList<Item> localItems;
    private ArrayList<Item> diningItems;
    private ArrayList<Item> partyItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        localItems = new ArrayList<Item>();

        Item laksa = new Item(getString(R.string.local_laksa_name), getString(R.string.local_laksa_desc), R.raw.laksa);
        laksa.setRecipe(getString(R.string.local_laksa_recipe));
        localItems.add(laksa);

        Item chillicrab = new Item(getString(R.string.local_chillicrab_name), getString(R.string.local_chillicrab_desc), R.raw.chillicrab);
        chillicrab.setRecipe(getString(R.string.local_chillicrab_recipe));
        localItems.add(chillicrab);

        Item kayatoast = new Item(getString(R.string.local_kayatoast_name), getString(R.string.local_kayatoast_desc), R.raw.kayatoast);
        kayatoast.setRecipe(getString(R.string.local_kayatoast_recipe));
        localItems.add(kayatoast);

        Item chickenrice = new Item(getString(R.string.local_chickenrice_name), getString(R.string.local_chickenrice_desc), R.raw.chickenrice);
        chickenrice.setRecipe(getString(R.string.local_chickenrice_recipe));
        localItems.add(chickenrice);

        final ArrayList<SubCategory> subCategories = new ArrayList<SubCategory>();
        subCategories.add(new SubCategory("Local Dishes", localItems, R.drawable.local));
        subCategories.add(new SubCategory("Dining Out", R.drawable.dining));
        subCategories.add(new SubCategory("Nightlife in the City", R.drawable.party));
        SubCategoryAdapter adapter = new SubCategoryAdapter(getActivity(), subCategories);

        ListView listView = (ListView) rootView.findViewById(R.id.category_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SubCategory subCategory = subCategories.get(position);
                if (subCategory.hasItems()) {
                    Intent subCategoryIntent = new Intent(getActivity(), SubCategoryActivity.class);
                    subCategoryIntent.putExtra("title", subCategory.getName());
                    subCategoryIntent.putExtra("items", subCategory.getItems());
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
