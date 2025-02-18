package com.franquicia.domain.models;

import lombok.*;

@Getter
@Setter
@Builder
public class Franchise {
    private String name;
    private List<Subsidiary> subsidiaryList;
}
