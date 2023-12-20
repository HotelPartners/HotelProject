package com.backend.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.MenuConverter;
import com.backend.daos.ICategoryDAO;
import com.backend.daos.IIngredientDAO;
import com.backend.daos.IMenuDAO;
import com.backend.dtos.MenuDTO;
import com.backend.dtos.MenuWithImageDTO;
import com.backend.pojos.CategoryPOJO;

import com.backend.pojos.MenuPOJO;
import com.backend.pojos.enums.CategoryType;
import com.backend.services.interfaces.IMenuService;

@Service
@Transactional
public class MenuService implements IMenuService {
    @Autowired
    private IMenuDAO menuDao;
    @Autowired
    private MenuConverter menuConverter;
 
    @Autowired
    private ICategoryDAO categoryDAO;

    @Autowired
    private ImageService imageService;

    @Override
    public MenuDTO addItem(MenuDTO menuDTO, CategoryType categoryName) {
        MenuPOJO menuPOJO = menuConverter.dtoToPojo(menuDTO);
        menuPOJO.setMealChoice(menuDTO.getMealchoice());
        CategoryPOJO categoryPOJO = categoryDAO.findByCategoryName(categoryName);
        
        menuPOJO.setCategory(categoryPOJO);
        menuDao.save(menuPOJO);
        
        return menuConverter.pojoToDto(menuPOJO);
    }

    @Override
    public List<MenuWithImageDTO> getItems(CategoryType categoryName) throws FileNotFoundException, IOException {
        CategoryPOJO categoryPOJO = categoryDAO.findByCategoryName(categoryName);
        List<MenuWithImageDTO> list =new ArrayList<>();
        
        List<MenuPOJO> menuPOJOs=menuDao.findByCategory(categoryPOJO);

        for (MenuPOJO menu : menuPOJOs) {

         MenuWithImageDTO menuWithImageDTO=new MenuWithImageDTO();
         menuWithImageDTO.setItemId(menu.getItemId());
         menuWithImageDTO.setItemName(menu.getItemName());
         menuWithImageDTO.setPrice(menu.getPrice());
         menuWithImageDTO.setMealchoice(menu.getMealChoice());
         menuWithImageDTO.setItemImage(imageService.getResource(menu.getItemImage()).readAllBytes());
            list.add(menuWithImageDTO);
        }
        return list;
    }
    
    public String deleteMenu(Long itemId)
    {
    	if(menuDao.findById(itemId)!=null)
    	{
    		menuDao.deleteById(itemId);
    		return "success";
    	}
    	else
    	return "error";
    	
    }

}