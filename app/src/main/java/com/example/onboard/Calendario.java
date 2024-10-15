package com.example.onboard;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.onboard.databinding.FragmentCalendarioBinding;

import java.util.Calendar;


public class Calendario extends Fragment {

    FragmentCalendarioBinding binding;
    NavController navController;

    public static int selectedYear;
    public static int selectedMonth;
    public static int selectedDay;

    public Calendario() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCalendarioBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        // Obtener la fecha actual
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                binding.FechaNacText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                selectedYear = year;
                selectedMonth = month;
                selectedDay = dayOfMonth;
            }

        };

        DatePickerDialog calendario = new DatePickerDialog(getContext(), dateSetListener, year, month, dayOfMonth);
        calendario.show();



        binding.FragCalendarioBut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_calendario_to_resultado);

            }
        });
    }
}