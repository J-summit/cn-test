package cn.onlyo.quartzconfig.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.springframework.stereotype.Component;

/**
 * @author onlyo
 * @since 2019/1/14 20:06
 */
@Component("triggerListenTest")
public class TriggerListenTest implements TriggerListener {
    @Override
    public String getName() {
        return "TriggerListener";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {

    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {

    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        System.out.println("TriggerListener监听：" + context.getJobDetail().getKey());

    }
}
