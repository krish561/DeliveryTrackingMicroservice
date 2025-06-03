package com.delivery.service.impl;

import com.delivery.model.Delivery;
import com.delivery.model.DeliveryStatus;
import com.delivery.repository.DeliveryRepository;
import com.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery updateDelivery(Long id, Delivery delivery) {
        Delivery existingDelivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found with id: " + id));
        
        existingDelivery.setOrderId(delivery.getOrderId());
        existingDelivery.setDriverId(delivery.getDriverId());
        existingDelivery.setStatus(delivery.getStatus());
        existingDelivery.setPickupAddress(delivery.getPickupAddress());
        existingDelivery.setDeliveryAddress(delivery.getDeliveryAddress());
        
        return deliveryRepository.save(existingDelivery);
    }

    @Override
    public Delivery updateDeliveryStatus(Long id, DeliveryStatus status) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found with id: " + id));
        delivery.setStatus(status);
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found with id: " + id));
    }

    @Override
    public List<Delivery> getDeliveriesByDriverId(String driverId) {
        return deliveryRepository.findByDriverId(driverId);
    }

    @Override
    public List<Delivery> getDeliveriesByOrderId(String orderId) {
        return deliveryRepository.findByOrderId(orderId);
    }

    @Override
    public List<Delivery> getDeliveriesByStatus(DeliveryStatus status) {
        return deliveryRepository.findByStatus(status);
    }

    @Override
    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }
} 