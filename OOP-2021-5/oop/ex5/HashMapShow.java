package oop.ex5;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapShow {
  private ArrayList<String> response;

  public HashMapShow(ArrayList<HashMap<String, String>> tableData, ArrayList<String> columnNames) {
    response = new ArrayList<>();
    String createTargetString = "";
    for (int index = 0; index < columnNames.size(); index++) {
      createTargetString += columnNames.get(index) + " ";
    }
    response.add(createTargetString);

    for (int index = 0; index < tableData.size(); index++) {
      String tmpValueData = "";
      for (int id = 0; id < columnNames.size(); id++) {
        tmpValueData += tableData.get(index).get(columnNames.get(id)) + " ";
      }
      response.add(tmpValueData);
    }
  }

  public ArrayList<String> getSaveData() {
    return this.response;
  }
}
