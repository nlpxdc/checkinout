package io.cjf.mobileoa.checkinout.service;

import com.github.pagehelper.PageInfo;
import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;

public interface CheckInOutRecordService {

    PageInfo<CheckInOutRecord> getWithPage(Integer pageNum);

}
