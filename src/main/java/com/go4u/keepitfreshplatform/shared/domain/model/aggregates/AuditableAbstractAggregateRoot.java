package com.go4u.keepitfreshplatform.shared.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * Abstract class for aggregate roots that need auditing capabilities.
 * It extends AbstractAggregateRoot to support domain events.
 *
 * @param <T> the type of the aggregate root
 */

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;


    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;


