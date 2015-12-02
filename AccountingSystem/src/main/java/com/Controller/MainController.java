package com.Controller;


import com.DAO.DBAccess;
import com.domain.Account;
import com.domain.Currency;
import com.domain.Movement;
import com.domain.Category;
import com.domain.VO.MovementVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.CoreException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MainController {

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getCategories() throws CoreException {
        return DBAccess.loadEveryRow(Category.class);

    }

    @RequestMapping(value = "/getAccounts", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getAccounts() throws CoreException {
        return DBAccess.loadEveryRow(Account.class);

    }

    @RequestMapping(value = "/getCurrencies", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getCurrencies() throws CoreException {
        return DBAccess.loadEveryRow(Currency.class);

    }

    @RequestMapping(value = "/getMovements", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getMovements() throws CoreException {
        return DBAccess.loadEveryRow(Movement.class);

    }

    @RequestMapping(value = "/createMovement", method = RequestMethod.PUT)
    @ResponseBody
    public String createMovement(@RequestBody MovementVO movementVO) throws JsonProcessingException {
        ResponseEntity responseEntity = null;
        try {
            Movement movement = movementVO.createMovementfromVO();
            String missingParameters = movement.hasMissingParameters();
            if (missingParameters.isEmpty()) {
                movement.process();
                responseEntity = new ResponseEntity<String>("successful", HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<String>(missingParameters, HttpStatus.BAD_REQUEST);
            }
        } catch (CoreException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(responseEntity);
        return jsonInString;
    }

}