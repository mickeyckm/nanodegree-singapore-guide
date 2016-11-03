package ng.cheo.android.singaporeguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ng.cheo.android.singaporeguide.adapters.ItemAdapter;
import ng.cheo.android.singaporeguide.models.Item;

public class SubCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        setTitle(intent.getStringExtra(getString(R.string.extra_title)));

        final ArrayList<Item> items = intent.getParcelableArrayListExtra(getString(R.string.extra_items));

        ItemAdapter adapter = new ItemAdapter(SubCategoryActivity.this, items);

        ListView listView = (ListView) findViewById(R.id.subcategory_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = items.get(position);
                Intent itemIntent = new Intent(SubCategoryActivity.this, ItemActivity.class);
                itemIntent.putExtra("item", item);
                startActivity(itemIntent);
            }
        });

    }

}
