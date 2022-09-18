package org.jonathan.domain;

import lombok.Getter;

@Getter
public class Client {

    public Client(String name) {
        if (name == null) throw new IllegalArgumentException("name can't be null");
        this.name = name;
    }

    private String name;

}
