package com.example.end;

public class mord_or_amal {
    String name_amel;
    int id_amal;
    public mord_or_amal(String name_amel,int id_amal){
        this.name_amel=name_amel;
        this.id_amal=id_amal;

    }

    public String getName_amel() {
        return name_amel;
    }
    public void setName_amel(String  name_amel){this.name_amel=name_amel;}
    public int getId_amal(){return id_amal;}
    public void setId_amal(int id_amal){this.id_amal=id_amal;}
}
