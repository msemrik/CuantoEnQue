package com.Controller;


import com.DAO.DBAccess;
import com.DAO.DBAccessObjects.*;
import com.domain.*;
import com.domain.VO.CategoryVO;
import com.domain.VO.MovementVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.CoreException;
import com.util.MovementHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getCategories() throws CoreException {
        return ((DBAccessCategory) DBAccess.getDBAccessObject(Category.class)).loadEveryRow();
    }

    @RequestMapping(value = "/getAccounts", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getAccounts() throws CoreException {
        return ((DBAccessAccount) DBAccess.getDBAccessObject(Account.class)).loadEveryRow();
    }

    @RequestMapping(value = "/getCurrencies", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getCurrencies() throws CoreException {
        return ((DBAccessCurrency) DBAccess.getDBAccessObject(Currency.class)).loadEveryRow();
    }

    @RequestMapping(value = "/getMovements", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getMovements() throws CoreException {
        return ((DBAccessMovement) DBAccess.getDBAccessObject(Movement.class)).loadEveryRow();

    }

    @RequestMapping(value = "/getDetails", method = RequestMethod.PUT)
    @ResponseBody
    public List<Detail> getDetails(@RequestBody CategoryVO categoryVO) throws CoreException {
        Category category = categoryVO.createCategoryfromVO();
        return ((DBAccessDetail) DBAccess.getDBAccessObject(Detail.class)).getDetailsForCategory(category);


    }


    @RequestMapping(value = "/createMovement", method = RequestMethod.PUT)
    @ResponseBody
    public String createMovement(@RequestBody MovementVO movementVO) throws JsonProcessingException {
        ResponseEntity responseEntity = null;
        try {
            Movement movement = movementVO.createMovementfromVO();
            ((DBAccessMovement) DBAccess.getDBAccessObject(Movement.class)).saveMovement(movement);
            responseEntity = new ResponseEntity<String>("successful", HttpStatus.OK);
        } catch (CoreException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(responseEntity);
        return jsonInString;
    }

}