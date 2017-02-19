package fragments;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.kairos.core.Fragment;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Felioe} on 19/02/2017.
 */
public class DetailsFragment extends Fragment {
    @FXML
    private Label label;
    @FXML

    private StackPane card;

    @FXML
    private HBox controlsContainer;

    private HashMap data;

    @Override
    public void onCreateView(FXMLLoader loader) {

        loader.setLocation(getClass().getResource("details_fragment.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        controlsContainer.setVisible(false);
        controlsContainer.setManaged(false);
        controlsContainer.setOpacity(0);

        data = getArguments();

        label.setText(data.get("text").toString());

        card.setTranslateX(((double)data.get("x")) - card.getLayoutX());
        card.setTranslateY(((double)data.get("y")) - card.getLayoutY());
        card.setPrefWidth(((double)data.get("w")));
        card.setPrefHeight(((double)data.get("h")));

        Pane parent = (Pane) getParent();

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(300),
                new KeyValue(card.translateXProperty(), 0, Interpolator.EASE_OUT),
                new KeyValue(card.translateYProperty(), 0,Interpolator.EASE_OUT),
                new KeyValue(card.prefWidthProperty(), parent.getWidth(),Interpolator.EASE_OUT),
                new KeyValue(card.prefHeightProperty(), parent.getHeight(),Interpolator.EASE_OUT)
        ));

        animation.setOnFinished(event -> {
            controlsContainer.setVisible(true);
            controlsContainer.setManaged(true);
            FadeTransition transition = new FadeTransition(Duration.millis(150), controlsContainer);
            transition.setFromValue(0);
            transition.setToValue(1);
            transition.play();
        });
        animation.play();
    }

    public void backTransition() {

        FadeTransition transition = new FadeTransition(Duration.millis(150), controlsContainer);
        transition.setFromValue(1);
        transition.setToValue(0);

        transition.setOnFinished(event -> {

            controlsContainer.setVisible(false);
            controlsContainer.setManaged(false);

            Timeline animation  = new Timeline(new KeyFrame(Duration.millis(300),
                    new KeyValue(card.translateXProperty(),((double)data.get("x")) - card.getLayoutX()),
                    new KeyValue(card.translateYProperty(), ((double)data.get("y")) - card.getLayoutY()),
                    new KeyValue(card.prefWidthProperty(), ((double)data.get("w"))),
                    new KeyValue(card.prefHeightProperty(),((double)data.get("h")))
            ));

            animation.setOnFinished(event1 -> {
                getActivity().onBackPressed();
            });

            animation.play();
        });

        transition.play();

    }
}
