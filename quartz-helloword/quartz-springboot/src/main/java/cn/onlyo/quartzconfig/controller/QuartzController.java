package cn.onlyo.quartzconfig.controller;

import cn.onlyo.quartzconfig.baseclazz.QuartzInfer;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author onlyo
 * @since 2019/1/15 7:29
 */
@RestController
@Slf4j
public class QuartzController {

    @Autowired
    private QuartzInfer quartzInfer;


    @GetMapping("/jobstate")
    public String getJobState() throws SchedulerException {
        return quartzInfer.getJobState("triggerName", "triggerGroupName");
    }

    @GetMapping("pauseAllJob")
    public void pauseAllJob() throws SchedulerException {
        log.error("pauseAllJob");
        quartzInfer.pauseAllJob();
    }

    @GetMapping("resumeAllJob")
    public void resumeAllJob() throws SchedulerException {
        log.error("resumeAllJob");

        quartzInfer.resumeAllJob();
    }

    @GetMapping("pauseJob")
    public String pauseJob(String jobName, String jobGroup) throws SchedulerException {
        return quartzInfer.pauseJob("jobName", "jobgroupName");
    }


    // 恢复某个任务
    @GetMapping("resumeJob")
    public String resumeJob(String jobName, String jobGroup) throws SchedulerException {

        log.error("resumeJob");

        return quartzInfer.resumeJob("jobName", "jobgroupName");
    }
}
