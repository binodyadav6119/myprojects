package com.deals.deals.service;

import com.deals.deals.exception.DealNotFoundException;
import com.deals.deals.model.Deals;
import com.deals.deals.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DealService {

    @Autowired
    private DealRepository dealRepository;

    public Deals createDeal(Deals deal)
    {
        deal.setStartTime(LocalDateTime.now());
        deal.setActive(true);
        return dealRepository.save(deal);
    }

    public Deals updateDeal(Long id, Deals updateDetails)
    {
        Optional<Deals> existinDeal = dealRepository.findById(id);
        Deals deal = existinDeal.get();
        if(updateDetails.getEndTime()!=null)
        {
            deal.setEndTime(updateDetails.getEndTime());

        }
        if(updateDetails.getTotalItems()>0)
        {
            deal.setTotalItems(updateDetails.getTotalItems());
        }
        return dealRepository.save(deal);
    }
    public void endDeal(Long id)
    {
        Optional<Deals> deals = dealRepository.findById(id);
        Deals deal = deals.get();
        deal.setActive(false);
        dealRepository.save(deal);
    }

    public Deals claimDeal(Long id)
    {
        Deals deal = dealRepository.findByIdAndActive(id,true).orElseThrow(()->new DealNotFoundException("Deal not found for inactive"));
        if(deal.getClaimedItems()>= deal.getTotalItems())
        {
            throw new IllegalStateException("Deal has been fully cliamed");
        }
        if(deal.getEndTime().isBefore(LocalDateTime.now()))
        {
            throw new IllegalStateException("deal time is over");
        }
        deal.setClaimedItems(deal.getClaimedItems()+1);
        return dealRepository.save(deal);
    }
}
