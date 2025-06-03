package com.delivery.repository;

import com.delivery.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByDriverId(String driverId);
    List<Delivery> findByOrderId(String orderId);
    List<Delivery> findByStatus(DeliveryStatus status);
} 