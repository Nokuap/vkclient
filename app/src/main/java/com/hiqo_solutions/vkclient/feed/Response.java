package com.hiqo_solutions.vkclient.feed;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dmitry.zheltko on 8/7/2015.
 */
public class Response {
    @SerializedName("response")
    private News news;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Response{");
        sb.append("news=").append(news);
        sb.append('}');
        return sb.toString();
    }
}
