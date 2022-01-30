package oop.ex5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {
  private ArrayList<String> columnNames;
  private ArrayList<HashMap<String, String>> tableData;

  public Table(ArrayList<String> columnNames) {
    this.columnNames = columnNames;
    tableData = new ArrayList<HashMap<String, String>>();
  }

  public void insert(ArrayList<String> fieldData) {
    try{
      HashMap<String, String>tmp = new HashMap<String, String>();
      for(int index=0;index<columnNames.size();index++){
        tmp.put(columnNames.get(index), fieldData.get(index));
      }
      this.tableData.add(tmp);
    }catch(IndexOutOfBoundsException e){
      // call this when fieldData.size() != columnNames.size() 
      e.printStackTrace();
    }
  }

  // primitiveな型でないのでオーバーロードがうまくいかない
  public void insertHashMap(ArrayList<HashMap<String, String>> fieldData) {
    this.tableData.addAll(fieldData);
  }

  public void show() {
    // show column names
    System.out.print("*");
    for(int index=0;index<this.columnNames.size();index++){
      System.out.print(" " + this.columnNames.get(index));
    }
    System.out.println();
    // show field data
    for(int id=0;id<this.tableData.size();id++){
      System.out.print("+");
      for(int index=0;index<this.columnNames.size();index++){
        System.out.print(" " + tableData.get(id).get(columnNames.get(index)));
      }
      System.out.println();
    }
  }

  public void remove(String columnName, String Value) {
    // search by columnName and when the target value is equal to the fieldValue, remove it.
    ArrayList<HashMap<String, String>> tmp = new ArrayList<HashMap<String, String>>();

    for(int id=0;id<this.tableData.size();id++){
      if(this.tableData.get(id).get(columnName).equals(Value)){
        continue;
      }
      tmp.add(tableData.get(id));
    }
    // update
    tableData = tmp;
  }

  public void update(String ColumnName1, String Value1, String ColumnName2, String Value2) {
    for(int id=0;id<this.tableData.size();id++){
      if(this.tableData.get(id).get(ColumnName1).equals(Value1)){
        this.tableData.get(id).put(ColumnName2, Value2);// update
      }
    }
  }

  public void rename(String ColumnName1, String ColumnName2){
    // rename this.tableData
    for(int id=0;id<this.tableData.size();id++){
      final String Value = this.tableData.get(id).get(ColumnName1);
      this.tableData.get(id).remove(ColumnName1);
      this.tableData.get(id).put(ColumnName2, Value);
    }
    // rename this.columnNames
    for(int index=0;index<this.columnNames.size();index++){
      if(this.columnNames.get(index).equals(ColumnName1)){
        this.columnNames.set(index, ColumnName2);
      }
    }
  }

  public ArrayList<HashMap<String, String>> select(String ColumnName, String Value) {
    // need some operation in the Database Class 
    ArrayList<HashMap<String, String>> response = new ArrayList<HashMap<String, String>>();
    for(int id=0;id<this.tableData.size();id++){
      if(this.tableData.get(id).get(ColumnName).equals(Value)){
        response.add(this.tableData.get(id));
      }
    }
    return response;
  }
  
  public void projInsert(Table Objects) {
    for(int id=0;id<Objects.tableData.size();id++){

      HashMap<String, String> tmp = new HashMap<String, String>();
      for(int index=0;index<Objects.columnNames.size();index++){
        // key が一致するかどうか
        if(this.columnNames.contains(Objects.columnNames.get(index))){
          tmp.put(Objects.columnNames.get(index), Objects.tableData.get(id).get(Objects.columnNames.get(index)));
        }
        else{
          System.err.println("key does not match to the target object.");
          System.exit(1);
        }
      }

      this.tableData.add(tmp);
    }
  }

  public Table getTable() {
    // need some operation in the Database Class 
    return this;
  }

  public void saveCommand(String path, String tableName){
    Path targetPath = Paths.get(path);
    System.out.println(path);
    try {
      Files.createFile(targetPath);
    } catch(IOException e){
      e.printStackTrace();
    }
    HashMapShow hashMapShow = new HashMapShow(this.tableData, this.columnNames);
    ArrayList<String> Data = hashMapShow.getSaveData();

    try(BufferedWriter writer = Files.newBufferedWriter(targetPath)){
      writer.write("create " + tableName + " " + Data.get(0));
      writer.newLine();
      for(int index=1;index<Data.size();index++){
        writer.write("insert " + tableName + " " + Data.get(index));
        writer.newLine();
      }
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
