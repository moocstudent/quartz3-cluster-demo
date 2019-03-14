package com.how2java;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

public class MailJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
        JobDetail detail = context.getJobDetail();
        String email = detail.getJobDataMap().getString("email");
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String now = sdf.format(new  Date());
        
        
        
        try {
			System.out.printf("给邮件地址 %s 发出了一封定时邮件, 当前时间是: %s , 调度器id是：%s%n" ,email, now, context.getScheduler().getSchedulerInstanceId());
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}