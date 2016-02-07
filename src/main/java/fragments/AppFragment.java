package fragments;

import javafx.fxml.FXMLLoader;
import org.kairos.core.Fragment;

import java.io.IOException;

/**
 * Created by marconi on 6/02/16.
 */
public class AppFragment extends Fragment {

    @Override
    public void onCreateView(FXMLLoader fxmlLoader) {
        fxmlLoader.setLocation(getClass().getResource("app_fragment.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
