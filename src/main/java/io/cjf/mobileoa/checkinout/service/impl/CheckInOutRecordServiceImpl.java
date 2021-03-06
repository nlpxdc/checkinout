package io.cjf.mobileoa.checkinout.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.cjf.mobileoa.checkinout.dao.CheckInOutRecordMapper;
import io.cjf.mobileoa.checkinout.dto.CheckRecordDTO;
import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;
import io.cjf.mobileoa.checkinout.service.CheckInOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public List<CheckRecordDTO> getWithTime(Date time) {
        List<CheckRecordDTO> checkInOutRecords = checkInOutRecordMapper.selectWithTime(time);
        checkInOutRecords.stream().forEach(checkRecordDTO -> checkRecordDTO.setTimestamp(checkRecordDTO.getTime().getTime()));
        return checkInOutRecords;
    }
}
