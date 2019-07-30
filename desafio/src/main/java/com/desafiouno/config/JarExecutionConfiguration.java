package com.desafiouno.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConfigurationProperties(prefix = "instant.jarexecution")
public class JarExecutionConfiguration {

    private static Logger log = LoggerFactory.getLogger(JarExecutionConfiguration.class.getName());

    private String jarPath;
    private String executableFileName;
    private String jarName;
    private String startErrorMessageJarExecution;
    private String url;
    private String username;
    private String password;

    @PostConstruct
    protected void init() {
        log.info("SE INICIALIZÓ LA CLASE JarExecutionConfiguration CORRECTAMENTE!!");
    }

    public String getJarPath() {
        return jarPath;
    }

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }

    public String getExecutableFileName() {
        return executableFileName;
    }

    public void setExecutableFileName(String executableFileName) {
        this.executableFileName = executableFileName;
    }

    public String getJarName() {
        return jarName;
    }

    public void setJarName(String jarName) {
        this.jarName = jarName;
    }

    @Override
    public String toString() {
        return "JarExecutionConfiguration{" + "jarPath='" + jarPath + '\'' + ", executableFileName='" + executableFileName + '\'' + ", jarName='" + jarName + '\''
            + ", startErrorMessageJarExecution='" + startErrorMessageJarExecution + '\'' + ", url='" + url + '\'' + ", username='" + username + '\'' + ", password='" + password
            + '\'' + '}';
    }
}
