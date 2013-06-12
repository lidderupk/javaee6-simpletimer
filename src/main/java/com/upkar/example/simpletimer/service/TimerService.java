/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upkar.example.simpletimer.service;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author upkar
 */
@Singleton
public class TimerService {
    @EJB
    HelloService helloService;  
  
    @Schedule(second="*/10", minute="*",hour="*", persistent=false)
    public void doWork(){
        System.out.println("timer: " + helloService.sayHello());
        System.out.println("time out ... send email ... return back");
    }
    
    /*
     * the @Timeout is only used for programattic timers !
     */
    @Timeout
    public void timeOut()
    {
        System.out.println("timeout ... send email and reset ...");
    }
}
