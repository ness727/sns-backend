package com.cosmos.sns.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CreatedDate {
    @org.springframework.data.annotation.CreatedDate
    @Column(name = "created_at", updatable = false)
    protected LocalDateTime createdAt;
}
