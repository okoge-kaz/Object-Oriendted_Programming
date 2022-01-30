package oop.ex5;
import java.util.HashMap;
import java.util.ArrayList;

public class Database {

  private HashMap<String, Table> DB;
  private ArrayList<String>TableList;

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

    ArrayList<String>objects = interpreter.getObjects();

    switch(interpreter.getOrder()) {
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
        }catch(Exception e){
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
        this.DB.get(updateTargetTable).update(updateTargetColumnName1, updateTargetValue1, updateTargetColumnName2, updateTargetValue2);
        break;
      case "rename":
        String renameTargetTable = objects.get(0);
        String renameTargetColumn1 = objects.get(1);
        String renameTargetColumn2 = objects.get(2);
        this.DB.get(renameTargetTable).rename(renameTargetColumn1, renameTargetColumn2);
        break;
      case "select":
        break;
      case "proj":
        break;
      case "join":
        break;
      case "load":
        break;
      case "save":
        break;
      default:
        System.err.println("invalid command: " + interpreter.getOrder());
        System.exit(1);
    }
  }
}
