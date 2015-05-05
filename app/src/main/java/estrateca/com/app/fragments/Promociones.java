package estrateca.com.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import estrateca.com.app.ListViewAdapter;
import estrateca.com.app.R;

public class Promociones extends Fragment {

    ListViewAdapter adapter;

    String[] titulo = new String[]{
            "cupon 1",
            "cupon 2",
            "cupon 3",
            "cupon 4",
            "cupon 5",
    };

    int[] imagenes = {
            R.drawable.cupon1,
            R.drawable.cupon2,
            R.drawable.cupon3,
            R.drawable.cupon4,
            R.drawable.cupon5
    };

    public static Promociones newInstance(String param1, String param2) {
        Promociones fragment = new Promociones();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public Promociones() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_promociones, container, false);

        final ListView lista = (ListView) v.findViewById(R.id.listView1);
        adapter = new ListViewAdapter(getActivity(), titulo, imagenes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getActivity().getApplicationContext(), "presiono " + i, Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getActivity().getApplicationContext(), "presiono LARGO " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Inflate the layout for this fragment
        return v;
    }


}
