package com.example.end;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FARA_1_1 extends Fragment {


    private String[] X ;
    private static final String N1="name1";


    public FARA_1_1(){

    }
    public static FARA_1_1 obg(String [] A){
        Bundle bundle=new Bundle();
        bundle.putStringArray(N1,A);
        FARA_1_1 ff=new FARA_1_1();
        ff.setArguments(bundle);
        return ff;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.farg_1_1, container, false);
        TextView  T_F_1 = v.findViewById(R.id.t_f_2);
        TextView  T_F_2 = v.findViewById(R.id.t_f_4);
        TextView  T_F_3 = v.findViewById(R.id.t_f_6);
        TextView  T_F_4 = v.findViewById(R.id.t_f_8);
        TextView  T_F_5 = v.findViewById(R.id.t_f_10);
        T_F_1.setText(X[0]);
        T_F_2.setText(X[1]);
        T_F_3.setText(X[2]);
        T_F_4.setText(X[3]);
        T_F_5.setText(X[4]);

        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        X=bundle.getStringArray(N1);
    }
}
//*****************************************************************************************
//*****************************************************************************************

