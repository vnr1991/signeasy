package com.example.signeasy.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by vaishakhnr on 10/11/17.
 */
@Entity
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "book", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "author"})})
public class Book {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") private Long id;
	@Column(name = "name", length = 50) private String name;
	@Column(name = "author", length = 50) private String author;
	@Column(name = "quantity", length = 50) private Long quantity;
}
