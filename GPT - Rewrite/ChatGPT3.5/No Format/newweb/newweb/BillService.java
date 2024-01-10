package com.newweb.service.business;

import java.util.List;

import com.newweb.model.business.Bill;
import com.newweb.model.business.Order;

public interface BillService {

    boolean save(Bill bill);

    boolean remove(Bill bill);

    Order[] queryOrdersByBillId(String billId);

    Bill findBillById(String billId);

    double getBillAccountByBillId(String billId);

    boolean modify(Bill bill);

    @SuppressWarnings("rawtypes")
    List queryBillStoreByStatusACreateDateTimeACustomerJsons(String status, String startDate, String endDate,
            String customer, int start, int limit);

    String[] queryDistinctStatus();

    Bill[] queryAllBills();

    Integer[] queryDistinctCustomerByDateACustomer(String startDate, String endDate, String customer);

    Bill[] queryBillStoreByStatusACreateDateTimeACustomerJsons(String status, String startDate, String endDate,
            String customer);

    /**
     * 账单整合操作
     *
     * @param ids
     * @param money
     * @return
     */
    String modifyBillsToConform(String[] ids, double money);

}
