package me.daprian.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task {

    private static final Logger logger = LogManager.getLogger();
    private final String taskName;
    private final Runnable runnable;
    private final TaskMetadata metadata;

    public Task(String taskName, Runnable runnable) {
        this.taskName = taskName;
        this.runnable = runnable;
        this.metadata = new TaskMetadata();
    }

    void Execute(boolean debug) {
        try {
            if (debug) logger.info("Starting " + taskName);
            metadata.setStartTime(System.currentTimeMillis());
            runnable.run();
            metadata.setEndTime(System.currentTimeMillis());
            if (debug) logger.info(String.format("Finished %s in %sms.", taskName, getExecutionTime()));
        }  catch (TaskException e) {
            logger.error(e.getMessage());
            metadata.setError(true);
        }
    }

    public long getExecutionTime() {
        return metadata.getEndTime() - metadata.getStartTime();
    }
}