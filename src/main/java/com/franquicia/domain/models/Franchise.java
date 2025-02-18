package com.franquicia.domain.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class Franchise {
    private String franchiseName;
    private List<Subsidiary> subsidiaryList;
}
