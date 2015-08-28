package com.hiqo_solutions.vkclient.feed.model;

/**
 * Created by dmitry.zheltko on 8/11/2015.
 */
public class Group {
    private Long id;
    private String name;
    private String screenName;
    private Byte isClosed;
    private Byte deactivated;
    private Boolean isAdmin;
    private Byte adminLevel;
    private Boolean isMember;
    private String type;
    private String photo_50;
    private String photo_100;
    private String photo_200;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Byte getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Byte isClosed) {
        this.isClosed = isClosed;
    }

    public Byte getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(Byte deactivated) {
        this.deactivated = deactivated;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Byte getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(Byte adminLevel) {
        this.adminLevel = adminLevel;
    }

    public Boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(Boolean isMember) {
        this.isMember = isMember;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto_50() {
        return photo_50;
    }

    public void setPhoto_50(String photo_50) {
        this.photo_50 = photo_50;
    }

    public String getPhoto_100() {
        return photo_100;
    }

    public void setPhoto_100(String photo_100) {
        this.photo_100 = photo_100;
    }

    public String getPhoto_200() {
        return photo_200;
    }

    public void setPhoto_200(String photo_200) {
        this.photo_200 = photo_200;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        return id.equals(group.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
