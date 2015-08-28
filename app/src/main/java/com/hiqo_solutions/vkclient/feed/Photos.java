package com.hiqo_solutions.vkclient.feed;

import java.util.List;

/**
 * Created by dmitry.zheltko on 8/12/2015.
 */
public class Photos {
    private Long count;
    private List<Photo> items;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<Photo> getItems() {
        return items;
    }

    public void setItems(List<Photo> items) {
        this.items = items;
    }
}
