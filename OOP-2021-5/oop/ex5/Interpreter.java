package oop.ex5;

import java.util.ArrayList;
import java.util.Arrays;

public class Interpreter {
  private String order;
  private ArrayList<String> objects;

  public Interpreter(String line) {
    this.objects = new ArrayList<String>();// init
    String[] commands = line.split(" ");// 空白区切り
    ArrayList<String> commandList = new ArrayList<String>(Arrays.asList(commands));// Array -> ArrayList
    final int SIZE = commandList.size();// get size

    this.order = commandList.get(0);
    for (int index = 1; index < SIZE; index++) {
      objects.add(commandList.get(index));
    } // slice [1:]と同様の操作
  }

  public String getOrder() {
    return this.order;
  }

  public ArrayList<String> getObjects() {
    return this.objects;
  }
}
