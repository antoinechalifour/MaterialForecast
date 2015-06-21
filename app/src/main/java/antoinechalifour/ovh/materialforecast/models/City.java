package antoinechalifour.ovh.materialforecast.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by antoine on 20/06/15.
 */
public class City implements Parcelable {
    public static final String TAG = City.class.getSimpleName();
    private String mName;
    private String mCountry;
    private double mTemp;

    public City(String name, String country, double temp) {
        mName = name;
        mCountry = country;
        mTemp = temp;
    }

    public City(final Parcel parcel) {
        mName = parcel.readString();
        mCountry = parcel.readString();
        mTemp = parcel.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel parcel, final int i) {
        parcel.writeString(mName);
        parcel.writeString(mCountry);
        parcel.writeDouble(mTemp);
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(final Parcel parcel) {
            return new City(parcel);
        }

        @Override
        public City[] newArray(final int i) {
            return new City[i];
        }
    };

    public String getName() {
        return mName;
    }

    public void setName(final String name) {
        mName = name;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(final String country) {
        mCountry = country;
    }

    public double getTemp() {
        return mTemp;
    }

    public void setTemp(final double temp) {
        mTemp = temp;
    }
}
