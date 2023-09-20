package me.daprian.tasks;

public class TaskMetadata {
    private long startTime;
    private long endTime;
    private boolean isError;

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setError(boolean isError) {
        this.isError = isError;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public boolean isError() {
        return isError;
    }
}