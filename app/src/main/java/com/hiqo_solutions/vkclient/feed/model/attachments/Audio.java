package com.hiqo_solutions.vkclient.feed.model.attachments;

/**
 * Created by dmitry.zheltko on 8/7/2015.
 */
public class Audio extends Attachment {
    private Long id;
    private Long ownerId;
    private String artist;
    private String title;
    private Integer duration;
    private String url;
    private Long lyricsId;
    private Long albumId;
    private Long genreId;
    private Long date;

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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getLyricsId() {
        return lyricsId;
    }

    public void setLyricsId(Long lyricsId) {
        this.lyricsId = lyricsId;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Audio{");
        sb.append("id=").append(id);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", artist='").append(artist).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", duration=").append(duration);
        sb.append(", url='").append(url).append('\'');
        sb.append(", lyricsId=").append(lyricsId);
        sb.append(", albumId=").append(albumId);
        sb.append(", genreId=").append(genreId);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
