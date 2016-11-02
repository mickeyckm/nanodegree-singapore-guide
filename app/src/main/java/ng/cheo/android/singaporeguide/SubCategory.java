package ng.cheo.android.singaporeguide;

import java.util.ArrayList;

/**
 * Created by mickey on 31/10/16.
 */

public class SubCategory {

    private String mName;
    private ArrayList<Item> mItems;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public SubCategory(String name) {
        mName = name;
        mItems = new ArrayList<Item>();
    }

    public SubCategory(String name, int imageResourceId) {
        mName = name;
        mItems = new ArrayList<Item>();
        mImageResourceId = imageResourceId;
    }

    public SubCategory(String name, ArrayList<Item> items) {
        mName = name;
        mItems = items;
    }

    public SubCategory(String name, ArrayList<Item> items, int imageResourceId) {
        mName = name;
        mItems = items;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public ArrayList<Item> getItems() {
        return mItems;
    }

    public Boolean hasItems() {
        return !mItems.isEmpty();
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public Boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
