package br.senai.sp.cotia.rememberedtaskapp.fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;

import br.senai.sp.cotia.rememberedtaskapp.R;
import br.senai.sp.cotia.rememberedtaskapp.databinding.FragmentCadSubTarefaBinding;
import br.senai.sp.cotia.rememberedtaskapp.databinding.FragmentCadTarefaBinding;
import br.senai.sp.cotia.rememberedtaskapp.model.Task;


public class CadSubTarefaFragment extends Fragment {
    private FragmentCadSubTarefaBinding binding;
    // variável para task
    private Task task;
    // variável para o dialog da foto
    private AlertDialog dialogPhoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCadSubTarefaBinding.inflate(getLayoutInflater(), container, false);

        if (getArguments() != null){
            // recupera a tarefa do bundle
            task = (Task) getArguments().getSerializable("task");
            // popular as informações da tarefa

        }

        // habilita menu
        setHasOptionsMenu(true);

        // instancia o dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.origin_image);
        String[] opcoes = {getString(R.string.camera), getString(R.string.galery)};
        builder.setItems(opcoes, listenerDialog);
        dialogPhoto = builder.create();

        // listenar do click da imagem
        binding.btImage.setOnClickListener(v -> {
            dialogPhoto.show();
        });

        return binding.getRoot();
    }

    private DialogInterface.OnClickListener listenerDialog = (dialog, i) ->{

    };


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_subtask, menu);
    }
}