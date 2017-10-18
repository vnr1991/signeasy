package com.example.signeasy.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by vaishakhnr on 10/18/17.
 */
@Entity
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "member")
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") private Long id;
	@Column(name = "name", length = 50) private String name;
	@Column(name = "subscribed") private boolean subscribed;
}
