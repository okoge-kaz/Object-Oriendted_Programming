package oop.ex36;

public class Task implements Comparable<Task> {
  private final int priority;
  private final String taskName;

  public int compareTo(Task task) {
    if(this.priority < task.priority){
      return -1;
    }
    else if(this.priority == task.priority){
      return this.taskName.compareTo(task.taskName);
    }
    else return 1;
  }
  public Task(int priority, String taskName) {
    this.priority = priority;
    this.taskName = taskName;
  }
  @Override
  public String toString() {
    return this.priority + " " + this.taskName;
  }
}
