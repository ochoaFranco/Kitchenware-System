package com.kitchenware.api.service;

import com.kitchenware.api.entity.Sell;
import java.util.List;
import java.util.Optional;

public interface ISellService {
    // Create method.
    void saveSell(Sell sell);

    // get all sells.
    List<Sell> getSells();

    // get one sell.
    Optional<Sell> getSellById(Long id);

    // update a whole sell.
    void editSell(Long id,Sell sell);

    // delete one sell by id.
    void deleteSell(Long id);
}
