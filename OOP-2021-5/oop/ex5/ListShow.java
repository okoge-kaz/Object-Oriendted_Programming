package oop.ex5;

import java.util.ArrayList;

public class ListShow {
  private ArrayList<String> list;

  public ListShow(ArrayList<String> arg_list) {
    this.list = new ArrayList<String>();
    for (int index = 0; index < arg_list.size(); index++) {
      this.list.add("- " + arg_list.get(index));
    }
  }

  public void show() {
    for (int index = 0; index < list.size(); index++) {
      System.out.println(list.get(index));
    }
  }

  public static void show(ArrayList<String> arg_list) {
    ArrayList<String> list = new ArrayList<String>();
    
    for (int index = 0; index < arg_list.size(); index++) {
      list.add("- " + arg_list.get(index));
    }

    for (int index = 0; index < list.size(); index++) {
      System.out.println(list.get(index));
    }
  }
}
