package org.springbootjpapractice.repository;

import org.springbootjpapractice.domain.Item;
import org.springbootjpapractice.model.response.item.ItemDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {


    List<ItemDto> findAllBy();


    <T> T findByItemID(String itemID, Class<T> type);
    <T> T findByItemName(String itemName, Class<T> type);
}
