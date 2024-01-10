package com.newweb.service.business;

import com.newweb.model.business.*;
import org.springframework.lang.NonNull;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface OrderService {

    boolean addOrder(@NonNull Order order,
                     @NonNull List<OrderLhjWinProp> orderLhjWinPropsList,
                     @NonNull List<Map<String, String>> smallList,
                     @NonNull List<Map<String, String>> bxgList,
                     @NonNull List<OrderBxgFdw> orderBxgFdws);

    Order findOrderById(@NonNull String id);

    boolean saveOrder(@NonNull Order order);

    Order[] queryOrderByAcceptStatus(@NonNull String status);

    List<Order> queryOrderByAcceptStatus(@NonNull String status, int start, int limit);

    BigInteger getUnprocessedOrderCount();

    OrderLhjWinProp[] queryOrderLhjWinPropsByOrderID(@NonNull String orderId);

    boolean modifyOrder(@NonNull Order order);

    boolean removeOrder(@NonNull Order order);

    Order[] queryAllOrders();

    List<Order> queryDoneOrderByCreateDateAndCustomer(@NonNull String startDate,
                                                      @NonNull String endDate,
                                                      @NonNull String customer,
                                                      int start, int limit);

    OrderLhjWeight[] queryOrderLhjWeightsByOrderID(@NonNull String id);

    OrderSmall[] queryOrderSmallsByOrderID(@NonNull String id);

    OrderBxg[] queryOrderBxgsByOrderID(@NonNull String orderId);

    double getOrderLhjWinArea(@NonNull String orderId);

    double getOrderBxgFdwArea(@NonNull String orderId);

    OrderOther[] queryOrderOthersByOrderId(@NonNull String id);

    double getOrderAccountByOrderID(@NonNull String id);

    Order[] queryDoneOrderByCreateDateAndCustomer(@NonNull String startDate,
                                                  @NonNull String endDate,
                                                  @NonNull String customer);

    Order[] queryProcessedOrderByCreateDateAndCustomer(@NonNull String startDate,
                                                       @NonNull String endDate,
                                                       @NonNull String customer);

    Order[] queryUnprocessedOrderByCreateDateAndCustomer(@NonNull String startDate,
                                                         @NonNull String endDate,
                                                         @NonNull String customer);

    String getOrderSimpleContent(@NonNull String id);

    void flush();
}
