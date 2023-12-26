package org.design.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "EXCEPTION")
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionEntity {

    @Id
    @Column(name = "EXCEPTION_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer exceptionId;

    @Column(name = "EXCEPTION_NAME")
    String exceptionName;

    @Column(name = "CAUSE")
    String cause;

    @Column(name = "CREATE_TIME")
    @CreationTimestamp
    Instant createTime;
}
