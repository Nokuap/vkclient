package com.hiqo_solutions.vkclient.rest;

/**
 * Created by dmitry.zheltko on 8/6/2015.
 */
public class NewsRequest {
    private String filter = "post";
    private Integer returnBanned = 1;
    private Long startTime;
    private Long endTime;
    private Integer maxPhotos;
    private Long startFrom;
    private Integer count = 50;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Integer getReturnBanned() {
        return returnBanned;
    }

    public void setReturnBanned(Integer returnBanned) {
        this.returnBanned = returnBanned;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getMaxPhotos() {
        return maxPhotos;
    }

    public void setMaxPhotos(Integer maxPhotos) {
        this.maxPhotos = maxPhotos;
    }

    public Long getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(Long startFrom) {
        this.startFrom = startFrom;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
