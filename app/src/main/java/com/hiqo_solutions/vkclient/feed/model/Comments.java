package com.hiqo_solutions.vkclient.feed.model;

/**
 * Created by dmitry.zheltko on 8/6/2015.
 */
public class Comments {
    private Integer count;
    private Boolean canPost;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getCanPost() {
        return canPost;
    }

    public void setCanPost(Boolean canPost) {
        this.canPost = canPost;
    }
}
