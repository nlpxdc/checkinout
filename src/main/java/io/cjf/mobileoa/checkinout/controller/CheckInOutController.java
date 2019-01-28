package io.cjf.mobileoa.checkinout.controller;

import com.github.pagehelper.PageInfo;
import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;
import io.cjf.mobileoa.checkinout.service.CheckInOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/checkinout")
public class CheckInOutController {

    @Autowired
    private CheckInOutRecordService checkInOutRecordService;

    @GetMapping("/getWithPage")
    public PageInfo<CheckInOutRecord> getWithPage(@RequestParam(required = false, defaultValue = "1") Integer pageNum){
        PageInfo<CheckInOutRecord> checkInOutRecordPageInfo = checkInOutRecordService.getWithPage(pageNum);
        return checkInOutRecordPageInfo;
    }

    @GetMapping("/getWithTime")
    public List<CheckInOutRecord> getWithTime(@RequestParam(required = false) Long timestamp){
        Date time = new Date();
        if (timestamp != null){
            time = new Date(timestamp);
        }

        List<CheckInOutRecord> checkInOutRecords = checkInOutRecordService.getWithTime(time);

        return checkInOutRecords;
    }
}
