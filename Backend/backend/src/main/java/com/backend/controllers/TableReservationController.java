package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.config.JwtService;
import com.backend.dtos.CancelledTableDTO;
import com.backend.dtos.ConfirmTableReservationDetails;
import com.backend.dtos.ShowReservedTablesDTO;
import com.backend.dtos.TableReservationDTO;
import com.backend.pojos.enums.TableType;
import com.backend.services.CancelledTableService;
import com.backend.services.interfaces.ITableReservationService;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "*")
public class TableReservationController {
    @Autowired
    private ITableReservationService tableReservationService;
    
    @Autowired
    private JwtService jwtService; 
    
    @Autowired
    private CancelledTableService cancelledTableService;

    @PostMapping("/add-reservation/{token}/{tableType}")
    public ConfirmTableReservationDetails addReservation(@RequestBody TableReservationDTO tableReservationDTO, @PathVariable String token, @PathVariable TableType tableType){
    	 String email=jwtService.extractUserName(token);
    	return tableReservationService.addReservation(tableReservationDTO, email, tableType);
        
    }

    @GetMapping("/{token}")
    public List<ShowReservedTablesDTO> showReservations(@PathVariable String token){
   	 String email=jwtService.extractUserName(token);
   	 return tableReservationService.showReservations(email);
    }
    
    @GetMapping("/table-details")
    public List<ShowReservedTablesDTO> allTableDetails()
    {
    	return tableReservationService.allTableDetails();
    }
    
    @PutMapping("/update-status/{orderId}")
    public String updateTableStatus(@PathVariable Long orderId)
    {
    	return tableReservationService.updateTableStatus(orderId);
    }
    

    @PostMapping("/cancel-reservation")
    public CancelledTableDTO cancelTable(@RequestBody CancelledTableDTO cancelledTableDTO){
    	
        return cancelledTableService.cancelTable(cancelledTableDTO);
    }    
}
