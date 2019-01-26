package io.cjf.mobileoa.checkinout.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.cjf.mobileoa.checkinout.dao.CheckInOutRecordMapper;
import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;
import io.cjf.mobileoa.checkinout.service.CheckInOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInOutRecordServiceImpl implements CheckInOutRecordService {

    @Autowired
    private CheckInOutRecordMapper checkInOutRecordMapper;

    @Override
    public PageInfo<CheckInOutRecord> getWithPage(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<CheckInOutRecord> checkInOutRecords = checkInOutRecordMapper.selectWithPage();
        PageInfo<CheckInOutRecord> checkInOutRecordsPageInfo = checkInOutRecords.toPageInfo();
        return checkInOutRecordsPageInfo;
    }
}
