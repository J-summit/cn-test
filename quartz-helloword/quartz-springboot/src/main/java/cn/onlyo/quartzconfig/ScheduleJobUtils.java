package cn.onlyo.quartzconfig;

import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author BruceMa
 * @date 2018/5/17 15:26
 */
@Service
@Transactional
public class ScheduleJobUtils {

//    @Autowired
//    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private Scheduler scheduler;

    // @PostConstruct
    public void start() throws SchedulerException, ClassNotFoundException {
        /* 一个Quartz的独立运行容器，Trigger和JobDetail可以注册到Scheduler中，
        两者在Scheduler中拥有各自的组及名称，组及名称是//Scheduler查找定位容器中某一对
        象的依据，Trigger的组及名称必须唯一，JobDetail的组和名称也必须唯一（//但可以和Trigg
        er的组和名称相同，因为它们是不同类型的）。Scheduler定义了多个接口方法，允许外部通过组
        及名称访问和控制容器中Trigger和JobDetail */
        //Scheduler scheduler = schedulerFactoryBean.getScheduler();

        //触发Job执行的时间触发规则
        TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "group1");
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 26 22 * * ? ");

        Class<? extends Job> clazz = (Class<? extends Job>) Class.forName("cn.onlyo.quartzconfig.jobdeatil.TestJob");

        JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity("trigger1", "group1").withDescription("描述").build();
        jobDetail.getJobDataMap().put("schedule", "数据库对象");

        trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withDescription("描述").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 获取当前任务
     *
     * @throws SchedulerException
     */
    public void getAllJobs() throws SchedulerException {
        //Scheduler scheduler = schedulerFactoryBean.getScheduler();
        GroupMatcher<JobKey> matcher = GroupMatcher.anyGroup();
        Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);

    }

    public void deleteJob() throws SchedulerException {
        //Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey("jobName", "group");

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        //暂停触发器
        scheduler.pauseTrigger(triggerKey);
        //移除触发器
        scheduler.unscheduleJob(triggerKey);

        JobKey jobKey = JobKey.jobKey("jobName", "group");
        scheduler.deleteJob(jobKey);


    }
//    public void test1() {
//        // define the job and tie it to our HelloJob class
//        JobDetail job = JobBuilder.newJob(TestJob.class)
//                .withIdentity("job1", "group1")
//                .build();
//
//        // Trigger the job to run now, and then repeat every 40 seconds
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("trigger1", "group1")
//                .startNow()
//                .withSchedule(simpleSchedule()
//                        .withIntervalInSeconds(40)
//                        .repeatForever())
//                .build();
//
//        // Tell quartz to schedule the job using our trigger
//        sched.scheduleJob(job, trigger);
//    }
}
