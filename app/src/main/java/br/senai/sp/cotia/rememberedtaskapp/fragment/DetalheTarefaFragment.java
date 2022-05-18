package br.senai.sp.cotia.rememberedtaskapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;

import br.senai.sp.cotia.rememberedtaskapp.R;
import br.senai.sp.cotia.rememberedtaskapp.databinding.FragmentDetalheTarefaBinding;
import br.senai.sp.cotia.rememberedtaskapp.model.Task;


public class DetalheTarefaFragment extends Fragment {
    private FragmentDetalheTarefaBinding binding;

    // variável para task
    Task task;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // instacia o binding
        binding = FragmentDetalheTarefaBinding.inflate(getLayoutInflater(), container, false);

        binding.btNovaSubTarefa.setOnClickListener(v -> {
            NavHostFragment.findNavController
                    (DetalheTarefaFragment.this).navigate(R.id.action_detalheTarefaFragment_to_cadSubTarefaFragment);
        });

        // verificar se foi passado algo no bundle
        if (getArguments() != null){
            // recupera a tarefa do bundle
            task = (Task) getArguments().getSerializable("task");
            // popular as informações da tarefa
            binding.titleDetalhe.setText(task.getTitle());
            binding.descriptionDetalhe.setText(task.getDesc());

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            binding.dataDetalhe.setText(format.format(task.getDataPrev()));
        }

        // retorna a view raiz
        return binding.getRoot();
    }


}