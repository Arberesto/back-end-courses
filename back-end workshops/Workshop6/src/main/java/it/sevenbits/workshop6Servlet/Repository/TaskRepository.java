package it.sevenbits.workshop6Servlet.Repository;

import java.util.HashMap;
import java.util.Set;

public class TaskRepository {
    private static TaskRepository instance;
    private HashMap<Integer,String> tasks;
    private static Integer nextId;

    private TaskRepository(){
        tasks = new HashMap<Integer, String>();
        tasks.put(1,"First task");
        tasks.put(2,"Third task");
    }

    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }

    public int add(String value) {
        synchronized (this) {
            nextId = getNextId();
            tasks.put(nextId,value);
            return nextId;
        }
    }

    public String get(int id) {
        synchronized (this) {
            return tasks.get(id);
        }
    }

    public int delete(int id) {
        synchronized (this) {
            if (tasks.containsKey(id)) {
                tasks.remove(id);
                return id;
            }
            return -1;
        }
    }

    public boolean contains(int id) {
        synchronized (this) {
        return tasks.containsKey(id);
        }
    }

    public Set<Integer> getIdList() {
        synchronized (this) {
            return tasks.keySet();
        }
    }

    private int getNextId() {
        if (nextId == null) {
            return 3;
        }
        return nextId + 1;
    }
}
