package com.example.teacher_moderatorrating;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private Teacher teachermodel;
    private Admin adminmodel;
    private Student studentmodel;
    private static final String DB_NAME="rating.db";
    private static final int VERSION=1;
    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE admin(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT,password TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT,password TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE teacher(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT,school TEXT,description TEXT,url TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS student");
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS admin");
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS teacher");
        onCreate(sqLiteDatabase);

    }

    public long addStudent(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user);
        values.put("password", password);
        long res = db.insert("student", null, values);
        db.close();
        return res;
    }

    public boolean checkStudent(String username, String password) {

        String[] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = "username" + "=?" + "and " + "password" + "=?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("student", columns, selection, selectionArgs, null, null, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public long addAdmin(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user);
        values.put("password", password);
        long res = db.insert("admin", null, values);
        db.close();
        return res;
    }

    public boolean checkAdmin(String username, String password) {

        String[] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = "username" + "=?" + "and " + "password" + "=?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("admin", columns, selection, selectionArgs, null, null, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public long addTeacher(String user, String school,String descriptio,String url) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user);
        values.put("school", school);
        values.put("description", descriptio);
        values.put("url", url);
        long res = db.insert("teacher", null, values);
        db.close();
        return res;
    }





    ///////////////////////////////////////////////////

//    public boolean addTeacher(Teacher teacher)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name",teacher.getName());
//        contentValues.put("school",teacher.getSchool());
//        contentValues.put("description",teacher.getDescription());
//        contentValues.put("url",teacher.getUrl());
//
//        long addedteacher = db.insert("teacher",null,contentValues);
//
//        if(addedteacher==-1){
//            return false;
//        }
//        else {
//            return true;
//        }
//    }

    public ArrayList<Teacher> getAllteachers()
    {
        ArrayList<Teacher> teacherslist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String sql ="SELECT * FROM teacher";

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("username"));
                String school = cursor.getString(cursor.getColumnIndex("school"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                String url = cursor.getString(cursor.getColumnIndex("url"));

                teachermodel = new Teacher(id,name,school,description,url);
                teacherslist.add(teachermodel);

            }while (cursor.moveToNext());
        }
        else {

        }
        cursor.close();
        db.close();
        return teacherslist;
    }

    public boolean deleteTeacher(Teacher teacher)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "DELETE FROM teacher WHERE id = "+ teacher.getId();

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean updateTeacher(Teacher teacher)
    {
        String sql ="UPDATE teacher SET name = "+teacher.getName()+",school = "+teacher.getSchool()+"," +
                "description ="+teacher.getDescription()+"url = "+teacher.getUrl()+"WHERE id ="+teacher.getId();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst())
        {
            return true;
        }
        else {
            return false;
        }

    }

    public boolean addAdmin(Admin admin)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("email",admin.getEmail());
        values.put("password",admin.getPassword());

        long admin1 = db.insert("admin", null, values);

        if(admin1==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean updateAdmin(Admin admin)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "UPDATE admin SET email =" + admin.getEmail() +",password = "+ admin.getPassword() +"WHERE " +
                "id ="+ admin.getId();

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<Admin> getAdmin()
    {
        ArrayList<Admin> adminArrayList = new ArrayList<>();
        String sql = "SELECT * FROM admin";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String email=cursor.getString(cursor.getColumnIndex("email"));
                String password=cursor.getString(cursor.getColumnIndex("password"));

                adminmodel = new Admin(id,email,password);
                adminArrayList.add(adminmodel);
            }while (cursor.moveToNext());
        }
        else {

        }
        cursor.close();
        db.close();
        return  adminArrayList;
    }

//    public boolean addStudent(String username,String password)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put("email",username);
//        values.put("password",password);
//
//        long student1 = db.insert("student", null, values);
//
//        if(student1==-1){
//            return false;
//        }
//        else {
//            return true;
//        }
//    }

    public ArrayList<Student> getStudent(String username,String password)
    {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "SELECT email,password FROM student";
        String sql = "SELECT * FROM student WHERE username = "+username +"AND password = "+password;

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
//                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String passw = cursor.getString(cursor.getColumnIndex("password"));

                studentmodel=new Student(email,passw);
                studentArrayList.add(studentmodel);
            }while (cursor.moveToNext());
        }
        else {

        }
        cursor.close();
        db.close();
        return studentArrayList;
    }

//    public boolean checkstudent(String mail,String passw)
//    {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String selection = "email ="+"?" + " and password"+" =?";
//        String[] selectionArg= {mail,passw};
//
//        Cursor cursor= db.query("student",null,selection,selectionArg,null,null,null);
//        int count = cursor.getCount();
//        cursor.close();
//        db.close();
//
//        if(count>0){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }


}
