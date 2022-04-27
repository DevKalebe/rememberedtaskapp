package br.senai.sp.cotia.rememberedtaskapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.senai.sp.cotia.rememberedtaskapp.model.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    // variável para acessar a database
    private static AppDatabase database;
    // método para TaskDao
    public abstract TaskDao getTaskDao();

    public static  AppDatabase getDatabase(Context context){
        // verifica se a dataBase é nula
        if (database == null){
            // instacia a database
            database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "todolist").build();
        }

        // retorna a database
        return database;
    }
}
