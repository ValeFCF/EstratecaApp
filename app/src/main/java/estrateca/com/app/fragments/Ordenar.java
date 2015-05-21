package estrateca.com.app.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import estrateca.com.app.ListViewAdapter;

import estrateca.com.app.R;


public class Ordenar extends Fragment {
    private CharSequence mTitle;
    ListViewAdapter adapter;
    String[] titulo = new String[]{
            "cupon 1",
            "cupon 2",
            "cupon 3",
            "cupon 4",
            "cupon 5",
    };


    int[] imagenes = {
            R.drawable.platillo1,
            R.drawable.platillo2,
            R.drawable.platillo3,
            R.drawable.platillo4,
            R.drawable.platillo5
    };
    public static Ordenar newInstance(String param1, String param2) {
        Ordenar fragment = new Ordenar();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public Ordenar() {
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
        View v =  inflater.inflate(R.layout.fragment_ordenar, container, false);


        final ListView lista = (ListView) v.findViewById(R.id.listView);

        adapter = new ListViewAdapter(getActivity(),titulo, imagenes,2);
        lista.setAdapter(adapter);



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            FragmentManager fragmentManager =  getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = new Fragment();
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                fragment = new OrdenaPedir(i);
                fragmentTransaction.replace(R.id.vale_holder_container, fragment);
                fragmentTransaction.commit();

            }

        });


    return v;
    }

}
