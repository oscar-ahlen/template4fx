package com.example.template4fx.skin;

import com.example.template4fx.control.dialog.ProgressDialog;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class ProgressDialogSkin
    extends DialogSkin<ProgressDialog>
{
    public ProgressDialogSkin( ProgressDialog dialog )
    {
        super( dialog );
        createOverlay( createDialogSkin() );
    }

    private Node createDialogSkin()
    {
        VBox background = new VBox();
        background.getStyleClass().add( "dialog-background" );

        background.getChildren().addAll( createHeader(), createContent() );
        return background;
    }

    private Node createContent()
    {
        VBox content = new VBox();
        content.setAlignment( Pos.CENTER );
        content.getStyleClass().add( "dialog-content" );

        ProgressBar progressBar = new ProgressBar();
        progressBar.progressProperty().bind( getSkinnable().getTask().progressProperty() );
        progressBar.setMaxWidth( Double.MAX_VALUE );

        Label status = new Label();
        status.textProperty().bind( getSkinnable().getTask().messageProperty() );
        status.setWrapText( true );

        ButtonBar buttonBar = new ButtonBar();

        Button ok = new Button( "Close" );
        ok.setDefaultButton( true );
        ok.setOnAction( event -> getSkinnable().close() );

        ok.disableProperty().bind( getSkinnable().getTask().runningProperty() );

        ok.disableProperty().addListener( ( observable, oldValue, newValue ) -> {
            if ( !newValue )
                Platform.runLater( ok::requestFocus );
        } );

        ButtonBar.setButtonData( ok, ButtonBar.ButtonData.OK_DONE );

        getSkinnable().setFirst( ok );
        getSkinnable().setLast( ok );
        buttonBar.getButtons().add( ok );

        content.getChildren().addAll( progressBar, status, buttonBar );

        Platform.runLater( ok::requestFocus );

        return content;
    }
}
