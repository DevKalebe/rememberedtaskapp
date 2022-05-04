package br.senai.sp.cotia.rememberedtaskapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;

@Data
@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    private Long idTask;
    private String title;
    private String desc;
    private long dataCreate;
    private long dataPrev;
    private long dataFinish;

    public boolean isConcluida(){
        return dataFinish != 0;
    }
}
