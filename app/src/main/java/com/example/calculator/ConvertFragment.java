package com.example.calculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConvertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConvertFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText input;
    Spinner unit;
    TextView km, m, cm, mm, microm, nm, mile, yard, foot, inch;
    public ConvertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConvertFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConvertFragment newInstance(String param1, String param2) {
        ConvertFragment fragment = new ConvertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_convert, container, false);

        input = rootView.findViewById(R.id.input);
        unit = rootView.findViewById(R.id.unit);
        km = rootView.findViewById(R.id.km);
        m = rootView.findViewById(R.id.m);
        cm = rootView.findViewById(R.id.cm);
        mm = rootView.findViewById(R.id.mm);
        microm = rootView.findViewById(R.id.microm);
        nm = rootView.findViewById(R.id.nm);
        mile = rootView.findViewById(R.id.mile);
        yard = rootView.findViewById(R.id.yard);
        foot = rootView.findViewById(R.id.foot);
        inch = rootView.findViewById(R.id.inch);

        String[] arr = {"km", "m", "cm", "mm", "microm", "nm", "mile", "yard", "foot", "inch"};
        unit.setAdapter(new ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, arr));

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update();
            }
        });

        return rootView;
    }

    private void update() {
        if (!input.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()) {
                case "km":
                    setKm(in);
                    break;
                case "m":
                    setKm(in/1000);
                    break;
                case "cm":
                    setKm(in/100000);
                    break;
                case "mm":
                    setKm(in/1000000);
                    break;
                case "microm":
                    setKm(in/1000000000);
                    break;
                case "nm":
                    double d = 1000000 * 1000000;
                    setKm(in/d);
                    break;
                case "mile":
                    setKm(in*1.609);
                    break;
                case "yard":
                    setKm(in/1094);
                    break;
                case "foot":
                    setKm(in/3281);
                    break;
                case "inch":
                    setKm(in/39370);
                    break;
            }
        }
    }

    private void setKm(double km_in) {
        km.setText(String.format("%.2f", km_in));
        m.setText(String.format("%.2f", km_in * 1000));
        cm.setText(String.format("%.2f", km_in * 100000));
        mm.setText(String.format("%.2f", km_in * 1000000));
        microm.setText(String.format("%.2f", km_in * 1000000000));
        nm.setText(String.format("%.2f", km_in * 1000000 * 1000000));
        mile.setText(String.format("%.2f", km_in / 1.609));
        yard.setText(String.format("%.2f", km_in * 1094));
        foot.setText(String.format("%.2f", km_in * 3281));
        inch.setText(String.format("%.2f", km_in * 39370));
    }
}