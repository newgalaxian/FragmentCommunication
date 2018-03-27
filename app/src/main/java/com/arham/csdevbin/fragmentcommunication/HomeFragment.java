package com.arham.csdevbin.fragmentcommunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button button, buttonfrag;
    EditText editText;
    OnMessageReadListener onMessageReadListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnMessageReadListener {
        public void onMessageRead(String message);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        editText = view.findViewById(R.id.editText);
        buttonfrag = view.findViewById(R.id.button);

       /* button = view.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.frag_container, new FirstkFragment(), null)
                        .addToBackStack(null)
                        .commit();

            }
        });*/

        buttonfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = editText.getText().toString();
                onMessageReadListener.onMessageRead(message);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;

        try {
            onMessageReadListener = (OnMessageReadListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must override onMessageRead... ");
        }
    }
}
