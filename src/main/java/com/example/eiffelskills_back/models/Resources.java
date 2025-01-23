package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "resources")
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "id_module", nullable = false)
    private Long idModule;

    public Resources() {}

    public Resources(String content, Long idModule) {
        this.content = content;
        this.idModule = idModule;
    }
}
