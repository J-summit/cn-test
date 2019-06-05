package cn.onlyo.quartzconfig.config;

import cn.onlyo.quartzconfig.listener.JobListTest;
import cn.onlyo.quartzconfig.listener.TriggerListenTest;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;


/**
 * @author onlyo
 * @since 2019/1/10 16:14
 */
@Configuration
public class QuartzConfig {

    @Autowired
    private JobFactory jobFactory;

    @Autowired
    private JobListTest jobListTest;

    @Autowired
    private TriggerListenTest triggerListenTest;

    @Autowired
//    @Qualifier("dataSource")
    private DataSource primaryDataSource;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setJobFactory(jobFactory);
        // factoryBean.setGlobalJobListeners(jobListTest);

        //获取配置属性
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        //创建SchedulerFactoryBean
        factoryBean.setQuartzProperties(propertiesFactoryBean.getObject());
        //使用数据源，自定义数据源
        factoryBean.setDataSource(this.primaryDataSource);
        factoryBean.setJobFactory(jobFactory);
        factoryBean.setWaitForJobsToCompleteOnShutdown(true);//这样当spring关闭时，会等待所有已经启动的quartz job结束后spring才能完全shutdown。
        factoryBean.setOverwriteExistingJobs(false);
        factoryBean.setStartupDelay(1);

        return factoryBean;
    }

    @Bean("scheduler")
    public Scheduler getScheduler() throws SchedulerException, IOException {
        Scheduler scheduler = this.schedulerFactoryBean().getScheduler();
        //  scheduler.getListenerManager().addJobListener(jobListTest, KeyMatcher.keyEquals(new JobKey("jobName", "jobgroupName")));
        // http://www.quartz-scheduler.org/documentation/quartz-2.x/tutorials/tutorial-lesson-07.html

        //  scheduler.getListenerManager().addTriggerListener(triggerListenTest, KeyMatcher.keyEquals(new TriggerKey("triggerName", "triggerGroupName")));

        return scheduler;
    }
}
