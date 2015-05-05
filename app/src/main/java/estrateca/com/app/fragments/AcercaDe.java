package estrateca.com.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import estrateca.com.app.R;

public class AcercaDe extends Fragment {

    public static AcercaDe newInstance(Bundle args) {
        AcercaDe fragment = new AcercaDe();

        fragment.setArguments(args);
        return fragment;
    }

    public AcercaDe() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acerca_de, container, false);
    }


}
