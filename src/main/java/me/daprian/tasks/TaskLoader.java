package me.daprian.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TaskLoader {
    private static final Logger logger = LogManager.getLogger();
    private final List<Task> tasks = new ArrayList<>();

    public void scanTasks(Object obj) {
        for (java.lang.reflect.Method method : obj.getClass().getMethods()) {
            if (method.isAnnotationPresent(Tasked.class)) {
                Tasked taskAnnotation = method.getAnnotation(Tasked.class);
                String taskName = taskAnnotation.taskName();
                Runnable taskAction = () -> {
                    try {
                        method.invoke(obj);
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }
                };
                tasks.add(new Task(taskName, taskAction));
            }
        }
    }

    public void executeTasks(boolean debug) {
        for (Task task : tasks) {
            task.Execute(debug);
        }
    }
}