package oop.ex5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {

  private HashMap<String, Table> DB;
  private ArrayList<String> TableList;

  private void init() {
    this.DB = new HashMap<String, Table>();// DB init
    this.TableList = new ArrayList<String>();// table's name list init
  }

  private ArrayList<String> getTableNames() {
    return this.TableList;
  }

  public Database() {
    init();
  }

  public void interpret(String commands) {
    Interpreter interpreter = new Interpreter(commands);

    ArrayList<String> objects = interpreter.getObjects();

    switch (interpreter.getOrder()) {
      case "create":
        CreateTable creater = new CreateTable(objects);
        this.TableList.add(creater.getTableName());
        this.DB.put(creater.getTableName(), new Table(creater.getColumnNames()));
        break;
      case "list":
        System.out.println("Table List");
        try {
          ListShow tableList = new ListShow(this.getTableNames());
          tableList.show();
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case "delete":
        String deleteTargetTableName = objects.get(0);
        this.DB.remove(deleteTargetTableName);
        this.TableList.remove(deleteTargetTableName);
        break;
      case "show":
        String showTargetTableName = objects.get(0);
        System.out.println("Table " + showTargetTableName);
        this.DB.get(showTargetTableName).show();
        break;
      case "insert":
        String insertTargetTable = objects.get(0);
        ArrayList<String> insertFieldData = new ArrayList<String>(objects.subList(1, objects.size()));
        this.DB.get(insertTargetTable).insert(insertFieldData);
        break;
      case "remove":
        String removeTargetTable = objects.get(0);
        String removeTargetCoulmn = objects.get(1);
        String removeTargetField = objects.get(2);
        this.DB.get(removeTargetTable).remove(removeTargetCoulmn, removeTargetField);
        break;
      case "update":
        String updateTargetTable = objects.get(0);
        String updateTargetColumnName1 = objects.get(1);
        String updateTargetValue1 = objects.get(2);
        String updateTargetColumnName2 = objects.get(3);
        String updateTargetValue2 = objects.get(4);
        this.DB.get(updateTargetTable).update(updateTargetColumnName1, updateTargetValue1, updateTargetColumnName2,
            updateTargetValue2);
        break;
      case "rename":
        String renameTargetTable = objects.get(0);
        String renameTargetColumn1 = objects.get(1);
        String renameTargetColumn2 = objects.get(2);
        this.DB.get(renameTargetTable).rename(renameTargetColumn1, renameTargetColumn2);
        break;
      case "select":
        String selectTargetTableName1 = objects.get(0);
        String selectTargetColumn = objects.get(1);
        String selectTargetField = objects.get(2);
        String selectTargetTableName2 = objects.get(3);
        ArrayList<HashMap<String, String>> selectMatchObjects = this.DB.get(selectTargetTableName1)
            .select(selectTargetColumn, selectTargetField);
        this.DB.get(selectTargetTableName2).insertHashMap(selectMatchObjects);
        break;
      case "proj":
        String projectionTargetTableName1 = objects.get(0);
        String projectionTargetTableName2 = objects.get(1);
        Table projectionTargetObjects = this.DB.get(projectionTargetTableName1).getTable();
        this.DB.get(projectionTargetTableName2).projInsert(projectionTargetObjects);
        break;
      case "join":
        String joinTargetTableName1 = objects.get(0);
        String joinTargetColumnName1 = objects.get(1);
        String joinTargetTableName2 = objects.get(2);
        String joinTargetColumnName2 = objects.get(3);
        String joinTargetTableName3 = objects.get(4);

        Table table1 = this.DB.get(joinTargetTableName1);
        Table table2 = this.DB.get(joinTargetTableName2);

        this.DB.get(joinTargetTableName3).join(table1, joinTargetColumnName1, table2, joinTargetColumnName2);
        break;
      case "load":
        String loadPath = objects.get(0);
        // System.out.println(loadPath);
        try (FileReader fr = new FileReader(loadPath); BufferedReader bufferedReader = new BufferedReader(fr);) {
          String line;
          while ((line = bufferedReader.readLine()) != null) {
            this.interpret(line);
          }
        } catch (IOException e) {
          System.out.println(e);
        }
        break;
      case "save":
        String savaTargetTableName = objects.get(0);
        String savePath = objects.get(1);
        // System.out.println(savePath);
        this.DB.get(savaTargetTableName).saveCommand(savePath, savaTargetTableName);
        break;
      default:
        System.err.println("invalid command: " + interpreter.getOrder());
        System.exit(1);
    }
  }
}
