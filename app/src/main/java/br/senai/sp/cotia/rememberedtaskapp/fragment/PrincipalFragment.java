package br.senai.sp.cotia.rememberedtaskapp.fragment;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

import br.senai.sp.cotia.rememberedtaskapp.R;
import br.senai.sp.cotia.rememberedtaskapp.activity.MainActivity;
import br.senai.sp.cotia.rememberedtaskapp.adapter.TaskAdapter;
import br.senai.sp.cotia.rememberedtaskapp.database.AppDatabase;
import br.senai.sp.cotia.rememberedtaskapp.databinding.FragmentPrincipalBinding;
import br.senai.sp.cotia.rememberedtaskapp.model.Task;


public class PrincipalFragment extends Fragment {
    private FragmentPrincipalBinding binding;
    // variável para a lista
    List<Task> tasks;
    // variável para o adapter
    TaskAdapter adapter;
    // variável para dataBase
    private AppDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // instanciar o binding
        binding = FragmentPrincipalBinding.inflate(getLayoutInflater(), container, false);

        binding.btNewTask.setOnClickListener(v -> {
            NavHostFragment.findNavController
                    (PrincipalFragment.this).navigate(R.id.action_principalFragment_to_cadTarefaFragment);
        });


        // instancia a database
        database = AppDatabase.getDatabase(getContext());

        // define o layout manager do recycler
        binding.recyclerTasks.setLayoutManager(new LinearLayoutManager(getContext()));

        // executar a asynctask
        new ReadTask().execute();

        // retorna a view raiz (root) do binding
        return binding.getRoot();


    }

    class ReadTask extends AsyncTask<Void, Void, List<Task>> {
        @Override
        protected List<Task> doInBackground(Void... voids) {
            // buscar as tarefas e guardar na variável tasks
            tasks = database.getTaskDao().getAll();
            return tasks;
        }

        @Override
        protected void onPostExecute(List<Task> tasks) {

            // instancia o adapter
            adapter = new TaskAdapter(tasks, getContext(), listenerClick);
            // aplica o adapter no recycler
            binding.recyclerTasks.setAdapter(adapter);

            super.onPostExecute(tasks);

        }
    }

    // Listener para o click nas tarefas
    private TaskAdapter.OnTaskClickListener listenerClick = (view, task) -> {

        // variável para "pendurar" a tarefa
        Bundle bundle = new Bundle();
        // "pendura" a tarefa no bundle
        bundle.putSerializable("task",  task);
        // navega para o fragment de detalhes enviando a tarefa no bundle
        NavHostFragment.findNavController
                (PrincipalFragment.this).navigate
                (R.id.action_principalFragment_to_detalheTarefaFragment, bundle);

    };

    // tirando a ActionBar desse fragment

//    public static void esconderActionBar(MainActivity parent) {
//        ActionBarActivity abc = (ActionBarActivity) parent;
//        abc.getSupportActionBar().hide();
//    }
}