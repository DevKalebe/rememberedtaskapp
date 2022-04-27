package br.senai.sp.cotia.rememberedtaskapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.senai.sp.cotia.rememberedtaskapp.model.Task;

@Dao
public interface TaskDao {

    @Insert
    void insert (Task t);

    @Update
    void update (Task t);

    @Delete
    void delete(Task t);

    @Query("select * from task")
    List<Task> getAll();
}
