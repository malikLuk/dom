package ru.dom.lukmanovcarhiring.common.dao.entity;

import javax.persistence.*;

@MappedSuperclass
public class CommonEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "I_ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
