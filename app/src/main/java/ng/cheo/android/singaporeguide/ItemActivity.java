package ng.cheo.android.singaporeguide;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent intent = getIntent();
        Item item = intent.getParcelableExtra("item");
        setTitle(item.getName());

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(item.getImageResourceId());

        TextView textView = (TextView) findViewById(R.id.desc);
        textView.setText(item.getDesc());

        if (item.hasTime()) {

            TextView timeTitleTextView = (TextView) findViewById(R.id.time_title);
            timeTitleTextView.setVisibility(View.VISIBLE);

            TextView timeTextView = (TextView) findViewById(R.id.time);
            timeTextView.setText(item.getTime());
            timeTextView.setVisibility(View.VISIBLE);

        }

        if (item.hasAddress()) {

            TextView addressTitleTextView = (TextView) findViewById(R.id.address_title);
            addressTitleTextView.setVisibility(View.VISIBLE);

            TextView addressTextView = (TextView) findViewById(R.id.address);
            addressTextView.setText(item.getAddress());
            addressTextView.setVisibility(View.VISIBLE);

        }

        if (item.hasRecipe()) {

            TextView recipeTitleTextView = (TextView) findViewById(R.id.recipe_title);
            recipeTitleTextView.setVisibility(View.VISIBLE);

            TextView recipeTextView = (TextView) findViewById(R.id.recipe);
            recipeTextView.setText(item.getRecipe());
            recipeTextView.setVisibility(View.VISIBLE);

        }

    }
}
