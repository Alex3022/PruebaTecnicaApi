package co.com.sofka.utils;


import co.com.sofka.model.Category;
import co.com.sofka.model.RenponseAddpet;
import co.com.sofka.model.Tag;
import co.com.sofka.utils.database.ConnectSQLite;

import java.sql.ResultSet;
import java.util.ArrayList;


public class DataManager {

    public static RenponseAddpet getDataPet(){


        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(new Tag(0,"perritos lindos"));
        ArrayList<String> urls = new ArrayList<>();
        urls.add("none");

        return RenponseAddpet.builder()
                .id(ConnectSQLite.selectId())
                .name(ConnectSQLite.selectName())
                .status(ConnectSQLite.selectStatus())
                .tags(tags)
                .category(new Category(0,"perros"))
                .photoUrls(urls)
                .build();
    }

    public static long getIdPet(){
        return ConnectSQLite.selectId();
    }


    public static String getStatus(){ return  "sold";}
}
