import fragments.AppFragment;
import javafx.fxml.FXML;
import org.kairos.Toolbar;
import org.kairos.core.Activity;
import org.kairos.core.FragmentTransaction;

/**
 * Created by marconi on 31/01/16.
 */
public class AppActivity extends Activity{
    @FXML
    Toolbar toolbar;

    @Override
    public void onCreate() {
        super.onCreate();
        setContentView(getClass().getResource("app_activity.fxml"));

        toolbar.setTitle("App Activity");
        toolbar.setDisplayHomeAsUpEnabled(true);

        setActionBar(toolbar);

        // attaching a fragment :)
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        transaction.add("content",new AppFragment());
        transaction.commit();
    }
}
