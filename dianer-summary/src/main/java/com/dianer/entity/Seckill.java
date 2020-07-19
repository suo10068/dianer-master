package com.dianer.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-29 09:03
 **/
@Data
@Entity
@Table(name = "seckill")
public class Seckill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seckill_id", nullable = false)
    private long seckillId;
    private String name;
    private int number;
    private Timestamp startTime;
    private Timestamp endTime;
    private Timestamp createTime;
    @Version
    private int version;
}
