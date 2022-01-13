package oop.ex36;
import java.util.ArrayList;
import java.util.Collections;

public class TaskList {
  private ArrayList<Task> taskList;

  public TaskList() {
    taskList = new ArrayList<>();
  }
  public void addTask(Task task) {
    this.taskList.add(task);
  }
  public void printList() {
    Collections.sort(this.taskList);
    System.out.println("Task list");
    int cnt = 1;
    for(Task task : this.taskList){
      System.out.println(cnt + ": " + task.toString());
      cnt++;
    }
  }
  public boolean removeTask(int index){
    final int SIZE = this.taskList.size();
    if(index <= 0 || index > SIZE){
      return false;
    }
    this.taskList.remove(index-1);
    return true;
  }
}
