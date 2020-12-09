package com.foodmanagement.foodmanagementsystem.dao;

import org.springframework.data.repository.CrudRepository;

import com.foodmanagement.foodmanagementsystem.model.customer.ConfirmationToken;

public interface Tokens extends CrudRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
