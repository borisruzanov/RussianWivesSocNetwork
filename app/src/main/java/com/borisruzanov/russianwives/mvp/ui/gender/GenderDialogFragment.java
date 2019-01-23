package com.borisruzanov.russianwives.mvp.ui.gender;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatDialogFragment;
import com.borisruzanov.russianwives.R;
import com.borisruzanov.russianwives.utils.Consts;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GenderDialogFragment extends MvpAppCompatDialogFragment {

    public static String TAG = "Gender dialog";

    @BindView(R.id.dialog_spinner_gender)
    Spinner genderSpinner;

    public interface GenderListener {
        void setGender(String gender);
    }

    GenderListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof GenderListener) {
            listener = (GenderListener) context;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d =  super.onCreateDialog(savedInstanceState);
        d.setCanceledOnTouchOutside(false);
        return d;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_gender, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.confirm_button_gender)
    public void onConfirmClicked() {
        if (!genderSpinner.getSelectedItem().toString().equals(Consts.DEFAULT)) {
            listener.setGender(genderSpinner.getSelectedItem().toString());
            dismiss();
        }
        else Toast.makeText(getContext(), getString(R.string.order_gender), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

}