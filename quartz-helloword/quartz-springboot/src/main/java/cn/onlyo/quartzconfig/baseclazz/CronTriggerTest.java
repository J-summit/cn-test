package cn.onlyo.quartzconfig.baseclazz;

import cn.onlyo.quartzconfig.jobdeatil.TestJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author onlyo
 * @since 2019/1/10 21:55
 */
@Slf4j
@Service
public class CronTriggerTest implements QuartzInfer {
    /**
     * 1.corn表达式
     * 由六位或者七位组成
     * 位置   时间域名        允许值         允许特殊符号
     * 1        秒           0-59        ,_* /
     * 2        分钟          0-59        ,_* /
     * 3        小时          0-23        ,_* /
     * 4        日期          1-31        ,_* ?/ LWC
     * 5        月份          1-12        ,_* /
     * 6        星期          1-7        ,_* ?/ LC#
     * 7        年(可选)       空值1970-2099 ,_* /
     * <p>
     * (1)* 表示每一个时刻，eg*在分钟表示每分钟
     * (2)? 无意义 占位符
     * (3)_ 表示一个范围 eg小时表示10-12 10点到12点
     * (4),逗号 表示列表值 eg星期字段使用"MON,FRI" 表示周一周五
     * (5)/ 表示等步序列 x为起始值，y为增量步张值 eg 分钟5/12,表示从每小时的第五分钟开始每个12分钟
     * (6)L, 只能是使用在日期和星期中 表示该末，即星期六 1月31日
     * (7)W 只能修饰日期，表示该最近工作日eg LW组合改月最后的工作日
     * (8)# 使用在星期中 6#3 表示该月第三个周五,6即周五
     * (9)C eg 5C在五日后的那一天  eg 1C星期，周日后一天
     * <p>
     * 0 0 12 * * ? 每天12点
     * 0 0/5 12,15 * * ? 每天12到15点 没五分钟运行一下
     * 0 0 12 L * ? 每月最后一天12点
     */

    @Autowired
    private Scheduler scheduler;

    // @PostConstruct
    public void test1() {

        JobDetail jobDetail = JobBuilder.newJob(TestJob.class).withIdentity("jobName", "jobgroupName").build();


        // */5 * * * * ? 和 0/5 * * * * ? 都表示每五秒执行一次，但是第一个是任何时候，而第二个表示要先秒到0然后五秒执行一次

        String cron = "*/5 * * * * ?";
        if (!CronExpression.isValidExpression(cron)) {
            log.error("Illegal cron expression");   //表达式格式不正确
        }

        //.withMisfireHandlingInstructionDoNothing() 不触发立即执行,等待下次Cron触发频率到达时刻开始按照Cron频率依次执行
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger
                cronTrigger = TriggerBuilder.newTrigger().withIdentity("triggerName", "triggerGroupName").withSchedule(cronScheduleBuilder).build();
        try {
            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public String getJobState(String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(jobName, jobGroup);

        System.out.println(scheduler.getJobKeys(GroupMatcher.anyGroup()));

        return scheduler.getTriggerState(triggerKey).name();
    }


    //暂停所有任务
    @Override
    public void pauseAllJob() throws SchedulerException {
        scheduler.pauseAll();
    }


    //恢复所有任务
    @Override
    public void resumeAllJob() throws SchedulerException {
        scheduler.resumeAll();
    }


    //暂停任务
    @Override
    public String pauseJob(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            return "fail";
        } else {
            scheduler.pauseJob(jobKey);
            return "success";
        }

    }

    // 恢复某个任务
    @Override
    public String resumeJob(String jobName, String jobGroup) throws SchedulerException {

        JobKey jobKey = new JobKey(jobName, jobGroup);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            return "fail";
        } else {
            scheduler.resumeJob(jobKey);
            return "success";
        }
    }
}
