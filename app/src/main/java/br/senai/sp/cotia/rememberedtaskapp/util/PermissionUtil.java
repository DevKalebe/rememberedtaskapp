package br.senai.sp.cotia.rememberedtaskapp.util;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtil {
    public static boolean checkPermission(Activity activity, int requestCode, String... permissions){

        List<String> negadas = new ArrayList<>();
        // percorrer as permissões procurando as negadas
        for (String permission : permissions){
            // verifica se está negada
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED){
                negadas.add(permission);
            }
        }

        // se a lista de negadas está vazia, retorna true
        if (negadas.isEmpty()){
            return true;
        }
        // converte a lista em vetor
        String[] permissionsNot = new String[negadas.size()];
        negadas.toArray(permissionsNot);
        ActivityCompat.requestPermissions(activity, permissionsNot, requestCode);
        return false;
    }
}
