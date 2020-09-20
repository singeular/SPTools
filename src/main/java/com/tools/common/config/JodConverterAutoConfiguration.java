package com.tools.common.config;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.local.LocalConverter;
import org.jodconverter.local.office.LocalOfficeManager;
import org.jodconverter.local.office.LocalOfficeManager.Builder;
import org.jodconverter.local.office.LocalOfficeUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({ DocumentConverter.class })
@ConditionalOnProperty(prefix = "jodconverter.local", name = {
	"enabled" }, havingValue = "true", matchIfMissing = false)
@EnableConfigurationProperties({ JodConverterProperties.class })

public class JodConverterAutoConfiguration {

    private JodConverterProperties properties;

    public JodConverterAutoConfiguration(JodConverterProperties properties) {
	this.properties = properties;
    }

    private OfficeManager createOfficeManager() {
	Builder builder = LocalOfficeManager.builder();
	if (!StringUtils.isBlank(this.properties.getPortNumbers())) {
	    Set<Integer> iports = new HashSet<Integer>();
	    String[] portNumbers = StringUtils.split(this.properties.getPortNumbers(), ", ");
	    int portCount = portNumbers.length;

	    for (int i = 0; i < portCount; ++i) {
		String portNumber = portNumbers[i];
		iports.add(NumberUtils.toInt(portNumber, 2002));
	    }

	    builder.portNumbers(ArrayUtils.toPrimitive(iports.toArray(new Integer[iports.size()])));
	}

	String officeHome = LocalOfficeUtils.getDefaultOfficeHome().getPath();
	builder.officeHome(officeHome);
	// builder.officeHome(this.properties.getOfficeHome());
	builder.workingDir(this.properties.getWorkingDir());
	builder.templateProfileDir(this.properties.getTemplateProfileDir());
	builder.killExistingProcess(this.properties.isKillExistingProcess());
	builder.processTimeout(this.properties.getProcessTimeout());
	builder.processRetryInterval(this.properties.getProcessRetryInterval());
	builder.taskExecutionTimeout(this.properties.getTaskExecutionTimeout());
	builder.maxTasksPerProcess(this.properties.getMaxTasksPerProcess());
	builder.taskQueueTimeout(this.properties.getTaskQueueTimeout());
	return builder.build();
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    @ConditionalOnMissingBean
    public OfficeManager officeManager() {
	return this.createOfficeManager();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean({ OfficeManager.class })
    public DocumentConverter jodConverter(OfficeManager officeManager) {
	return LocalConverter.make(officeManager);
    }

}
