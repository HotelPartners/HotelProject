package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.LiveTableDTO;
import com.backend.services.interfaces.ILiveTableService;

@RestController
@RequestMapping("/live-tables")
@CrossOrigin(origins = "*")
public class LiveTableController {
    @Autowired
    private ILiveTableService liveTableService;

    @PostMapping("/add-live-table")
    public LiveTableDTO addLiveTables(LiveTableDTO liveTableDTO) {
        return liveTableService.addLiveTables(liveTableDTO);
    }
}
