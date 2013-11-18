
package name.roupsky.geno.project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimpleFragment extends Fragment {

    public static final String ARG_CONTENT_VIEW = "ARG_CONTENT_VIEW";

    public SimpleFragment() {
    }

    public SimpleFragment(int fragmentContent) {
        Bundle args = new Bundle(1);
        args.putInt(ARG_CONTENT_VIEW, fragmentContent);
        setArguments(args);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments().containsKey(ARG_CONTENT_VIEW)) {
            return inflater.inflate(getArguments().getInt(ARG_CONTENT_VIEW), container, false);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
