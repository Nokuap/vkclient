package com.hiqo_solutions.vkclient.feed.attachments;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dmitry.zheltko on 8/6/2015.
 */
public abstract class Attachment {
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        @SerializedName("photo")
        PHOTO,
        @SerializedName("posted_photo")
        POSTED_PHOTO,
        @SerializedName("video")
        VIDEO,
        @SerializedName("audio")
        AUDIO,
        @SerializedName("doc")
        DOC,
        UNDEFINED
    }
}
