package com.example.template4fx;

import com.example.template4fx.component.Component;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FXContext
{
    private final ExecutorService executorService = Executors.newFixedThreadPool( 4 );

    private final Settings settings;

    public FXContext( Settings settings )
    {
        this.settings = settings;
    }

    public Component Load( String fxml, ResourceBundle resources, String css )
        throws IOException
    {
        FXMLLoader loader = new FXMLLoader( getClass().getResource( fxml ) );
        loader.setResources( resources );

        Parent root = loader.load();

        if ( css != null )
            root.getStylesheets().add( css );

        Component component = loader.getController();
        component.setRoot( root );
        component.setContext( this );
        return component;
    }

    public void shutdown()
    {
        executorService.shutdown();
    }

    public ExecutorService getExecutorService()
    {
        return executorService;
    }

    public Settings getSettings()
    {
        return settings;
    }
}
