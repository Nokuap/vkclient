package com.hiqo_solutions.vkclient.feed.model;

/**
 * Created by dmitry.zheltko on 8/6/2015.
 */
public class Geo {
    private Long placeId;
    private String title;
    private String type;
    private Long countryId;
    private Long cityId;
    private String address;
    //TODO wtf?
    private Object showmap;

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getShowmap() {
        return showmap;
    }

    public void setShowmap(Object showmap) {
        this.showmap = showmap;
    }
}
