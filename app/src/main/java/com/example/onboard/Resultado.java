package com.example.onboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onboard.databinding.FragmentResultadoBinding;

import java.util.Calendar;


public class Resultado extends Fragment {

    FragmentResultadoBinding binding;
    NavController navController;



    public Resultado() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentResultadoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        int year = Calendario.selectedYear;
        int month = Calendario.selectedMonth;
        int day = Calendario.selectedDay;

        Calendar fecha = Calendar.getInstance();
        fecha.set(year, month, day);

        Calendar hoy = Calendar.getInstance();
        int age = hoy.get(Calendar.YEAR) - fecha.get(Calendar.YEAR);

        if (hoy.get(Calendar.DAY_OF_YEAR) < fecha.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        // Mostrar la edad en el TextView
        String tener = getString(R.string.tener);
        String annos = getString(R.string.annos);
        binding.FragResultadoText.setText(tener + " " + age + " " + annos);




        binding.FragResultadoBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_resultado_to_calendario);
            }
        });

    }
}