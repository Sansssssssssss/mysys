package com.mysys.quartz.util;

import com.mysys.quartz.domain.SysJob;
import org.quartz.JobExecutionContext;

/**
 * 定时任务处理（允许并发执行）
 */
public class QuartzJobExecution extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context,
                             SysJob sysJob) throws Exception {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
