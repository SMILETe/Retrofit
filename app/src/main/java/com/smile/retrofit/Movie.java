
package com.smile.retrofit;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Movie {

    @SerializedName("banner")
    private java.util.List<Banner> mBanner;
    @SerializedName("list")
    private java.util.List<com.smile.retrofit.List> mList;

    public java.util.List<Banner> getBanner() {
        return mBanner;
    }

    public void setBanner(java.util.List<Banner> banner) {
        mBanner = banner;
    }

    public java.util.List<com.smile.retrofit.List> getList() {
        return mList;
    }

    public void setList(java.util.List<com.smile.retrofit.List> list) {
        mList = list;
    }

}
