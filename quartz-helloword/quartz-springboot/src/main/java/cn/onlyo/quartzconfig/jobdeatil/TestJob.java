package cn.onlyo.quartzconfig.jobdeatil;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author BruceMa
 * @date 2018/5/17 15:46
 */
public class TestJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println(context.getTrigger().getKey() +
                " triggered. time is:" + (new Date()));
    }
}
