package com.hiqo_solutions.vkclient.feed.model.attachments;

/**
 * Created by dmitry.zheltko on 8/7/2015.
 */
public class Doc extends Attachment {
    private Long id;
    private Long ownerId;
    private String title;
    private Long size;
    private String ext;
    private String url;
    private String photo100;
    private String photo130;



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

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhoto100() {
        return photo100;
    }

    public void setPhoto100(String photo100) {
        this.photo100 = photo100;
    }

    public String getPhoto130() {
        return photo130;
    }

    public void setPhoto130(String photo130) {
        this.photo130 = photo130;
    }    @Override
         public String toString() {
        final StringBuilder sb = new StringBuilder("Doc{");
        sb.append("id=").append(id);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", size=").append(size);
        sb.append(", ext='").append(ext).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", photo100='").append(photo100).append('\'');
        sb.append(", photo130='").append(photo130).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
