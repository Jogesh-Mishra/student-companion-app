package com.example.studentcompanionapp;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Filehelper {
    public static  final String FILENAME = "temp.dat";

    public  static void writeData(ArrayList<String> items, Context context) {

        try {
            FileOutputStream fos =context.openFileOutput(FILENAME, context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static  ArrayList<String> readData(Context context){
        ArrayList<String> itemlist =null;
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemlist = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {

            itemlist = new ArrayList<>();

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itemlist;
    }
}
