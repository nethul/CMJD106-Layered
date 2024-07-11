/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import edu.ijse.dao.custom.impl.ItemDaoImpl;
import java.beans.Customizer;

/**
 *
 * @author User
 */
public class DaoFactory {
    private static DaoFactory daoFactory;
    
    private DaoFactory(){};
    
    public static DaoFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DaoFactory();
        } 
            return daoFactory;
    }
     
    public SuperDao getDao(DaoTypes type){
        switch (type){
            case ITEM : new ItemDaoImpl();
            default : return null;
        }
    }
    
    public enum DaoTypes{
        ITEM, CUSTOMER, ORDER, ORDER_DETAIL;
    }
    
}
