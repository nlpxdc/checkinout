package io.cjf.mobileoa.checkinout.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.cjf.mobileoa.checkinout.dao.CheckInOutRecordMapper;
import io.cjf.mobileoa.checkinout.dao.UserMapper;
import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;
import io.cjf.mobileoa.checkinout.po.User;
import io.cjf.mobileoa.checkinout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CheckInOutRecordMapper checkInOutRecordMapper;

    @Override
    public User getById(String openId) {
        User user = userMapper.selectByPrimaryKey(openId);
        return user;
    }

    @Override
    public void create(User user) {
        userMapper.insert(user);
    }

    @Override
    public void checkInOut(String openId, Date time) {
        CheckInOutRecord checkInOutRecord = new CheckInOutRecord();
        checkInOutRecord.setOpenid(openId);
        checkInOutRecord.setTime(time);

        checkInOutRecordMapper.insert(checkInOutRecord);
    }

    @Override
    public PageInfo<User> getWithPage(Integer pageNum) {
        PageHelper.startPage(pageNum,1);
        Page<User> users = userMapper.selectWithPage();
        PageInfo<User> userPageInfo = users.toPageInfo();
        return userPageInfo;
    }
}
