/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upkar.example.simpletimer.service;

import javax.ejb.Stateless;

/**
 *
 * @author upkar
 */
@Stateless
public class HelloService {
    public String sayHello(){
        return "Hello from control: " + System.currentTimeMillis();
    }
}