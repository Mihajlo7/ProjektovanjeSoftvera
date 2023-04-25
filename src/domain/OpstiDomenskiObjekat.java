/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Mihajlo
 */
import java.sql.ResultSet;

public abstract class OpstiDomenskiObjekat implements Serializable {
    
    public abstract String getClassName();
    public abstract String getPrimaryKeyName();
    public abstract int getPrimaryKeyValue();
    public abstract String getColumnValues();
    public abstract String setColumnValues();
    public abstract OpstiDomenskiObjekat getObjectFromResultSet(ResultSet rs);
}
