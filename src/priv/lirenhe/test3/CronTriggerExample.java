package priv.lirenhe.test3;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
 
/**
 * ����Quartz����������Quartz�����������Quartz��ҵ��

���ϰ汾��Quartz����Ȼ���������͵Ĵ�������Quartz2����API��Щ�仯��

SimpleTrigger �C �������ÿ�ʼʱ�䣬����ʱ�䣬�ظ������
CronTrigger �C ����UNIX cron���ʽ��ָ�����ں�ʱ����������ҵ��
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
			CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))//cron���ʽ��ÿ��5��
		.build();
 
    	//schedule it
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(job, trigger);
 
    }
}
