package com.hiqo_solutions.vkclient.feed.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dmitry.zheltko on 8/6/2015.
 */
public class News {
    @SerializedName("items")
    private List<Post> posts;
    private List<Group> groups;
    private List<Profile> profiles;
    private String nextFrom;

    public String getNextFrom() {
        return nextFrom;
    }

    public void setNextFrom(String nextFrom) {
        this.nextFrom = nextFrom;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("News{");
        sb.append("items=").append(posts);
        sb.append('}');
        return sb.toString();
    }
}
