package io.cjf.mobileoa.checkinout.controller;

import com.github.pagehelper.PageInfo;
import io.cjf.mobileoa.checkinout.dto.CheckRecordDTO;
import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;
import io.cjf.mobileoa.checkinout.service.CheckInOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/checkinout")
@CrossOrigin
public class CheckInOutController {

    @Autowired
    private CheckInOutRecordService checkInOutRecordService;

    @GetMapping("/getWithPage")
    public PageInfo<CheckInOutRecord> getWithPage(@RequestParam(required = false, defaultValue = "1") Integer pageNum){
        PageInfo<CheckInOutRecord> checkInOutRecordPageInfo = checkInOutRecordService.getWithPage(pageNum);
        return checkInOutRecordPageInfo;
    }

    @GetMapping("/getWithTime")
    public List<CheckRecordDTO> getWithTime(@RequestParam(required = false) Long timestamp){
        Date time = new Date();
        if (timestamp != null){
            time = new Date(timestamp);
        }

        List<CheckRecordDTO> checkInOutRecords = checkInOutRecordService.getWithTime(time);

        return checkInOutRecords;
    }
}
