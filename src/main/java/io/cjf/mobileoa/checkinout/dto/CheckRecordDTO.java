package io.cjf.mobileoa.checkinout.dto;

import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;
import io.cjf.mobileoa.checkinout.po.User;

public class CheckRecordDTO extends CheckInOutRecord {
    private Long timestamp;
    private User user;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
