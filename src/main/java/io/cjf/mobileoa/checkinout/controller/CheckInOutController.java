package io.cjf.mobileoa.checkinout.controller;

import com.github.pagehelper.PageInfo;
import io.cjf.mobileoa.checkinout.po.CheckInOutRecord;
import io.cjf.mobileoa.checkinout.service.CheckInOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkinout")
public class CheckInOutController {

    @Autowired
    private CheckInOutRecordService checkInOutRecordService;

    @GetMapping("/getWithPage")
    PageInfo<CheckInOutRecord> getWithPage(@RequestParam(required = false, defaultValue = "1") Integer pageNum){
        PageInfo<CheckInOutRecord> checkInOutRecordPageInfo = checkInOutRecordService.getWithPage(pageNum);
        return checkInOutRecordPageInfo;
    }
}
