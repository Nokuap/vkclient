package com.hiqo_solutions.vkclient.feed.model;

/**
 * Created by dmitry.zheltko on 8/6/2015.
 */
public class Likes {
    private Long count;
    private Boolean userLikes;
    private Boolean canLike;
    private Boolean canPublish;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Boolean getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Boolean userLikes) {
        this.userLikes = userLikes;
    }

    public Boolean getCanLike() {
        return canLike;
    }

    public void setCanLike(Boolean canLike) {
        this.canLike = canLike;
    }

    public Boolean getCanPublish() {
        return canPublish;
    }

    public void setCanPublish(Boolean canPublish) {
        this.canPublish = canPublish;
    }
}
