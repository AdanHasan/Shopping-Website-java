//package com.ShoppingWebsiteApplication.model;
//
//public class UserOrderRequest {
//
//        private Order order;
//        private User user;
//
//        public UserOrderRequest( Order order ,User user) {
//            this.order = order;
//            this.user = user;
//        }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Order toOrder(){
//        return new Order(
//                this.order.getId(),
//               this.user.getId(),
//                this.order.getOrderDate(),
//                this.order.getShippingAddress(),
//                this.order.getTotalPrice(),
//                this.order.getStatus(),
//                this.order.getItemId()
//        );
//    }
//
//
//
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
