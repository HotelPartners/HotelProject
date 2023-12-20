package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.ShopDTO;
import com.backend.services.interfaces.IShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private IShopService shopService;

    @PostMapping("/add-shop-type")
    public ResponseEntity<?> addShop(@RequestBody ShopDTO shopDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(shopService.addShop(shopDTO));
    }
}
