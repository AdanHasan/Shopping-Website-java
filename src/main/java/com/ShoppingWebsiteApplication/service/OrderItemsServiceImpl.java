package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.repository.ItemRepository;
import com.ShoppingWebsiteApplication.repository.OrderItemsRepository;
import com.ShoppingWebsiteApplication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    OrderItemsRepository orderItemsRepository;
    @Autowired
    ItemService itemService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;


    @Override
    public void calculate(OrderItems orderItems) {
        Double total = 0.0;
        Order order = orderService.getOrderById(orderItems.getOrderId());
        List<Long> Items = orderItemsRepository.getAllOrderItems(orderItems.getOrderId());

        for (Long id : Items) {
            total += (itemService.getItemPriceById(id) * orderItemsRepository.getOrderItemQuantityById(orderItems.getOrderId(), id));
        }
        order.setTotalPrice(total);
        orderRepository.updateTotalPrice(orderItems.getOrderId(), order);
        if (total == 0.0) {
            orderRepository.deleteOrderById(orderItems.getOrderId());

        }
    }

    @Override
    public void calculateTry(Long orderId) {
        Double total = 0.0;
        Order order = orderService.getOrderById(orderId);
        List<Long> Items = orderItemsRepository.getAllOrderItems(orderId);

        for (Long id : Items) {
            total += (itemService.getItemPriceById(id) * orderItemsRepository.getOrderItemQuantityById(orderId, id));
        }
        order.setTotalPrice(total);
        orderRepository.updateTotalPrice(orderId, order);
        if (total == 0.0) {
            orderRepository.deleteOrderById(orderId);

        }
    }

    @Override
    public void delt(Long itemId, Long orderId) {
        String userName = orderRepository.geUserNameById(orderId);

        Long quantity = orderItemsRepository.getOrderItemQuantity(userName, itemId);

        if (quantity > 1) {
            itemRepository.incItemQuantitys(itemId, quantity);

        } else if (quantity == 1) {
            itemRepository.incItemQuantity(itemId);
        }
    }


    @Override
    public void createOrderItems(OrderItems orderItems) {
        String newUserName = "'" + orderItems.getUserName() + "'";

        if (orderRepository.getAllTempOrdersByUserName(newUserName).size() == 0) {
            Order newOrder = new Order(orderItems.getUserName(), LocalDate.now());
            orderRepository.createOrder(newOrder);
            List<Long> arrOfOrders = orderService.getAllOrdersByUserName(newUserName);
            int s = arrOfOrders.size() - 1;
            Long lastOrderId = arrOfOrders.get(s);
            for (Long id : orderItems.getItems()) {
                Long quantity = itemRepository.getItemQuantityById(id);
                if (quantity == 0) {
                    orderItems.getItems().remove(id);
                } else if (quantity != 0) {
                    itemRepository.decItemQuantity(id);
                }
            }

            OrderItems newOrderItems = new OrderItems(orderItems.getUserName(), lastOrderId, orderItems.getItems());
            if (newOrderItems.getItems().size() == 0) {
                System.out.println("in if");
                calculate(newOrderItems);
            } else {
                orderItemsRepository.createOrderItems(newOrderItems);
                calculate(newOrderItems);
                System.out.println("in else");

            }

        } else {
            System.out.println("we are in this else");

            if (orderRepository.getAllTempOrdersByUserName(newUserName).size() != 0) {
                System.out.println("part 1");

                List<Long> arrOfTempOrders = orderRepository.getAllTempOrdersByUserName(newUserName);
                System.out.println("part 2");

                int s = arrOfTempOrders.size() - 1;
                Long lastTempOrderId = arrOfTempOrders.get(s);
                List<Long> allOrderItems = orderItemsRepository.getAllOrderItems(lastTempOrderId);
                System.out.println("part 3");
                System.out.println(orderItems.getItems());
                for (int i = 0; i < orderItems.getItems().size(); i++) {
                    System.out.println("we starting the for");
                    System.out.println("the current id is" + orderItems.getItems().get(i));

                    Long quantity = itemRepository.getItemQuantityById(orderItems.getItems().get(i));
                    if (quantity == 0) {
                        orderItems.getItems().remove(orderItems.getItems().get(i));
                    } else if (quantity != 0 && allOrderItems.contains(orderItems.getItems().get(i))) {
                        System.out.println("part 4");
                        orderItemsRepository.updateOrderItemQuantity(lastTempOrderId, orderItems.getItems().get(i));

                        System.out.println("part 5");
                        itemRepository.decItemQuantity(orderItems.getItems().get(i));

                        System.out.println("part 6");

                        orderItems.getItems().remove(orderItems.getItems().get(i));
                        System.out.println("part 7");

                    } else {
                        System.out.println("cdfsghj" + orderItems.getItems().get(i));
                        itemRepository.decItemQuantity(orderItems.getItems().get(i));

                    }
                    System.out.println("we endeingggg the for");

                }

                System.out.println("before");

                if (orderItems.getItems().isEmpty()) {
                    System.out.println("in if2....");

                    OrderItems newOrderItems = new OrderItems(orderItems.getUserName(), lastTempOrderId);
                    calculate(newOrderItems);
                    System.out.println("in if2");

                } else {
                    System.out.println("in else2...");

                    OrderItems newOrderItems = new OrderItems(orderItems.getUserName(), lastTempOrderId, orderItems.getItems());
                    orderItemsRepository.createOrderItems(newOrderItems);
                    calculate(newOrderItems);
                    System.out.println("in else2");

                }
                System.out.println("after");


            }
        }
    }


    @Override
    public void createOrderItem(OrderItems orderItems) {
        String newUserName = "'" + orderItems.getUserName() + "'";

        if (orderRepository.getAllTempOrdersByUserName(newUserName).size() == 0) {
            Order newOrder = new Order(orderItems.getUserName(), LocalDate.now());
            orderRepository.createOrder(newOrder);
            List<Long> arrOfOrders = orderService.getAllOrdersByUserName(newUserName);
            int s = arrOfOrders.size() - 1;
            Long lastOrderId = arrOfOrders.get(s);
            Long quantity = itemRepository.getItemQuantityById(orderItems.getOrderItemId());
            if (quantity == 0) {
                System.out.println("Item is out of stock!!" + quantity);
            } else if (quantity != 0) {
                OrderItems newOrderItems = new OrderItems(orderItems.getUserName(), lastOrderId, orderItems.getOrderItemId());
                orderItemsRepository.createOrderItem(newOrderItems);
                calculate(newOrderItems);
                itemRepository.decItemQuantity(orderItems.getOrderItemId());
            }
        } else {

            if (orderRepository.getAllTempOrdersByUserName(newUserName).size() != 0) {
                List<Long> arrOfTempOrders = orderRepository.getAllTempOrdersByUserName(newUserName);
                int s = arrOfTempOrders.size() - 1;
                Long lastTempOrderId = arrOfTempOrders.get(s);
                List<Long> allOrderItems = orderItemsRepository.getAllOrderItems(lastTempOrderId);
                Long quantity = itemRepository.getItemQuantityById(orderItems.getOrderItemId());
                if (quantity == 0) {
                } else if (quantity != 0 && allOrderItems.contains(orderItems.getOrderItemId())) {
                    orderItemsRepository.updateOrderItemQuantity(lastTempOrderId, orderItems.getOrderItemId());
                    OrderItems newOrderItems = new OrderItems(orderItems.getUserName(), lastTempOrderId);
                    calculate(newOrderItems);
                    itemRepository.decItemQuantity(orderItems.getOrderItemId());
                } else if (quantity != 0 && (!allOrderItems.contains(orderItems.getOrderItemId()))) {
                    OrderItems newOrderItems = new OrderItems(orderItems.getUserName(), lastTempOrderId, orderItems.getOrderItemId());
                    orderItemsRepository.createOrderItem(newOrderItems);
                    calculate(newOrderItems);
                    itemRepository.decItemQuantity(orderItems.getOrderItemId());
                }
            }
        }
    }

    @Override
    public void deleteOrderItemsById(Long orderItemsId) {

        orderItemsRepository.deleteOrderItemsById(orderItemsId);

    }

    @Override
    public void deleteOrderItemsById(Long orderId, Long ItemsId) {
        String userName = orderRepository.geUserNameById(orderId);

        Long quantity = orderItemsRepository.getOrderItemQuantity(userName, ItemsId);

        if (quantity > 1) {
            itemRepository.incItemQuantitys(ItemsId, quantity);

        } else if (quantity == 1) {
            itemRepository.incItemQuantity(ItemsId);
        }
        orderItemsRepository.deleteOrderItemsById(orderId, ItemsId);

        List<Long> allItems = orderItemsRepository.getAllOrderItems(orderId);
        if (allItems.size() > 0) {
            List<Long> items = new ArrayList<>();
            items.add(ItemsId);
            OrderItems orderItems = new OrderItems(orderId, items);
            calculate(orderItems);
        } else {
            orderRepository.deleteOrderById(orderId);

        }
    }

    @Override
    public void deleteOrderItemsByOrderId(Long orderId) {
        String userName = orderRepository.geUserNameById(orderId);
        List<Long> orderItems = orderItemsRepository.getAllOrderItems(orderId);
        for (Long id : orderItems) {
            Long quantity = orderItemsRepository.getOrderItemQuantity(userName, id);
            if (quantity > 1) {
                itemRepository.incItemQuantitys(id, quantity);

            } else if (quantity == 1) {

                itemRepository.incItemQuantity(id);
            }

        }
        orderItemsRepository.deleteOrderItemsByOrderId(orderId);
        orderRepository.deleteOrderById(orderId);
    }


    @Override
    public void deleteOrderItemsByUserName(Long orderId) {
        orderItemsRepository.deleteOrderItemsByUserName(orderId);
    }

    @Override
    public void deleteUser(String userName) {
        orderItemsRepository.deleteUser(userName);

    }

    @Override
    public void updateOrderItemQuantity(Long orderId, Long ItemsId) {
        orderItemsRepository.updateOrderItemQuantity(orderId, ItemsId);
    }

    @Override
    public void decOrderItemQuantity(Long orderId, Long ItemsId) {
        Long quantity = orderItemsRepository.getOrderItemQuantityTry(orderId, ItemsId);

        if (quantity > 1) {
            orderItemsRepository.decOrderItemQuantity(orderId, ItemsId);
            itemRepository.incItemQuantity(ItemsId);
        } else if (quantity == 1) {

            orderItemsRepository.decOrderItemQuantity(orderId, ItemsId);
            itemRepository.incItemQuantity(ItemsId);
            orderItemsRepository.deleteOrderItemsById(orderId, ItemsId);
        }


        calculateTry(orderId);
    }


    @Override
    public Long quantity(Long orderId, Long itemId) {
        return orderItemsRepository.quantity(orderId, itemId);
    }

    @Override
    public Long getOrderItemQuantity(String userName, Long itemId) {
        return orderItemsRepository.getOrderItemQuantity(userName, itemId);
    }


    @Override
    public List<Long> getAllOrderItems(Long orderId) {
        return orderItemsRepository.getAllOrderItems(orderId);
    }

    @Override
    public List<OrderItems> getAllOrdersItems() {
        return orderItemsRepository.getAllOrdersItems();
    }

    @Override
    public List<Long> getAllOrderIds() {
        return orderItemsRepository.getAllOrderIds();
    }

    @Override
    public List<HashMap<Long, Item>> getAllTry(Long orderId) {
        return orderItemsRepository.getAllTry(orderId);
    }

}
