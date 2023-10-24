package com.bimbonet.beerlist.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bimbonet.beerlist.utilities.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = Constants.BEER_TABLE_NAME)
public class BeerModel implements Serializable {

    @Expose
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name="id")
    private Integer id;

    @SerializedName("name")
    @ColumnInfo(name="name")
    private String name;

    @SerializedName("tagline")
    @ColumnInfo(name="tagline")
    private String tagline;

    @SerializedName("first_brewed")
    @ColumnInfo(name="first_brewed")
    private String firstBrewed;

    @SerializedName("description")
    @ColumnInfo(name="description")
    private String description;

    @SerializedName("image_url")
    @ColumnInfo(name="image_url")
    private String imageUrl;

    @SerializedName("brewers_tips")
    @ColumnInfo(name="brewers_tips")
    private String brewersTips;

    @SerializedName("contributed_by")
    @ColumnInfo(name="contributed_by")
    private String contributedBy;

    public BeerModel(@NonNull Integer id, String name, String tagline, String firstBrewed, String description, String imageUrl, String brewersTips, String contributedBy) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.imageUrl = imageUrl;
        this.firstBrewed = firstBrewed;
        this.description = description;
        this.brewersTips = brewersTips;
        this.contributedBy = contributedBy;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBrewersTips() {
        return brewersTips;
    }

    public void setBrewersTips(String brewersTips) {
        this.brewersTips = brewersTips;
    }

    public String getContributedBy() {
        return contributedBy;
    }

    public void setContributedBy(String contributedBy) {
        this.contributedBy = contributedBy;
    }
}