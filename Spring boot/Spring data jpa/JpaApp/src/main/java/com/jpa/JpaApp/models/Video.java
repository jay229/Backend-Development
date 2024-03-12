package com.jpa.JpaApp.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
//@DiscriminatorValue("V")
//@PrimaryKeyJoinColumn(name = "video_id") --> work with JOINED
@Polymorphism(type = PolymorphismType.EXPLICIT)  //to exclude from union with parent
public class Video extends Resource{
    private int length;
}
