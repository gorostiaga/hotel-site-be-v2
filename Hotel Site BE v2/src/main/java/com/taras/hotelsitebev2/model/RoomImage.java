package com.taras.hotelsitebev2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="room_image")
public class RoomImage extends BaseEntity {

    @Column(name = "file_path")
    private String filePath;

    @Column(name="description")
    private String description;

    public RoomImage(Long id, String filePath, String description) {
        super(id);
        this.filePath = filePath;
        this.description = description;
    }
}
