package com.Controller;


import com.DAO.DBAccess;
import com.domain.Account;
import com.domain.Currency;
import com.domain.Movement;
import com.domain.Reason;
import com.domain.VO.MovementVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MainController {

    @RequestMapping(value = "/getReasons", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getReason() {
        return DBAccess.loadEveryRow(Reason.class);

    }

    @RequestMapping(value = "/getAccounts", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getAccounts() {
        return DBAccess.loadEveryRow(Account.class);

    }

    @RequestMapping(value = "/getCurrencies", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getCurrencies() {
        return DBAccess.loadEveryRow(Currency.class);

    }

    @RequestMapping(value = "/getMovements", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getMovements() {
        return DBAccess.loadEveryRow(Movement.class);

    }

    @RequestMapping(value = "/createMovement", method = RequestMethod.PUT)
    @ResponseBody
    public String createMovement(@RequestBody MovementVO movementVO) throws JsonProcessingException {

        ResponseEntity responseEntity = null;
        Movement movement = movementVO.createMovementfromVO();
        String missingParameters = movement.hasMissingParameters();
        if(missingParameters.isEmpty()) {
            DBAccess.saveObject(movement);
            responseEntity =  new ResponseEntity<String>("successful", HttpStatus.OK);
        }
        else {
            responseEntity =  new ResponseEntity<String>(missingParameters, HttpStatus.BAD_REQUEST);
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(responseEntity);
        return jsonInString;
    }

/*
    @RequestMapping(value = "/pruebaString", method = RequestMethod.PUT)
    @ResponseBody
    public String pruebaString(@RequestBody MovementVO movementVO) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(new ResponseEntity<String>("successful", HttpStatus.OK));
        return jsonInString;
    }

    @RequestMapping(value = "/pruebaInt", method = RequestMethod.PUT)
    @ResponseBody
    //@Consumes(MediaType.APPLICATION_JSON)
    public String pruebaInt(@RequestParam(value = "comment", required = true) int comment) {

        return "{'campo':'successful'";
    }*/






}