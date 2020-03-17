package thu.ct.day04_fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dynamic2 extends Fragment {
    private Button btnAdd;

    @Override
    public void onStart() {
        super.onStart();
        btnAdd = getActivity().findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtNumber1 = getActivity().findViewById(R.id.edtNumber1);
                EditText edtNumber2 = getActivity().findViewById(R.id.edtNumber2);
                int result = Integer.parseInt(edtNumber1.getText().toString()) + Integer.parseInt(edtNumber2.getText().toString());
                TextView txtResult = getActivity().findViewById(R.id.txtResult);
                txtResult.setText("Result = "+result);
            }
        });
    }

    public Dynamic2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic2, container, false);
    }

//    public void clickToSub(View view) {
//        EditText edtNumber1 = getActivity().findViewById(R.id.edtNumber1);
//        EditText edtNumber2 = getActivity().findViewById(R.id.edtNumber2);
//        int result = Integer.parseInt(edtNumber1.getText().toString()) - Integer.parseInt(edtNumber2.getText().toString());
//        TextView txtResult = getActivity().findViewById(R.id.txtResult);
//        txtResult.setText("Result = "+result);
//    }
}
