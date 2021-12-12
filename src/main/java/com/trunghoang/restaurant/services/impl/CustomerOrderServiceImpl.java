package com.trunghoang.restaurant.services.impl;

import com.trunghoang.restaurant.constants.ErrorMessage;
import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.domains.CustomerOrder;
import com.trunghoang.restaurant.domains.Menu;
import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;
import com.trunghoang.restaurant.domains.mapper.DefaultClassMapper;
import com.trunghoang.restaurant.domains.report.BillReport;
import com.trunghoang.restaurant.domains.report.OrderInfo;
import com.trunghoang.restaurant.exceptions.ApplicationException;
import com.trunghoang.restaurant.repositories.BillRepository;
import com.trunghoang.restaurant.repositories.CustomerOrderRepository;
import com.trunghoang.restaurant.repositories.MenuRepository;
import com.trunghoang.restaurant.services.CustomerOrderService;
import com.trunghoang.restaurant.services.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Customer order service implementation
 */
@Service
public class CustomerOrderServiceImpl extends DefaultService<CustomerOrderDTO, CustomerOrder, CustomerOrderRepository>
        implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private DefaultClassMapper defaultClassMapper;

    @Override
    public CustomerOrderRepository getRepository() {
        return customerOrderRepository;
    }

    @Override
    public CustomerOrderDTO convertToDTO(CustomerOrder entity) {
        return defaultClassMapper.convert(entity, CustomerOrderDTO.class);
    }

    @Override
    public CustomerOrder convertToEntity(CustomerOrderDTO dto) {
        return defaultClassMapper.convert(dto, CustomerOrder.class);
    }

    @Override
    public List<CustomerOrderDTO> convertToDTOs(List<CustomerOrder> entities) {
        return defaultClassMapper.convertToList(entities, CustomerOrderDTO.class);
    }

    @Override
    public BillReport getBillReport(long billId) {

        List<CustomerOrderDTO> customerOrders = convertToDTOs(customerOrderRepository.getBillReport(billId));
        BillReport billReport = new BillReport();
        List<OrderInfo> billOrders = new ArrayList<>();
        BigDecimal grandTotal = BigDecimal.ZERO;

        for (CustomerOrderDTO order : customerOrders) {
            billOrders.add(BillServiceImpl.getOrderInfo(order));
            grandTotal = grandTotal.add(order.getSubTotalPrice());
        }
        billReport.setId(billId);
        billReport.setTotalPrice(grandTotal);
        billReport.setOrderInfo(billOrders);
        return billReport;
    }

    @Transactional
    @Override
    public void createCustomerOrder(long billId, long menuId, int quantity) throws ApplicationException {
        Optional<Bill> bill = billRepository.findById(billId);
        if (!bill.isPresent()) {
            throw new ApplicationException("Bill id=" + billId + " " + ErrorMessage.ENTITY_NOT_FOUND.toString());
        }

        Optional<Menu> menu = menuRepository.findById(menuId);
        if (!menu.isPresent()) {
            throw new ApplicationException("Menu id=" + menuId + " " + ErrorMessage.ENTITY_NOT_FOUND.toString());
        }
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setBill(bill.get());
        customerOrder.setMenu(menu.get());
        customerOrder.setOrderedTime(new Timestamp(System.currentTimeMillis()));
        customerOrder.setQuantity(quantity);
        customerOrderRepository.save(customerOrder);
    }

    @Override
    @Transactional
    public void deleteCustomerOrder(long id) throws ApplicationException {
        customerOrderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCustomerOrder(long customerOrderId, int quantity) throws ApplicationException {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setId(customerOrderId);
        customerOrder.setQuantity(quantity);

        customerOrderRepository.save(customerOrder);
    }
}
