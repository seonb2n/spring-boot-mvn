package com.example;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//application context 가 만들어진 이후에 발생하면 이벤트가 발생된다.
//application context 가 만들어지기 전 발생한 이벤트는, bean 으로 등록을 해도 동작을 안함
@Component
public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("==========");
        System.out.println("Started");
        System.out.println("==========");
    }
}
