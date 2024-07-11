/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.Service.Custom.impl;

import edu.ijse.Service.Custom.ItemService;
import edu.ijse.dao.DaoFactory;
import edu.ijse.dao.custom.ItemDao;
import edu.ijse.dto.ItemDto;
import edu.ijse.entity.ItemEntity;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ItemServiceImpl implements ItemService {
    
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);
    
    @Override
    public String save(ItemDto itemDto) throws Exception {
        ItemEntity entity = getItemEntity(itemDto);
        return itemDao.create(entity) ? "Success" : "Fail";
    }

    @Override
    public String update(ItemDto itemDto) throws Exception {
        ItemEntity entity = getItemEntity(itemDto);
        return itemDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(String itemCode) throws Exception {
        return itemDao.delete(itemCode) ? "Success" : "Fail";
    }

    @Override
    public ItemDto get(String itemCode) throws Exception {
        ItemEntity entity = itemDao.get(itemCode);
        if (entity != null){
        return getItemDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<ItemDto> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntitys = itemDao.getAll();
        if (itemEntitys != null && !(itemEntitys.isEmpty())){
            ArrayList<ItemDto> itemDtos = new ArrayList<>();
            
            for (ItemEntity itemEntity : itemEntitys) {
                itemDtos.add(getItemDto(itemEntity));
            }
            return itemDtos;
        }
            return null;
            
    }
    
    private ItemEntity getItemEntity(ItemDto itemDto){
        ItemEntity itemEntity = new ItemEntity(itemDto.getItemCode(), 
                itemDto.getDescription(), 
                itemDto.getPackSize(), itemDto.getQoh(), 
                itemDto.getUnitPrice());  
        return itemEntity;
    }
    
    private ItemDto getItemDto(ItemEntity entity){
        ItemDto itemDto = new ItemDto(entity.getItemCode(), 
                entity.getDescription(), 
                entity.getPackSize(), 
                entity.getQoh(), 
                entity.getUnitPrice());
        return itemDto;
    }
    
}
