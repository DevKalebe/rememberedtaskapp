package br.senai.sp.cotia.rememberedtaskapp.model;

import lombok.Data;

@Data
public class Task {
    private Long idTask;
    private String title;
    private String desc;
    private long dataCreate;
    private long dataPrev;
    private long dataFinish;


}
