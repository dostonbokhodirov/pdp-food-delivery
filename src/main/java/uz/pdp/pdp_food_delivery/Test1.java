package uz.pdp.pdp_food_delivery;

import java.io.File;

public class Test1 {
    public static void main(String[] argv) throws Exception
    {
        // Create an object of the File class
        // Replace the file path with path of the directory
        File directory = new File("D:");

        // store all names with same name
        // with/without extension
        String[] flist = directory.list();
        int flag = 0;
        if (flist == null) {
            System.out.println("Empty directory.");
        }
        else {

            for (String filename : flist) {
                if (filename.startsWith("rest-crud.rar")) {
                    System.out.println(filename + " found");
                    flag = 1;
                }
            }
        }

        if (flag == 0) {
            System.out.println("File Not Found");
        }
    }
}
