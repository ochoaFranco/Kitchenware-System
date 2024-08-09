package com.kitchenware.api.controller;

import com.kitchenware.api.entity.Sell;
import com.kitchenware.api.service.ISellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sells")
public class SellController {
    @Autowired
    private ISellService sellService;

    // Create a sell.
    @PostMapping("/create")
    public ResponseEntity<Sell> saveSell(@RequestBody Sell sell) {
        sellService.saveSell(sell);
        return new ResponseEntity<>(sell, HttpStatus.CREATED);
    }

    // Read all sells.
    @GetMapping()
    public ResponseEntity<List<Sell>> getSells() {
        List<Sell> sellList = sellService.getSells();
        return new ResponseEntity<>(sellList, HttpStatus.OK);
    }

    // Read one sell.
    @GetMapping("/{id}")
    public ResponseEntity<Sell> getSellById(@PathVariable Long id) {
        Optional<Sell> optionalSell = sellService.getSellById(id);
        if (optionalSell.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Sell sell = optionalSell.get();

        return new ResponseEntity<>(sell, HttpStatus.OK);
    }

    // Update a whole sell.
    @PutMapping("/edit")
    public ResponseEntity<Sell> editSell(@RequestBody Sell sell) {
        sellService.saveSell(sell);
        return new ResponseEntity<>(sell, HttpStatus.OK);
    }

    // Update sell by its ID.
    @PutMapping("/edit/{id}")
    public ResponseEntity<Sell> editSell(
            @PathVariable Long id,
            @RequestBody Sell sell) {

        Optional<Sell> optionalSell = sellService.getSellById(id);
        if (optionalSell.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        sellService.editSell(id, sell);
        return new ResponseEntity<>(optionalSell.get(), HttpStatus.OK);
    }

    // Delete a sell by its ID.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSell(@PathVariable Long id) {
        try {
            sellService.deleteSell(id);
            return new ResponseEntity<>("The Sell was deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("There was an error", HttpStatus.BAD_REQUEST);
        }
    }
}
