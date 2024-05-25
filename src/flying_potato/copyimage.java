/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flying_potato;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author Rameshwar
 */
public class copyimage {

    public copyimage() {
        
    }
    public void copy(String source,String filename){
        try {
            Path path = Paths.get("");
            File sourceFile = new File(source);
            File destinationFile = new File(path.toFile().getAbsolutePath()+"\\src\\flying_potato\\itemimage\\"+filename);
            Files.copy(sourceFile.toPath(), destinationFile.toPath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void delete(String filename){
            Path path = Paths.get("");
            File file=new File(path.toFile().getAbsolutePath()+"\\src\\flying_potato\\itemimage\\"+filename);
            file.delete();
    }
    public File open(String filename)
    {
            Path path = Paths.get("");
            File open = new File(path.toFile().getAbsolutePath()+"\\src\\flying_potato\\itemimage\\"+filename);
            return open;
        
    }
}
