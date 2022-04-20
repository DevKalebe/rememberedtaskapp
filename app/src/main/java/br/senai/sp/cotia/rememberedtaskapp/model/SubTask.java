package br.senai.sp.cotia.rememberedtaskapp.model;

import lombok.Data;

@Data
public class SubTask {

    private Long idSubTask;
    private String desc;
    private String photo;
    private boolean done;
    private Long idTask;
}
