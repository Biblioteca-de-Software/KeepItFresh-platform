package com.go4u.keepitfreshplatform.orders.application.internal.commandservices;

import com.go4u.keepitfreshplatform.orders.domain.model.aggregates.Order;
import com.go4u.keepitfreshplatform.orders.domain.model.commands.AddDishToOrderCommand;
import com.go4u.keepitfreshplatform.orders.domain.model.commands.CreateOrderCommand;
import com.go4u.keepitfreshplatform.orders.domain.services.OrderCommandService;
import com.go4u.keepitfreshplatform.orders.infrastructure.persistence.jpa.repositories.DishRepository;
import com.go4u.keepitfreshplatform.orders.infrastructure.persistence.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private OrderRepository orderRepository;
    private DishRepository dishRepository;

    public OrderCommandServiceImpl(OrderRepository orderRepository, DishRepository) {
        this.orderRepository = orderRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public Long handle(CreateOrderCommand command){
        var order = new Order();
        try{
            orderRepository.save(order);
        } catch(Exception e){
            throw new IllegalArgumentException("Error while saving order" + e.getMessage());
        }
        return order.getId();
    }

    @Override
    public void handle(AddDishToOrderCommand command){
        if(!orderRepository.existsById(command.orderId())){
            throw new IllegalArgumentException("Order not found");
        }

        if(!dishRepository.existsById(command.dishId())){
            throw new IllegalArgumentException("Dish not found");
        }

        try{
            var order = orderRepository.findById(command.orderId());
            var dish = dishRepository.findById(command.dishId());
            
        } catch (Exception e){
            throw new IllegalArgumentException("Error while saving order" + e.getMessage());
        }
    }

}
