package br.senai.sp.cotia.rememberedtaskapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.senai.sp.cotia.rememberedtaskapp.R;
import br.senai.sp.cotia.rememberedtaskapp.databinding.FragmentDetalheTarefaBinding;


public class DetalheTarefaFragment extends Fragment {
    private FragmentDetalheTarefaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // instacia o binding
        binding = FragmentDetalheTarefaBinding.inflate(getLayoutInflater(), container, false);

        // retorna a view raiz
        return binding.getRoot();
    }
}