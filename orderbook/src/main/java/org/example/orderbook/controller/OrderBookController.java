package org.example.orderbook.controller;


import org.example.orderbook.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class OrderBookController {

    @Autowired
    private OrderBookService orderBookService;

    //Fetches article by id
    @GetMapping(value="orderbook" , produces= { MediaType.APPLICATION_JSON_VALUE })
    public String getAllInstrument() {
        return "Hello World";
    }

}
