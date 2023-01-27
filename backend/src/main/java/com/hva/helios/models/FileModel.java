package com.hva.helios.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class FileModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name, type;

    private long userId;

    @CreationTimestamp
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss.S")
    private LocalDateTime timestamp;

    @Lob
    private byte[] data;

    public FileModel() {}

    public FileModel(long userId, String name, String type,byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.userId = userId;
    }
    public FileModel(String id, long userId, String name, String type,byte[] data) {
        this(userId, name, type, data);
        this.id = id;
    }

    public static FileModel createSampleFile(String id) {
        FileModel file = new FileModel(
                1L,
                "sample-file.txt",
                "text file",
                new byte[] {}
        );
        file.setId(id);
        return file;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
