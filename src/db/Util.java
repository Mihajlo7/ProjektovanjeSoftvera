/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Mihajlo
 */
public class Util {
    private static Util instance;
    private Properties properties;
    
    private Util() throws FileNotFoundException, IOException{
        FileInputStream fis=new FileInputStream("config/dbconfig.properties");
        properties=new Properties();
        properties.load(fis);
    }
    
    public static Util getInstance() throws IOException{
        if(instance==null){
            instance=new Util();
        }
        return instance;
    }
    public String getUrl(){
        return properties.getProperty("url");
    }
    public String getUsername(){
        return properties.getProperty("username");
    }
    public String getPassword(){
        return properties.getProperty("password");
    }
}
