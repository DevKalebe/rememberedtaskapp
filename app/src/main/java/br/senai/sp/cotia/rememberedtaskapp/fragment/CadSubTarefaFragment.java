package br.senai.sp.cotia.rememberedtaskapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.senai.sp.cotia.rememberedtaskapp.R;
import br.senai.sp.cotia.rememberedtaskapp.databinding.FragmentCadSubTarefaBinding;
import br.senai.sp.cotia.rememberedtaskapp.databinding.FragmentCadTarefaBinding;


public class CadSubTarefaFragment extends Fragment {
    private FragmentCadSubTarefaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCadSubTarefaBinding.inflate(getLayoutInflater(), container, false);

        return binding.getRoot();
    }
}