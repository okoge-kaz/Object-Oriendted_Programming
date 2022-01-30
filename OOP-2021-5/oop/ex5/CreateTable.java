package oop.ex5;
import java.util.ArrayList;

public class CreateTable {
  private final String tableName;
  private ArrayList<String> columnNames;

  public CreateTable(ArrayList<String> data){
    this.tableName = data.get(0);
    this.columnNames = new ArrayList<String>(data.subList(1, data.size()));
  }

  public String getTableName() {
    return this.tableName;
  }

  public ArrayList<String> getColumnNames() {
    return this.columnNames;
  }
}
