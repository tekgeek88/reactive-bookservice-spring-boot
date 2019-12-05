package com.javaworld.webflux.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "psapsandgeometries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Psap {

    private String type;

    private Properties properties;

    private Map<String, Object> geometry;

}



