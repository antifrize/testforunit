package ru.vmakarenko.entities;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Entity
@Table(name = "test")
@Proxy(lazy = false)
public class Test {
    @Id
    @Column(name="id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
