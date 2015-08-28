package com.hiqo_solutions.vkclient.feed.attachments;

/**
 * Created by dmitry.zheltko on 8/7/2015.
 */
public class PostedPhoto extends Attachment {
    private Long id;
    private String photo130;
    private String photo604;
    private Long ownerId;


    public String getPhoto130() {
        return photo130;
    }

    public void setPhoto130(String photo130) {
        this.photo130 = photo130;
    }

    public String getPhoto604() {
        return photo604;
    }

    public void setPhoto604(String photo604) {
        this.photo604 = photo604;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PostedPhoto{");
        sb.append("id=").append(id);
        sb.append(", photo130='").append(photo130).append('\'');
        sb.append(", photo604='").append(photo604).append('\'');
        sb.append(", ownerId=").append(ownerId);
        sb.append('}');
        return sb.toString();
    }
}
