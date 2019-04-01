package com.demo.authserver.secureservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController()
@RequestMapping("services")
public class TollgateController {

    @GetMapping("/tolldata")
    public ArrayList<TollUsage> getTollData(){
        ArrayList<TollUsage> tollUsages = new ArrayList<>();
        TollUsage t1 = new TollUsage("1001","Station1001","Licence_Plate_1001","2019-03-29T06:31:30");
        TollUsage t2 = new TollUsage("1002","Station1002","Licence_Plate_2002","2019-03-29T06:40:40");
        TollUsage t3 = new TollUsage("1003","Station1003","Licence_Plate_3003","2019-03-29T06:50:53");

        tollUsages.add(t1);
        tollUsages.add(t2);
        tollUsages.add(t3);

        return  tollUsages;
    }
}


