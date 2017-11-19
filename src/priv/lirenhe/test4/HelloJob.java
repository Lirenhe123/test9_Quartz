package priv.lirenhe.test4;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
 
public class HelloJob implements Job
{
	public void execute(JobExecutionContext context)
	throws JobExecutionException {
 
		System.out.println("Hello Quartz! - by yiibai.com");	
 
		//Throw exception for testing
		throw new JobExecutionException("Testing Exception");
	}
 
}
