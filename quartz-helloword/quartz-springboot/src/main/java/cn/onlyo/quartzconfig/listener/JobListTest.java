package cn.onlyo.quartzconfig.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.springframework.stereotype.Component;

/**
 * @author onlyo
 * @since 2019/1/14 9:39
 */
@Component("jobListTest")
public class JobListTest implements JobListener {

    @Override
    public String getName() {
        return "jobListTest";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {

    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

        System.out.println("JobListener监听：" + context.getJobDetail().getKey());
    }
}
