package cn.onlyo;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


public class MyJob implements Job {

    public MyJob() {
    }

    /**
     * 实现quartz的Job接口,重写execute方法
     *
     * @param context
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.err.println("Hello World!  MyJob is executing.");
    }

    /**
     * quartz helloword
     * 官方demo
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // 获取对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.start();
        // 可执行的调度程序
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .build();

        // 定义触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(15)
                        .repeatForever())
                .build();

        // 设置
        scheduler.scheduleJob(job, trigger);
    }
}
    