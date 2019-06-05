package cn.onlyo.quartzconfig.baseclazz;

import org.quartz.SchedulerException;

/**
 * @author onlyo
 * @since 2019/1/15 7:29
 */
public interface QuartzInfer {

    String getJobState(String jobName, String jobGroup) throws SchedulerException;

    //暂停所有任务
    void pauseAllJob() throws SchedulerException;

    void resumeAllJob() throws SchedulerException;

    //暂停任务
    String pauseJob(String jobName, String jobGroup) throws SchedulerException;

    // 恢复某个任务
    String resumeJob(String jobName, String jobGroup) throws SchedulerException;
}
