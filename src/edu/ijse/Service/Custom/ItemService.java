/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.Service.Custom;

import edu.ijse.Service.SuperService;
import edu.ijse.dto.ItemDto;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface ItemService extends SuperService {
    String save(ItemDto itemDto) throws Exception;
    String update(ItemDto itemDto) throws Exception;
    String delete(String itemCode) throws Exception;
    ItemDto get(String itemCode) throws Exception;
    ArrayList<ItemDto> getAll()throws Exception;
    
}
