package io.cjf.mobileoa.checkinout.service;

import com.github.pagehelper.PageInfo;
import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;

import java.util.Date;
import java.util.List;

public interface CheckInOutRecordService {

    PageInfo<CheckInOutRecord> getWithPage(Integer pageNum);

    List<CheckInOutRecord> getWithTime(Date time);

}
