package com.deals.deals.controller;


import com.deals.deals.model.Deals;
import com.deals.deals.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deals")
public class DealController {

    @Autowired
    private DealService dealService;

    @PostMapping("/createDeal")
    public ResponseEntity<Deals> createDeal(@RequestBody Deals deal)
    {
        return ResponseEntity.ok(dealService.createDeal(deal));
    }

    @PutMapping("/updateDeal/{id}")
    public ResponseEntity<Deals> updateDeal(@PathVariable Long id,@RequestBody Deals deal)
    {
        return ResponseEntity.ok(dealService.updateDeal(id,deal));
    }
    @PutMapping("/{id}/end")
    public ResponseEntity<Deals> endDeal(@PathVariable Long id)
    {
        dealService.endDeal(id);
        return null;
    }
    @PutMapping("/{id}/claim")
    public ResponseEntity<Deals> cliamDeal(@PathVariable Long id)
    {
        return ResponseEntity.ok(dealService.claimDeal(id));
    }
}
