package ng.cheo.android.singaporeguide;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by mickey on 31/10/16.
 */

public class Item implements Parcelable {

    private String mName;
    private String mDesc;
    private String mRecipe;
    private String mTime;
    private String mAddress;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Item(Parcel in) {
        readFromParcel(in);
    }

    public Item(String name, String description) {
        mName = name;
        mDesc = description;
        mRecipe = "";
        mTime = "";
        mAddress = "";
    }

    public Item(String name, String description, int imageResourceId) {
        mName = name;
        mDesc = description;
        mImageResourceId = imageResourceId;
        mRecipe = "";
        mTime = "";
        mAddress = "";
    }

    public String getName() {
        return mName;
    }

    public String getDesc() {
        return mDesc;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getRecipe() {
        return mRecipe;
    }

    public void setRecipe(String recipe) {
        mRecipe = recipe;
    }

    public Boolean hasRecipe() {
        return !mRecipe.equals("");
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public Boolean hasTime() {
        return !mTime.equals("");
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public Boolean hasAddress() {
        return !mAddress.equals("");
    }

    public Boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(mName);
        dest.writeString(mDesc);
        dest.writeInt(mImageResourceId);
        dest.writeString(mRecipe);
        dest.writeString(mTime);
        dest.writeString(mAddress);

    }

    private void readFromParcel(Parcel in) {

        mName = in.readString();
        mDesc = in.readString();
        mImageResourceId = in.readInt();
        mRecipe = in.readString();
        mAddress = in.readString();
        mTime = in.readString();

    }

    public static final Parcelable.Creator CREATOR =
        new Parcelable.Creator() {
            public Item createFromParcel(Parcel in) {
                return new Item(in);
            }

            public Item[] newArray(int size) {
                return new Item[size];
            }
        };
}
