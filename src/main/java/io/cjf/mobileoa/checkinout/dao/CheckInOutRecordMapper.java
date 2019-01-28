package io.cjf.mobileoa.checkinout.dao;

import com.github.pagehelper.Page;
import io.cjf.mobileoa.checkinout.dto.CheckRecordDTO;
import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;

import java.util.Date;
import java.util.List;

public interface CheckInOutRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckInOutRecord record);

    int insertSelective(CheckInOutRecord record);

    CheckInOutRecord selectByPrimaryKey(Integer id);

    Page<CheckInOutRecord> selectWithPage();

    List<CheckRecordDTO> selectWithTime(Date time);

    int updateByPrimaryKeySelective(CheckInOutRecord record);

    int updateByPrimaryKey(CheckInOutRecord record);
}