package priv.lirenhe.test6;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * ����3����ҵ��JobA��JobB��JobC��
 * @author lenovo
 *
 */
public class JobA implements Job {
 
	@Override
	public void execute(JobExecutionContext context)
		throws JobExecutionException {
		System.out.println("Job A is runing //every 5 seconds ");
	}
 
}
