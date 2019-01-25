package io.cjf.mobileoa.checkinout.dao;

import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;

public interface CheckInOutRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(CheckInOutRecord record);

    int insertSelective(CheckInOutRecord record);

    CheckInOutRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CheckInOutRecord record);

    int updateByPrimaryKey(CheckInOutRecord record);
}