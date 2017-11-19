/*package priv.lirenhe.test1;

import org.quartz.*;
import org.quartz.examples.example1.HelloJob;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;

import java.util.Date; 

*//** 
* quartz��ʱ������ 
* 
* @author leizhimin 2009-7-23 8:49:01 
*//* 
public class MyJob implements Job { 
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException { 
                System.out.println(new Date() + ": doing something..."); 
        } 
} 

class Test { 
        public static void main(String[] args) { 
                //1������JobDetial���� 
                JobDetail jobDetail = new JobDetail("MyJob", 
                        Scheduler.DEFAULT_GROUP, MyJob.class); 
//        	    JobDetail job = newJob(MyJob.class).withIdentity("job1", "group1").build();
                //���ù����� 
                jobDetail.setJobClass(MyJob.class); 
                jobDetail.setName("MyJob_1"); 
                jobDetail.setGroup("JobGroup_1"); 

                //2������Trigger���� 
                SimpleTrigger strigger = new SimpleTrigger(); 
                strigger.setName("Trigger_1"); 
                strigger.setGroup("Trigger_Group_1"); 
                strigger.setStartTime(new Date()); 
                //�����ظ�ֹͣʱ�䣬�����ٸ�Trigger���� 
                java.util.Calendar c = java.util.Calendar.getInstance(); 
                c.setTimeInMillis(System.currentTimeMillis() + 1000 * 1L); 
                strigger.setEndTime(c.getTime()); 
                strigger.setFireInstanceId("Trigger_1_id_001"); 
                //�����ظ����ʱ�� 
                strigger.setRepeatInterval(1000 * 1L); 
                //�����ظ�ִ�д��� 
                strigger.setRepeatCount(3); 

                //3������Scheduler���󣬲�����JobDetail��Trigger���� 
                SchedulerFactory sf = new StdSchedulerFactory(); 
                Scheduler scheduler = null; 
                try { 
                        scheduler = sf.getScheduler(); 
                        scheduler.scheduleJob(jobDetail, strigger); 
                        //4����ִ���������رյȲ��� 
                        scheduler.start(); 

                } catch (SchedulerException e) { 
                        e.printStackTrace(); 
                } 
//                try { 
//                        //�رյ����� 
//                        scheduler.shutdown(true); 
//                } catch (SchedulerException e) { 
//                        e.printStackTrace(); 
//                } 
        } 
}
*/