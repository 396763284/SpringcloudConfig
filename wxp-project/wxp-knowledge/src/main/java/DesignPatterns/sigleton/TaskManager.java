package DesignPatterns.sigleton;

public class TaskManager {
    private static TaskManager taskManager=null;
    public static TaskManager getTaskManager(){
        if(taskManager==null){
            taskManager=new TaskManager();
        }
        return taskManager;
    }
}
