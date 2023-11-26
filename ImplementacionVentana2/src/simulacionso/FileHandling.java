/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacionso;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;



public class FileHandling {
    
    public static Lista<Usuario> readFile(File file) throws IOException, CsvValidationException  {
        
        GestorUsuarios gu = new GestorUsuarios();
        
        File CSVFile = file;
        try (CSVReader csvReader = new CSVReader(new FileReader(CSVFile, StandardCharsets.UTF_8))) {
            Lista<String[]> lineas = new Lista<>();
            String[] cabeceras = csvReader.readNext();
            String[] linea;
            
            
           
            while ((linea = csvReader.readNext()) != null) {
                
//                lineas.agregarElemento(linea);
                
                Usuario usuario = new Usuario(linea[0], linea[1]);
                gu.agregarUsurario(usuario);
                
            }
            
//            lineas.imprimirValores();
    Lista<Usuario> listaDeUsuarios = gu.getUsuarios();
     
            
            
        return listaDeUsuarios;

    }catch (IOException e) {

                e.printStackTrace();
        }
        return null;
       
        
    }
    public static String insertUser(String fileContent, String userName){
        int usuariosIndex = fileContent.indexOf("Usuarios");
        StringBuilder builder = new StringBuilder(fileContent);
        builder.insert(usuariosIndex + 8, System.lineSeparator() + userName);

        return builder.toString();

    }
    
    
    public static void removeUser(String fileName, String nameToRemove, File file) throws IOException {
        // Create a temporary file
        File tempFile = new File("temp.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        // Open the input file
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String currentLine;
        boolean foundUser = false;
        boolean foundRelationship = false;

        // Iterate through the lines of the file
        while ((currentLine = reader.readLine()) != null) {
            // Check if the line contains the name in the authors section
            if (currentLine.equals("Usuarios")) {
                writer.write(currentLine);
                writer.newLine();
                while ((currentLine = reader.readLine()) != null) {
                    String newString = currentLine.replaceAll("\\s+", "");
                    String[] temp_array = newString.split(",");
//                    if(temp_array.length < 2) break;
                    if(temp_array.length < 2) {
                        writer.write(currentLine);
                        writer.newLine();
                        
                        continue;}
                    else if (temp_array[0].equals(nameToRemove) || temp_array[1].toLowerCase().equals(nameToRemove)) {
                        foundUser = true;
                        if(temp_array[1].toLowerCase().equals(nameToRemove)) nameToRemove = temp_array[0];
                        
                    } else {
                        writer.write(currentLine);
                        writer.newLine();
                    }
                }
                writer.flush();
            }
            // Check if the line contains the name in the relationships section
            else if (currentLine.equals("Relaciones")) {
                writer.write(currentLine);
                writer.newLine();
                while ((currentLine = reader.readLine()) != null) {
                    String newString = currentLine.replaceAll("\\s+", "");
                    String[] relationship = newString.split(",");
                    if (relationship.length == 3) {
                        if (!relationship[0].equals(nameToRemove) && !relationship[1].equals(nameToRemove)) {
                            writer.write(currentLine);
                            writer.newLine();
                        } else {
                            foundRelationship = true;
                        }
                    }
                }
                writer.flush();
            } else {
                writer.write(currentLine);
                writer.newLine();
            }
        }

        writer.close();
        reader.close();

        // Replace the original file with the temporary file
        File originalFile = new File(fileName);
        if (!originalFile.delete()) {
            throw new IOException("Failed to delete the original file: " + fileName);
        }
        if (!tempFile.renameTo(originalFile)) {
            throw new IOException("Failed to rename the temporary file.");
        }

        if (!foundUser && !foundRelationship) {
            throw new IllegalArgumentException("Name not found: " + nameToRemove);
        }
    }

//    public static void main(String[] args) {
//        String fileName = "data.txt";
//        String nameToRemove = "John";
//        try {
//            removeUser(fileName, nameToRemove);
//            System.out.println("Name '" + nameToRemove + "' removed successfully from the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred while removing the name from the file: " + e.getMessage());
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//    }

}

