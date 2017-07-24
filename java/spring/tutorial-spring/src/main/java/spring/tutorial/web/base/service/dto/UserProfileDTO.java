package spring.tutorial.web.base.service.dto;

import java.util.Date;

public class UserProfileDTO {

    private Integer userId;

    private String preferredContactMode;

    private Date lastAccessTime;

    private Date createtime;

    private Date updatetime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPreferredContactMode() {
        return preferredContactMode;
    }

    public void setPreferredContactMode(String preferredContactMode) {
        this.preferredContactMode = preferredContactMode;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
