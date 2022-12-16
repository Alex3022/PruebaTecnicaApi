package co.com.sofka.utils.database;

public class SqlTemplate {

    public static String getTable (String nametable ){

        String query = "SELECT * FROM %s";
         return String.format(query,nametable);



    }
}
