package com.example.end;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Calendar;


public class Database extends SQLiteOpenHelper {
    public static final String Db_name = "Data.db";

    public Database(Context context) {
        super(context, Db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users ( user_id INTEGER PRIMARY KEY AUTOINCREMENT , user_name_all TEXT  , user_phone Integer , user_name TEXT  , user_pass TEXT  )");
        db.execSQL("CREATE TABLE Product(product_id INTEGER PRIMARY KEY AUTOINCREMENT ,name_product TEXT, barcode TEXT,quantity INTEGER,price_purchase INTEGER,price_sale INTEGER,description TEXT,rating TEXT)");

        db.execSQL("CREATE TABLE Mord(id_mord INTEGER PRIMARY KEY ,name_mord TEXT, address_mord TEXT,phone_mord INTEGER,mlahdh_mored TEXT )");
        db.execSQL("CREATE TABLE amal(id_amal INTEGER PRIMARY KEY ,name_amal TEXT, address_amal TEXT,phone_amal INTEGER,mlahdh_amal TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS Product");
        db.execSQL("DROP TABLE IF EXISTS Mord");
        db.execSQL("DROP TABLE IF EXISTS amal");

        onCreate(db);


    }
//**********************************************************************
    //داله اضافه المستخدم

    public boolean insertdata(String user_name_all, int user_phone, String user_name, String user_pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        Calendar cc = Calendar.getInstance();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_name_all", user_name_all);
        contentValues.put("user_phone", user_phone);
        contentValues.put("user_name", user_name);
        contentValues.put("user_pass", user_pass);


        long res = db.insert("users", null, contentValues);
        if (res == -1)
            return false;
        else
            return true;
    }

    //**********************************تسجيل الدخول
    public boolean logen(String us, String pass) {


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from users where user_name=? and user_pass=? ", new String[]{us, pass});

        if (res.getCount() > 0)
            return true;
        else
            return false;

    }

    //القائمة الذي تظهر
    // ***************************************************
    public ArrayList<student> getAllData() {
        ArrayList<student> arrayList = new ArrayList<student>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Product", null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            String name_product = cursor.getString(1);
            int quantity = cursor.getInt(3);
            int price_sale = cursor.getInt(5);
            student student = new student(name_product, quantity, price_sale);
            arrayList.add(student);
            cursor.moveToNext();
        }
        return arrayList;
    }

    //قائمة الاسماء عند الاضافه للبيع
    public ArrayList<String> getAlData() {
        ArrayList<String> arrayList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Product", null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            String name_product = cursor.getString(1);


            arrayList.add(name_product);
            cursor.moveToNext();
        }
        return arrayList;
    }

    //داله اضافه المنتجات الى المخازن اي الاضافه الى قاعد البيانات
    //********************************************************************************************

    public boolean save_product(String name_product, String barcode, int quantity, int price_purchase, int price_sale, String description, String rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name_product", name_product);
        contentValues.put("barcode", barcode);
        contentValues.put("quantity", quantity);
        contentValues.put("price_purchase", price_purchase);
        contentValues.put("price_sale", price_sale);
        contentValues.put("description", description);
        contentValues.put("rating", rating);

        long result = db.insert("Product", null, contentValues);
        if (result == -1)

            return false;

        else
            return true;

    }

    //********************************************************************************************
    // داله العرض عند الضفط على عنصر في القائمة المنتج
    public String[] getAll(String name) {
        String[] t3 = new String[10];
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from Product where name_product like '" + name + "' ", null);
        res.moveToFirst();
        t3[0] = res.getString(res.getColumnIndex("name_product"));
        t3[1] = res.getString(res.getColumnIndex("barcode"));
        t3[2] = res.getString(res.getColumnIndex("quantity"));
        t3[3] = res.getString(res.getColumnIndex("price_purchase"));
        t3[4] = res.getString(res.getColumnIndex("price_sale"));
        t3[5] = res.getString(res.getColumnIndex("description"));
        t3[6] = res.getString(res.getColumnIndex("rating"));
        t3[7] = res.getString(res.getColumnIndex("product_id"));

        res.close();
        return t3;


    }

    //********************************************************************************************
    //داله التعديل على المنتج ككل *********************
    public boolean Update_up(String name_back, String name_product, String barcode, int quantity, int price_purchase, int price_sale, String description, String rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name_product", name_product);
        contentValues.put("barcode", barcode);
        contentValues.put("quantity", quantity);
        contentValues.put("price_purchase", price_purchase);
        contentValues.put("price_sale", price_sale);
        contentValues.put("description", description);
        contentValues.put("rating", rating);
        db.update("Product", contentValues, "name_product=?", new String[]{name_back});

        return true;
    }

    //********************************************************************************************
    //داله التعديل على سعر وكميه *********************
    public boolean Update(String name_product, int quantity, int price_sale) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("quantity", quantity);
        contentValues.put("price_sale", price_sale);
        db.update("Product", contentValues, "name_product=?", new String[]{name_product});
        return true;
    }

    //******************************************************************************************
    //داله الحذف للمستخدم
    public Integer deletedate(String user_name_all) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Product", "name_product=?", new String[]{user_name_all});
    }

    //*****************************************************************
    // فاتوره المبيعات
    public String[] getAllercordtext(String rel) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] Z = new String[2];
        Cursor cursor = db.rawQuery("select * from Product where barcode like '" + rel + "' ", null);
        cursor.moveToFirst();
        Z[0] = cursor.getString(1);
        Z[1] = cursor.getString(5);

        cursor.close();


        return Z;

    }

    public String[] getAllercordtextname(String rel) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] Z = new String[2];
        Cursor cursor = db.rawQuery("select * from Product where name_product like '" + rel + "' ", null);
        cursor.moveToFirst();
        Z[0] = cursor.getString(1);
        Z[1] = cursor.getString(5);

        cursor.close();


        return Z;

    }

    //**********************************************************************
    //عند الضغط على الحفظ في البيع
    public void ALL(ArrayList<student> s) {

        SQLiteDatabase db = this.getWritableDatabase();
        int h, v, y;
        for (int i = 0; i < s.size(); i++) {
            Cursor cursor = db.rawQuery("select * from Product where name_product like '" + s.get(i).getName_product() + "' ", null);
            cursor.moveToFirst();
            h = s.get(i).getQuantity();
            v = cursor.getInt(3);
            y = v - h;
            if (y < 0) {
                y = 0;
            }
            cursor.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put("quantity", y);
            db.update("Product", contentValues, "name_product=?", new String[]{s.get(i).getName_product()});

        }


    }
    //************************************************************************************

    //****************************************فاتوره البيع عند الاضافه
    /*public String[] getAll(String name) {
        String[] t3 = new String[10];
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from Product where name_product like '" + name + "' ", null);
        res.moveToFirst();
        t3[0]=res.getString(res.getColumnIndex("name_product"));
        t3[1]=res.getString(res.getColumnIndex("barcode"));
        t3[2]=res.getString(res.getColumnIndex("quantity"));
        t3[3]=res.getString(res.getColumnIndex("price_purchase"));
        t3[4]=res.getString(res.getColumnIndex("price_sale"));
        t3[5]=res.getString(res.getColumnIndex("description"));
        t3[6]=res.getString(res.getColumnIndex("rating"));
        t3[7]=res.getString(res.getColumnIndex("product_id"));

        res.close();
        return t3;


    }*/
    //داله التاكد هل المنتج موجود ام لا **************************
    public boolean serch_alb(String us) {


        SQLiteDatabase db = this.getReadableDatabase();
        // Cursor res = db.rawQuery("select * from Product where name_product=? or barcode=? ", new String[]{us,us});
        Cursor res = db.rawQuery("select * from Product where barcode=? ", new String[]{us});
        if (res.getCount() > 0)
            return true;
        else
            return false;

    }

    public boolean serch_alba(String us) {


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from Product where name_product=? ", new String[]{us});

        if (res.getCount() > 0)
            return true;
        else
            return false;

    }
    //*****************************************************************

    //****************داله التعديل عند الشراء
    public boolean Update_alb(String name_product, int quantity, int price_purchase, int price_sale) {
        SQLiteDatabase db = this.getWritableDatabase();
        int x;
        Cursor cursor = db.rawQuery("select * from Product where name_product like '" + name_product + "' ", null);
        cursor.moveToFirst();
        x = cursor.getInt(3);
        x = x + quantity;
        cursor.close();
        ContentValues contentValues = new ContentValues();
        contentValues.put("quantity", x);
        contentValues.put("price_purchase", price_purchase);
        contentValues.put("price_sale", price_sale);
        db.update("Product", contentValues, "name_product=?", new String[]{name_product});
        return true;
    }

    //*************************************************************
    // القائمة الذي تظهر الموردين وكذالك العملاء
    public ArrayList<mord_or_amal> getAllData_m() {
        ArrayList<mord_or_amal> arrayList = new ArrayList<mord_or_amal>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Mord", null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            String name_m = cursor.getString(1);
            int id_m = cursor.getInt(0);

            mord_or_amal mmm = new mord_or_amal(name_m, id_m);
            arrayList.add(mmm);
            cursor.moveToNext();
        }
        return arrayList;
    }
    //*************************************************

    public ArrayList<mord_or_amal> getAllData_a() {
        ArrayList<mord_or_amal> arrayList = new ArrayList<mord_or_amal>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM amal", null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            String name_m = cursor.getString(1);
            int id_m = cursor.getInt(0);

            mord_or_amal mmm = new mord_or_amal(name_m, id_m);
            arrayList.add(mmm);
            cursor.moveToNext();
        }
        return arrayList;
    }

    //*********************************************************************
    //*داله اضافه الموردين
    public boolean save_m(int id_mord, String name_mord, String address_mord, int phone_mord, String mlahdh_mored) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("id_mord", id_mord);
        contentValues.put("name_mord", name_mord);
        contentValues.put("address_mord", address_mord);
        contentValues.put("phone_mord", phone_mord);
        contentValues.put("mlahdh_mored", mlahdh_mored);

        long result = db.insert("Mord", null, contentValues);
        if (result == -1)

            return false;

        else
            return true;

    }
    public boolean save_a(int id_mord, String name_mord, String address_mord, int phone_mord, String mlahdh_mored) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("id_amal", id_mord);
        contentValues.put("name_amal", name_mord);
        contentValues.put("address_amal", address_mord);
        contentValues.put("phone_amal", phone_mord);
        contentValues.put("mlahdh_amal", mlahdh_mored);

        long result = db.insert("amal", null, contentValues);
        if (result == -1)

            return false;

        else
            return true;

    }

//****************************************************************************
    //********************************************************************
    //عند الضغط على العميل او المورد
public String[] getAllmord(int rel) {
    SQLiteDatabase db = this.getReadableDatabase();

    String[] Z = new String[5];
    Cursor cursor = db.rawQuery("select * from Mord where id_mord ='"+ rel + "' ", null);
    cursor.moveToFirst();
    Z[0] = cursor.getString(0);
    Z[1] = cursor.getString(1);
    Z[2] = cursor.getString(2);
    Z[3] = cursor.getString(3);
    Z[4] = cursor.getString(4);

    cursor.close();


    return Z;

}
    public String[] getAllamal(int rel) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] Z = new String[5];
        Cursor cursor = db.rawQuery("select * from amal where id_amal ='"+ rel + "' ", null);
        cursor.moveToFirst();
        Z[0] = cursor.getString(0);
        Z[1] = cursor.getString(1);
        Z[2] = cursor.getString(2);
        Z[3] = cursor.getString(3);
        Z[4] = cursor.getString(4);

        cursor.close();


        return Z;

    }
    //********************************************************

    //دوال التعديل والحذف للمورد والعميل

    public boolean Update_m(int id_mord, String name_mord, String address_mord, int phone_mord, String mlahdh_mored) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name_mord", name_mord);
        contentValues.put("address_mord", address_mord);
        contentValues.put("phone_mord", phone_mord);
        contentValues.put("mlahdh_mored", mlahdh_mored);
        db.update("Mord", contentValues, "id_mord=?", new String[]{String.valueOf(id_mord)});

        return true;
    }
    public boolean Update_a(int id_mord, String name_mord, String address_mord, int phone_mord, String mlahdh_mored) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name_amal", name_mord);
        contentValues.put("address_amal", address_mord);
        contentValues.put("phone_amal", phone_mord);
        contentValues.put("mlahdh_amal", mlahdh_mored);
        db.update("amal", contentValues, "id_amal=?", new String[]{String.valueOf(id_mord)});

        return true;
    }

    public Integer delete_m(int i) {
        SQLiteDatabase db = this.getWritableDatabase();
            return db.delete("Mord", "id_mord=?", new String[]{String.valueOf(i)});
    }
    public Integer delete_a(int i) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("amal", "id_amal=?", new String[]{String.valueOf(i)});
    }
    //******************************************************************************************
    //*****************************************************************************************
    //القائمة الذي ستضهر في الفارقمنت

   /* public ArrayList<catgre> getAllData_far() {
        ArrayList<catgre> arrayList = new ArrayList<catgre>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Mord", null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            String name_m = cursor.getString(1);
            String id_m = cursor.getString(2);

            catgre mmm = new catgre(name_m, id_m);
            arrayList.add(mmm);
            cursor.moveToNext();
        }
        return arrayList;in
    }*/
   //لحساب مجموع قيم العمود
   public int getSUM() {
       SQLiteDatabase db = this.getReadableDatabase();



       Cursor cursor = db.rawQuery("select Sum(quantity) as suum from Product  ", null);
       int Z=cursor.getColumnIndex("suum");
       cursor.moveToFirst();
       int c=cursor.getInt(Z);
       cursor.close();


       return c;

   }





}
