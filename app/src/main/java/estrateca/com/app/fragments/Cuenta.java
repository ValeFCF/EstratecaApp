package estrateca.com.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import estrateca.com.app.R;

public class Cuenta extends Fragment {

    public static Cuenta newInstance(String param1, String param2) {
        Cuenta fragment = new Cuenta();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public Cuenta() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuenta, container, false);
    }

}
