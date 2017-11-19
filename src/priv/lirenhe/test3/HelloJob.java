package priv.lirenhe.test3;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * Quartz作业定义要运行什么？
 * @author lenovo
 *
 */
public class HelloJob implements Job
{
	public void execute(JobExecutionContext context)
	throws JobExecutionException {
 
		System.out.println("Hello Quartz!");	
 
	}
}
