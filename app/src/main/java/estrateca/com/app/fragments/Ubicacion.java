package estrateca.com.app.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import estrateca.com.app.R;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Ubicacion.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Ubicacion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ubicacion extends Fragment   {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private GoogleMap mapa;

    static final LatLng sucursal1 = new LatLng (19.2464696, -99.10134979999998);
    static final LatLng sucursal2 = new LatLng (19.4029032, -99.1542933);
    static final LatLng sucursal3 = new LatLng (19.3959212, -99.11300890000001);
    static final LatLng sucursal4 = new LatLng (19.301718, -99.1247444);
    static final LatLng sucursal5 = new LatLng (19.304011, -99.18612150000001);
    static final LatLng sucursal6 = new LatLng (19.3952738, -99.13466410000001);
    static final LatLng sucursal7 = new LatLng (19.5524016, -99.14280129999997);
    static final LatLng sucursal8 = new LatLng (19.3307284, -99.1265651);
    static final LatLng sucursal9 = new LatLng (19.2601265, -99.00731350000001);



    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ubicacion.
     */
    // TODO: Rename and change types and number of parameters
    public static Ubicacion newInstance(String param1, String param2) {
        Ubicacion fragment = new Ubicacion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_ubicacion, container, false);
        LocationManager lm = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);




        mapa = ((MapFragment) getFragmentManager().findFragmentById(
                R.id.mapView)).getMap();

        mapa.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mapa.addMarker(new MarkerOptions().position(sucursal1).title("Sucursal 1"));
        mapa.addMarker(new MarkerOptions().position(sucursal2).title("Sucursal central"));
        mapa.addMarker(new MarkerOptions().position(sucursal3).title("Sucursal 3"));
        mapa.addMarker(new MarkerOptions().position(sucursal4).title("Sucursal 4"));
        mapa.addMarker(new MarkerOptions().position(sucursal5).title("Sucursal 5"));
        mapa.addMarker(new MarkerOptions().position(sucursal6).title("Sucursal 6"));
        mapa.addMarker(new MarkerOptions().position(sucursal7).title("Sucursal 7"));
        mapa.addMarker(new MarkerOptions().position(sucursal8).title("Sucursal 8"));
        mapa.addMarker(new MarkerOptions().position(sucursal9).title("Sucursal 9"));
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(sucursal2, 10);
        mapa.animateCamera(update);


        // Google Play Services are available

            // Getting reference to the SupportMapFragment of activity_main.xml

            // Getting GoogleMap object from the fragment


            // Enabling MyLocation Layer of Google Map


        // }
        return rootView;
    }

    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(-33.867, 151.206);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

        map.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        /*try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
