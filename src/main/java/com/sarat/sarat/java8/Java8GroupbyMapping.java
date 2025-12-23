package com.Practice.sarat.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8GroupbyMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
                );

		//group by price
        Map<BigDecimal, List<Item>> groupByPriceMap = 
			items.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println(groupByPriceMap);

		// group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> result =
                items.stream()
                .collect(Collectors.groupingBy(Item::getPrice,
                         Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );
        Map<String, List<BigDecimal>> result1 =
                items.stream()
                .collect(Collectors.groupingBy(Item::getName,
                         Collectors.mapping(Item::getPrice, Collectors.toList())
                        )
                );

        System.out.println(result);
        System.out.println(result1);

	}

}

class Item {

    private String name;
    private int qty;
    private BigDecimal price;
	@Override
	public String toString() {
		return "Item [name=" + name + ", qty=" + qty + "]";
	}
	public Item(String name, int qty, BigDecimal price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

    //constructors, getter/setters 
    
}