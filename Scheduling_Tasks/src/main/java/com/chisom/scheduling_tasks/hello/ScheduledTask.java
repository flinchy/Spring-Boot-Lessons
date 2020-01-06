package com.chisom.scheduling_tasks.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class ScheduledTask {

    public static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public Map<String, String> myMap = new HashMap<>();

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("the time is now {}", dateFormat.format(new Date()));

    }

    @Scheduled(fixedRate = 6000)
    public void addToMap() {
        myMap.put("name", "john");
        log.info("new map value added at {}", dateFormat.format(new Date()));
        log.info("added {}", myMap.toString());
    }

}
