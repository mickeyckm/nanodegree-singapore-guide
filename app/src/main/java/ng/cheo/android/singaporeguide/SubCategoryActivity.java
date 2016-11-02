package ng.cheo.android.singaporeguide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SubCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        setTitle(intent.getStringExtra("title"));

        final ArrayList<Item> items = intent.getParcelableArrayListExtra("items");

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
