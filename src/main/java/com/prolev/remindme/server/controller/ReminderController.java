package com.prolev.remindme.server.controller;

import com.prolev.remindme.server.entity.Remind;
import com.prolev.remindme.server.repository.RemindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by dmitryvalov on 23.07.17.
 */
@RestController
@RequestMapping("/reminder")
public class ReminderController {

    @Autowired
    private RemindRepository remindRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Remind getReminder() {

        List<Remind> list = remindRepository.findAll();
        return  createMockRemind();
    }

    private Remind createMockRemind() {

        Remind remind = new Remind();
        remind.setId(1);
        remind.setRemindDate(new Date());
        remind.setTitle("My fisrt remind");

        return remind;
    }
}
