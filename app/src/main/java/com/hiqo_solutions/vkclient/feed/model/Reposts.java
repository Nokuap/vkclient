package com.hiqo_solutions.vkclient.feed.model;

/**
 * Created by dmitry.zheltko on 8/6/2015.
 */
public class Reposts {
    private Long count;
    private Boolean userReposted;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Boolean getUserReposted() {
        return userReposted;
    }

    public void setUserReposted(Boolean userReposted) {
        this.userReposted = userReposted;
    }
}
