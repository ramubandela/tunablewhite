package com.lcm.example.tunablewhite.controller;

import com.lcm.example.tunablewhite.TunablewhiteApplication;
import com.lcm.example.tunablewhite.config.HandlerConfig;
import com.lcm.example.tunablewhite.model.DataProfile;
import com.lcm.example.tunablewhite.service.LCMService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/root")
//@ConditionalOnProperty(value = "",havingValue = "",matchIfMissing = false)
public class LCMController {

   // private static final Logger log = LoggerFactory.getLogger(TunablewhiteApplication.class);
    @Autowired
    private LCMService lcmService;

    @Autowired
    private HandlerConfig handlerConfig;

    @PostMapping("/saveDataProfile")
    public ResponseEntity<DataProfile> saveDataProfile(@RequestBody DataProfile dataProfile){


    return ResponseEntity.ok(lcmService.saveDataProfile(dataProfile));
    }
    @GetMapping ("/getDataProfile/{dataProfileId}")
    public ResponseEntity<DataProfile> getDataProfile(@PathVariable String dataProfileId){


        return ResponseEntity.ok(lcmService.getDataProfile(dataProfileId));
    }

}
