package users;

import business.Business;
import business.Task;
import business.TaskList;
import business.management.CheckInOutEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * worker class extends the class and has additional fields and methods for persons who work at the business
 * @author NAME
 * @version 1.0
 */

public class Worker extends Person {
    private ArrayList<CheckInOutEvent> workerTimeLog;
    private TaskList taskList;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private Business business;

    public Worker (String fullName){
        super(fullName);
        this.taskList = new TaskList();
        this.workerTimeLog = new ArrayList<>();

    }
    public Business getBusiness() {
        return business;
    }
    public void setBusiness(Business business) {
        this.business = business;
    }

    @Override
    public String toString() {
        return fullName;
    }

    public TaskList getTaskList() {
        return taskList;
    }
    public void addToTaskList(Task task) {
        this.taskList.addTask(task);
    }

    public ArrayList<CheckInOutEvent> getWorkerTimeLog() {
        return workerTimeLog;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void addCheckInOutEvent(CheckInOutEvent event) {
        this.workerTimeLog.add(event);
    }
}