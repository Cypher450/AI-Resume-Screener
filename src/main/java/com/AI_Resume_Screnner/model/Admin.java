package com.AI_Resume_Screnner.model;

import lombok.*;
import jakarta.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class Admin extends User{
	
}
