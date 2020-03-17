package thu.ct.day07_tabfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment1 extends Fragment {


    public TabFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_fragment1, container, false);
        Bundle bundle = getArguments();
        TextView txtResult = view.findViewById(R.id.txtResult);
        if (bundle.getString("result") != null) {
            txtResult.setText(bundle.getString("result"));
        } else {
            txtResult.setText(bundle.getString("default"));
        }
        return view;
    }

}
