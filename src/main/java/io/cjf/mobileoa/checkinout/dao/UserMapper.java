package io.cjf.mobileoa.checkinout.dao;

import com.github.pagehelper.Page;
import io.cjf.mobileoa.checkinout.po.User;

public interface UserMapper {
    int deleteByPrimaryKey(String openid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String openid);

    Page<User> selectWithPage();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}