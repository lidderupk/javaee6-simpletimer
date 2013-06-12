/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upkar.example.simpletimer.service;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Singleton
@Startup
public class TimerSessionBean {
    @Resource
    TimerService timerService;
    
    long duration = 6000;

    private Logger logger = Logger.getLogger(
            "simpletimer.service.TimerSessionBean");
    
    @PostConstruct
    public void setTimer() {
        logger.info("Setting a programmatic timeout for "
                + duration + " milliseconds from now.");
        
        Timer timer= timerService.createIntervalTimer(duration, duration, new TimerConfig());
    }
    
    @Timeout
    public void programmaticTimeout(Timer timer) {
        logger.info("Programmatic timeout occurred. " + System.currentTimeMillis());
    }

}