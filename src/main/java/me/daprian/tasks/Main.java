package me.daprian.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public Main() {
        TaskLoader taskLoader = new TaskLoader();
        taskLoader.scanTasks(this);
        taskLoader.executeTasks(true);
    }

    @Tasked(taskName = "Example Task")
    public void Example() {
        logger.info("Example task works!");
    }

    public static void main(String[] args) {
        new Main();
    }
}