package ng.cheo.android.singaporeguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by mickey on 30/10/16.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "See & Do", "Festivals & Events", "Eat & Drink" };
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SeeDoFragment();
        } else if (position == 1) {
            return new FestivalsEventsFragment();
        } else {
            return new EatDrinkFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_see_do);
        } else if (position == 1) {
            return mContext.getString(R.string.category_festivals_events);
        } else {
            return mContext.getString(R.string.category_eat_drinks);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
