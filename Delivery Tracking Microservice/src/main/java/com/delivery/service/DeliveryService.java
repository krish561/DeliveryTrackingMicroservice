package com.delivery.service;

import com.delivery.model.Delivery;
import com.delivery.model.DeliveryStatus;
import java.util.List;

public interface DeliveryService {
    Delivery createDelivery(Delivery delivery);
    Delivery updateDelivery(Long id, Delivery delivery);
    Delivery updateDeliveryStatus(Long id, DeliveryStatus status);
    Delivery getDeliveryById(Long id);
    List<Delivery> getDeliveriesByDriverId(String driverId);
    List<Delivery> getDeliveriesByOrderId(String orderId);
    List<Delivery> getDeliveriesByStatus(DeliveryStatus status);
    void deleteDelivery(Long id);
} 