package com.hiqo_solutions.vkclient.feed.model.attachments;

/**
 * Created by dmitry.zheltko on 8/7/2015.
 */
public class Video extends Attachment {
    private Long id;
    private Long ownerId;
    private String title;
    private String description;
    private Long duration;
    private String photo_130;
    private String photo_320;
    private String photo_640;
    private Long date;
    private Long addingDate;
    private Long views;
    private Long comments;
    private String player;
    private String accessKey;
    private Boolean processing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getPhoto_130() {
        return photo_130;
    }

    public void setPhoto_130(String photo_130) {
        this.photo_130 = photo_130;
    }

    public String getPhoto_320() {
        return photo_320;
    }

    public void setPhoto_320(String photo_320) {
        this.photo_320 = photo_320;
    }

    public String getPhoto_640() {
        return photo_640;
    }

    public void setPhoto_640(String photo_640) {
        this.photo_640 = photo_640;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Long addingDate) {
        this.addingDate = addingDate;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Boolean getProcessing() {
        return processing;
    }

    public void setProcessing(Boolean processing) {
        this.processing = processing;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Video{");
        sb.append("id=").append(id);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", duration=").append(duration);
        sb.append(", photo_130='").append(photo_130).append('\'');
        sb.append(", photo_320='").append(photo_320).append('\'');
        sb.append(", photo_640='").append(photo_640).append('\'');
        sb.append(", date=").append(date);
        sb.append(", addingDate=").append(addingDate);
        sb.append(", views=").append(views);
        sb.append(", comments=").append(comments);
        sb.append(", player='").append(player).append('\'');
        sb.append(", accessKey='").append(accessKey).append('\'');
        sb.append(", processing=").append(processing);
        sb.append('}');
        return sb.toString();
    }
}
