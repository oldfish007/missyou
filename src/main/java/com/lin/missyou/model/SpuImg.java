package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class SpuImg extends BaseEntity{
    @Id
    private Long id;
    private String img;
    private Long spuId;


}
