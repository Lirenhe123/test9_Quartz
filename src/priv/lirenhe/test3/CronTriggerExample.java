package priv.lirenhe.test3;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
 
/**
 * 定义Quartz触发器，当Quartz运行在上面的Quartz作业。

像老版本的Quartz，仍然有两种类型的触发器在Quartz2，但API有些变化：

SimpleTrigger – 允许设置开始时间，结束时间，重复间隔。
CronTrigger – 允许UNIX cron表达式来指定日期和时间来运行作业。
 * @author lenovo
 *
 */
public class CronTriggerExample 
{
    public static void main( String[] args ) throws Exception
    {
    	//Quartz 1.6.3
    	//JobDetail job = new JobDetail();
    	//job.setName("dummyJobName");
    	//job.setJobClass(HelloJob.class);    	
    	JobDetail job = JobBuilder.newJob(HelloJob.class)
		.withIdentity("dummyJobName", "group1").build();
 
	//Quartz 1.6.3
    	//CronTrigger trigger = new CronTrigger();
    	//trigger.setName("dummyTriggerName");
    	//trigger.setCronExpression("0/5 * * * * ?");
 
    	Trigger trigger = TriggerBuilder
		.newTrigger()
		.withIdentity("dummyTriggerName", "group1")
		.withSchedule(
			CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))//cron表达式：每隔5秒
		.build();
 
    	//schedule it
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(job, trigger);
 
    }
}
