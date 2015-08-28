package com.hiqo_solutions.vkclient.feed;

import com.hiqo_solutions.vkclient.feed.attachments.Attachment;

import java.util.List;

/**
 * Created by dmitry.zheltko on 8/6/2015.
 */
public class Post {
    private String type;
    private Long sourceId;
    private Long date;
    private Long postId;
    private String postType;
    private String finalPost;
    private Long copyOwnerId;
    private Long copyPostId;
    //massive
    private Object copyHistory;
    private String copyPostDate;
    private String text;
    private Boolean canEdit;
    private Boolean cadDelete;
    private Comments comments;
    private Likes likes;
    private Reposts reposts;
    private List<Attachment> attachments;
    private Geo geo;
    private Photos photos;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getFinalPost() {
        return finalPost;
    }

    public void setFinalPost(String finalPost) {
        this.finalPost = finalPost;
    }

    public Long getCopyOwnerId() {
        return copyOwnerId;
    }

    public void setCopyOwnerId(Long copyOwnerId) {
        this.copyOwnerId = copyOwnerId;
    }

    public Long getCopyPostId() {
        return copyPostId;
    }

    public void setCopyPostId(Long copyPostId) {
        this.copyPostId = copyPostId;
    }

    public Object getCopyHistory() {
        return copyHistory;
    }

    public void setCopyHistory(Object copyHistory) {
        this.copyHistory = copyHistory;
    }

    public String getCopyPostDate() {
        return copyPostDate;
    }

    public void setCopyPostDate(String copyPostDate) {
        this.copyPostDate = copyPostDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Boolean getCadDelete() {
        return cadDelete;
    }

    public void setCadDelete(Boolean cadDelete) {
        this.cadDelete = cadDelete;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public Reposts getReposts() {
        return reposts;
    }

    public void setReposts(Reposts reposts) {
        this.reposts = reposts;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Post{");
        sb.append("type='").append(type).append('\'');
        sb.append(", sourceId=").append(sourceId);
        sb.append(", date=").append(date);
        sb.append(", postId=").append(postId);
        sb.append(", postType='").append(postType).append('\'');
        sb.append(", finalPost='").append(finalPost).append('\'');
        sb.append(", copyOwnerId=").append(copyOwnerId);
        sb.append(", copyPostId=").append(copyPostId);
        sb.append(", copyHistory=").append(copyHistory);
        sb.append(", copyPostDate='").append(copyPostDate).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", canEdit=").append(canEdit);
        sb.append(", cadDelete=").append(cadDelete);
        sb.append(", comments=").append(comments);
        sb.append(", likes=").append(likes);
        sb.append(", reposts=").append(reposts);
        sb.append(", attachments=").append(attachments);
        sb.append(", geo=").append(geo);
        sb.append(", photos=").append(photos);
        sb.append('}');
        return sb.toString();
    }
}
