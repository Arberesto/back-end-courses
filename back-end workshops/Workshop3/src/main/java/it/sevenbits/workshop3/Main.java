package it.sevenbits.workshop3;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            System.out.println("Enter full path of directory except last '/' \n");
            Scanner sc = new Scanner(System.in);
            String path = sc.nextLine();
            String resultPath = "./lastDir.txt";
//            String path = "/home/arcades/IdeaProjects/back-end-courses";
            Dir(path, resultPath);
    }

    private static void Dir(String dirPath, String resultPath) {
        try(BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultPath),
                Charset.forName("utf-8")))) {
            writeFilesInDir(dirPath, fileWriter);
        } catch (IOException e) {
            System.out.println("Exception: \n" + e.getMessage());
        }
    }

    private static void writeFilesInDir (String path, BufferedWriter fileWriter) throws IOException {
        File dir = new File(path);
        if (dir.listFiles() != null) {
            int counter = 0;
            for (File i : dir.listFiles()) {
                fileWriter.write(i.getName() + ", ");
                if (i.isDirectory()) {
                    fileWriter.write(" directory, ");

                } else {
                    fileWriter.write(" file, ");
                }
                if (i.canRead()) {
                    fileWriter.write(" readable, ");

                } else {
                    fileWriter.write(" non-readable, ");
                }
                if (i.canWrite()) {
                    fileWriter.write(" writeable, ");

                } else {
                    fileWriter.write(" non-writeable, ");
                }
                if (i.canExecute()) {
                    fileWriter.write(" executable, ");

                } else {
                    fileWriter.write(" non-executable, ");
                }
                fileWriter.write(i.getAbsolutePath() + "\n");
                counter++;
                if (counter > 4) {
                    fileWriter.flush();
                    counter = 0;
                }
                if (i.isDirectory()) {
                    writeFilesInDir(i.getAbsolutePath(),fileWriter);
                }
            }
            fileWriter.flush();
        }
    }
}
