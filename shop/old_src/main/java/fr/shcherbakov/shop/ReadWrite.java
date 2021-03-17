package fr.shcherbakov.shop;

import fr.shcherbakov.shop.Model.Client;

import java.io.*;
import java.nio.file.*;


public class ReadWrite {

    public static void main(String[] args) throws IOException {
        //IO operations
        Path source = Paths.get("/Shop-on-JavaEE/source.txt");
        Path target = Paths.get("/Shop-on-JavaEE/target.txt");
        if (!Files.exists(source)) {
            Files.createFile(source);
        }
        if (!Files.exists(target)) {
            Files.createFile(target);
        }

        FileWriter fileWriter = new FileWriter(source.toString());
        fileWriter.write("This is initial string");
        fileWriter.close();

        FileReader fileReader = new FileReader(source.toString());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = bufferedReader.readLine();

        fileWriter = new FileWriter(target.toString());
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(string);
        printWriter.println("This line is only in target.txt");
        printWriter.close();
        bufferedReader.close();

        //serialization
        Client client = new Client();
        Path path = Paths.get("/Shop-on-JavaEE/client.data");
        serialization(client, path);
        deserialization(path);
    }


    private static void serialization(Object obj, Path path) {
        try {
            if (!Files.exists(path)) Files.createFile(path);

            Client oldClient = (Client)obj;
            System.out.println(oldClient.getName());
            System.out.println(oldClient.getEmail());

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toString()));
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Object deserialization(Path path) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()));
            Client newClient = (Client) objectInputStream.readObject();
            newClient.setName("I love serialization");
            newClient.setEmail("newEmail@afterSerialization.java");
            System.out.println(newClient.getName());
            System.out.println(newClient.getEmail());
            return newClient;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
