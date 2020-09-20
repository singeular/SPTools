package com.tools.common.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("jodconverter.local")
public class JodConverterProperties {

    private boolean enabled;
    private String officeHome;
    private String portNumbers = "2002";
    private String workingDir;
    private String templateProfileDir;
    private boolean killExistingProcess = true;
    private long processTimeout = 120000L;
    private long processRetryInterval = 250L;
    private long taskExecutionTimeout = 120000L;
    private int maxTasksPerProcess = 200;
    private long taskQueueTimeout = 30000L;

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public String getOfficeHome() {
	return officeHome;
    }

    public void setOfficeHome(String officeHome) {
	this.officeHome = officeHome;
    }

    public String getPortNumbers() {
	return portNumbers;
    }

    public void setPortNumbers(String portNumbers) {
	this.portNumbers = portNumbers;
    }

    public String getWorkingDir() {
	return workingDir;
    }

    public void setWorkingDir(String workingDir) {
	this.workingDir = workingDir;
    }

    public String getTemplateProfileDir() {
	return templateProfileDir;
    }

    public void setTemplateProfileDir(String templateProfileDir) {
	this.templateProfileDir = templateProfileDir;
    }

    public boolean isKillExistingProcess() {
	return killExistingProcess;
    }

    public void setKillExistingProcess(boolean killExistingProcess) {
	this.killExistingProcess = killExistingProcess;
    }

    public long getProcessTimeout() {
	return processTimeout;
    }

    public void setProcessTimeout(long processTimeout) {
	this.processTimeout = processTimeout;
    }

    public long getProcessRetryInterval() {
	return processRetryInterval;
    }

    public void setProcessRetryInterval(long processRetryInterval) {
	this.processRetryInterval = processRetryInterval;
    }

    public long getTaskExecutionTimeout() {
	return taskExecutionTimeout;
    }

    public void setTaskExecutionTimeout(long taskExecutionTimeout) {
	this.taskExecutionTimeout = taskExecutionTimeout;
    }

    public int getMaxTasksPerProcess() {
	return maxTasksPerProcess;
    }

    public void setMaxTasksPerProcess(int maxTasksPerProcess) {
	this.maxTasksPerProcess = maxTasksPerProcess;
    }

    public long getTaskQueueTimeout() {
	return taskQueueTimeout;
    }

    public void setTaskQueueTimeout(long taskQueueTimeout) {
	this.taskQueueTimeout = taskQueueTimeout;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
