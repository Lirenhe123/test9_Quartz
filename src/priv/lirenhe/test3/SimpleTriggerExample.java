package priv.lirenhe.test3;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 定义Quartz触发器，当Quartz运行在上面的Quartz作业。

像老版本的Quartz，仍然有两种类型的触发器在Quartz2，但API有些变化：

SimpleTrigger – 允许设置开始时间，结束时间，重复间隔。
CronTrigger – 允许UNIX cron表达式来指定日期和时间来运行作业。
 * @author lenovo
 *http://www.yiibai.com/quartz/quartz-helloworld.html
 */
public class SimpleTriggerExample {
	public static void main(String[] args) throws Exception {
 
		// Quartz 1.6.3
		// JobDetail job = new JobDetail();
		// job.setName("dummyJobName");
		// job.setJobClass(HelloJob.class);
 
		JobDetail job = JobBuilder.newJob(HelloJob.class)
			.withIdentity("dummyJobName", "group1").build();
 
                //Quartz 1.6.3
		// SimpleTrigger trigger = new SimpleTrigger();
		// trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
		// trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		// trigger.setRepeatInterval(30000);
 
		// Trigger the job to run on the next round minute
		Trigger trigger = TriggerBuilder
			.newTrigger()
			.withIdentity("dummyTriggerName", "group1")
			.withSchedule(
				SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(5).repeatForever())
			.build();
 
		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
 
	}
}
