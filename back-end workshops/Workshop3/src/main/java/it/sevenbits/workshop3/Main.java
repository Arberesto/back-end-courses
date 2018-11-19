package it.sevenbits.workshop3;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Enter full path of directory except last '/' \n");
            Scanner sc = new Scanner(System.in);
//            int c;
//            StringBuilder sb = new StringBuilder();
//            while ((c = System.in.read()) != (int)'\n') {
//                sb.append((char)c);
//            }
            String path = sc.nextLine();
            String testPath = "/home/arcades/IdeaProjects/back-end-courses";
            FileWriter fileWriter = new FileWriter("./lastDir.txt");
            writeFilesInDir(testPath, fileWriter);
//            writeFilesInDir(path);
        } catch (IOException e) {
            System.out.println("Exception: \n" + e.getMessage());
        }
    }

    private static void writeFilesInDir (String path, FileWriter fileWriter) throws IOException {
        File dir = new File(path);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        if (dir.listFiles() != null) {
            int counter = 0;
            for (File i : dir.listFiles()) {
                bWriter.write(i.getName() + ", ");
                if (i.isDirectory()) {
                    bWriter.write(" directory, ");

                } else {
                    bWriter.write(" file, ");
                }
                if (i.canRead()) {
                    bWriter.write(" readable, ");

                } else {
                    bWriter.write(" non-readable, ");
                }
                if (i.canWrite()) {
                    bWriter.write(" writeable, ");

                } else {
                    bWriter.write(" non-writeable, ");
                }
                if (i.canExecute()) {
                    bWriter.write(" executable, ");

                } else {
                    bWriter.write(" non-executable, ");
                }
                bWriter.write(i.getAbsolutePath() + "\n");
                counter++;
                if (counter > 4) {
                    bWriter.flush();
                    counter = 0;
                }
                if (i.isDirectory()) {
                    writeFilesInDir(i.getAbsolutePath(),fileWriter);
                }
            }
            bWriter.flush();
        }
    }
}
