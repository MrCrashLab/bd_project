package test.Requests;

public class UpdateModel {
    private int id;
    private String str;
    private String column;
    private String table;

    public UpdateModel(int id, String str, String column, String table) {
        this.id = id;
        this.str = str;
        this.column = column;
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
