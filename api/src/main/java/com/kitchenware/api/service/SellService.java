package com.kitchenware.api.service;

import com.kitchenware.api.entity.Product;
import com.kitchenware.api.entity.Sell;
import com.kitchenware.api.repository.ISellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellService implements ISellService {
    @Autowired
    ISellRepository sellRepository;
    // Create sell method.
    @Override
    public void saveSell(Sell sell) {
        sellRepository.save(sell);
    }
    // get all sells method.
    @Override
    public List<Sell> getSells() {
        return sellRepository.findAll();
    }

    // get one sell method.
    @Override
    public Optional<Sell> getSellById(Long id) {
        return sellRepository.findById(id);
    }

    // Update one sell method.
    @Override
    public void editSell(Long id, Sell sell) {
        Optional<Sell> optionalSell = this.getSellById(id);
        Sell s = optionalSell.get();
        // Setting attributes.
        if (s.getSellDate() != null)
            s.setSellDate(sell.getSellDate());

        if (s.getClient() != null)
            s.setClient(sell.getClient());

        if (s.getTotal() != null)
            s.setTotal(sell.getTotal());

        if (s.getProductList() != null)
            s.setProductList(sell.getProductList());

        this.saveSell(s);
    }

    // Delete one sell method.
    @Override
    public void deleteSell(Long id) {
        sellRepository.deleteById(id);
    }
}
