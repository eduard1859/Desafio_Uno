package com.desafiouno.service;

import com.desafiouno.config.JarExecutionConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@Service
public class ExecuteJarService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private final JarExecutionConfiguration jarExecutionConfiguration;

    public ExecuteJarService(JarExecutionConfiguration jarExecutionConfiguration) {
        this.jarExecutionConfiguration = jarExecutionConfiguration;
    }

    public boolean executeCodeAnalysisJar() throws Exception {
        return createAndExecuteBatFile(jarExecutionConfiguration.getJarPath(), jarExecutionConfiguration.getExecutableFileName(),
            jarExecutionConfiguration.getJarName());
    }

    public boolean createAndExecuteBatFile(String jarPath,String ejecutableName,String jarName) throws Exception {
        // Establezco directorio actual
        final String currentDir = System.getProperty("user.dir") + jarPath;
        log.info("jarPath para la operación -> " + currentDir);
        FileWriter fileWriter;
        PrintWriter printWriter;
        try {
            fileWriter = new FileWriter(currentDir + ejecutableName);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println("@echo off");
            printWriter.println("set MIRUTA=%~dp0");
            printWriter.println("cd  %MIRUTA%");
            printWriter.println(
                "java -jar " + jarName);
            fileWriter.close();
            String command = "cmd /c" + "\"" + currentDir + ejecutableName + "\"";
            log.info("Comando a ejecutar -> " + command);
            Process pr = Runtime.getRuntime().exec(command);
            BufferedReader stdOut = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String bufferLine;
            log.info("Reading buffer... ");
            while ((bufferLine = stdOut.readLine()) != null) {
                log.info(bufferLine);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
