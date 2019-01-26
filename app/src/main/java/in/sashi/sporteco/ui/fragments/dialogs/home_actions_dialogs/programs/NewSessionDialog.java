package in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.programs;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.FocusPointsAdapter;
import in.sashi.sporteco.models.app.FocusPoints;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.EmptyRecyclerView;

public class NewSessionDialog extends DialogFragment {

    private static final String TAG = NewSessionDialog.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV, newSessionIV;
    private TextView addFocusPts;
    private EditText sessionNameET, sessionDescET, focusPtsET;

    private EmptyRecyclerView sessionFocus_ptsRV;
    private TextView emptyText;
    private List<FocusPoints> pointsList = new ArrayList<>();
    private FocusPointsAdapter adapter;

    private FloatingActionButton cameraFAB;
    private Button newSessionDoneBtn;

    private String sessionImgBase64;
    public static final int CAMERA_REQ_CODE = 1001;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_session_dialog, container, false);
        init(view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        newSessionIV = view.findViewById(R.id.newSessionIV);
        sessionNameET = view.findViewById(R.id.sessionNameET);
        sessionDescET = view.findViewById(R.id.sessionDescET);
        focusPtsET = view.findViewById(R.id.focusPtsET);
        addFocusPts = view.findViewById(R.id.addFocusPtsIV);
        sessionFocus_ptsRV = view.findViewById(R.id.sessionFocus_ptsRV);
        emptyText = view.findViewById(R.id.emptyText);
        cameraFAB = view.findViewById(R.id.cameraFAB);
        newSessionDoneBtn = view.findViewById(R.id.newSessionDoneBtn);

        closeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        cameraFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

        setUpFocusPoints();

        addFocusPts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Add FP Ckd", Toast.LENGTH_SHORT).show();
                addPoints();
            }
        });

        newSessionDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void setUpFocusPoints() {
        sessionFocus_ptsRV.setEmptyView(emptyText);
        sessionFocus_ptsRV.setHasFixedSize(true);
        sessionFocus_ptsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void addPoints() {
        String text = focusPtsET.getText().toString();
        if (!TextUtils.isEmpty(text)) {
            Log.d(TAG, "Txt in filter:\t" + text);
            FocusPoints focusPoints = new FocusPoints();
            focusPoints.setTitle(focusPtsET.getText().toString());
            pointsList.add(focusPoints);
            adapter = new FocusPointsAdapter(getActivity(), pointsList);
            sessionFocus_ptsRV.setAdapter(adapter);
            focusPtsET.setText("");
            Log.d(TAG, "List size:\t" + pointsList.size());
        } else {
            Snackbar.make(getActivity().findViewById(android.R.id.content), "Can't Submit Empty Values", Snackbar.LENGTH_SHORT).show();
        }
    }

    private void openCamera() {
        if (Build.VERSION.SDK_INT >= 23) {
            checkPerms();
        } else {
            launchCamera();
        }
    }

    private void checkPerms() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            askPerms();
        } else {
            showChooserDialog();
        }
    }

    private void showChooserDialog() {

        final CharSequence[] items = {"Open From Camera"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Session Image");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (items[i].equals("Open From Camera")) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        launchCamera();
                    }
                }
            }
        });
        builder.show();

    }

    private void askPerms() {
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, CAMERA_REQ_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQ_CODE:
                for (int gr : grantResults) {
                    if (gr == PackageManager.PERMISSION_GRANTED) {
                        showChooserDialog();
                    } else {
                        if (gr == PackageManager.PERMISSION_DENIED) {
                            askPerms();
                            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                                Log.d(TAG, "Camera Rationale");
                                Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "Enable Camera Permission in Settings for the app to work", Snackbar.LENGTH_INDEFINITE);
                                snackbar.setAction("GRANT", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent settingsIntent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), "");
                                        settingsIntent.setData(uri);
                                        startActivityForResult(settingsIntent, 0);
                                    }
                                });
                                snackbar.setActionTextColor(Color.GREEN);
                                snackbar.show();
                            }
                        }
                    }
                }
        }
    }

    private void launchCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQ_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_REQ_CODE:
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                sessionImgBase64 = AppUtils.bitmapToBase64String(bitmap);
                Bitmap decoded = AppUtils.base64StringToBitmap(sessionImgBase64);
                newSessionIV.setImageBitmap(decoded);
                break;
        }
    }
}
