package com.lwl.sc.di.scope;

import com.amazonaws.services.ecs.model.Task;

public class TaskManager {

    private static volatile TaskManager obj;
    private TaskManager(){

    }
    public static TaskManager getInstance(){
      if(obj==null) {
        synchronized (TaskManager.class) {
          if (obj == null) {
            obj = new TaskManager();
          }
        }
      }
      return obj;
    }
}
