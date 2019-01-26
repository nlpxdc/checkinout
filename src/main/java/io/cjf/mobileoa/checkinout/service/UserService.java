package io.cjf.mobileoa.checkinout.service;

import io.cjf.mobileoa.checkinout.po.User;

import java.util.Date;

public interface UserService {

    User getById(String openId);

    void create(User user);

    void checkInOut(String openId, Date time);

}
