package estrateca.com.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import estrateca.com.app.R;

public class Contactar extends Fragment {

    public static Contactar newInstance(String param1, String param2) {
        Contactar fragment = new Contactar();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public Contactar() {
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
        return inflater.inflate(R.layout.fragment_contactar, container, false);
    }

}
