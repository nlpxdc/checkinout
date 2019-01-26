package io.cjf.mobileoa.checkinout.dao;

import com.github.pagehelper.Page;
import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;

public interface CheckInOutRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckInOutRecord record);

    int insertSelective(CheckInOutRecord record);

    CheckInOutRecord selectByPrimaryKey(Integer id);

    Page<CheckInOutRecord> selectWithPage();

    int updateByPrimaryKeySelective(CheckInOutRecord record);

    int updateByPrimaryKey(CheckInOutRecord record);
}