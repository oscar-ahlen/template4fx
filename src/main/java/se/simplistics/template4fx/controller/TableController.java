package se.simplistics.template4fx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import se.simplistics.template4fx.FXClient;
import se.simplistics.template4fx.model.Person;
import se.simplistics.template4fx.util.FXUtils;

import java.io.IOException;

public class TableController
{
    @FXML
    private TabPane tabPane;

    public void initialize()
    {
        try
        {
            addTab( "Tab 1" );
            addTab( "Tab 2" );
            addTab( "Tab 3" );
        }
        catch ( IOException exc )
        {
            exc.printStackTrace();
        }
    }

    public void addTab()
    {
        try
        {
            addTab( "New Folder" );
        }
        catch ( IOException exc )
        {
            exc.printStackTrace();
        }
    }

    public void alertInfo()
    {
        FXUtils.showInfo( "Information header", "This is an information alert dialog" );
    }

    public void alertWarning()
    {
        FXUtils.showWarning( "Warning header", "This is a warning alert dialog" );
    }

    public void alertError()
    {
        FXUtils.showError( "Error header", "This is an error alert dialog" );
    }

    private void addTab( String title )
        throws IOException
    {
        Tab tab = new Tab();
        tab.setText( title );

        Image image;
        ImageView imageView = new ImageView();

        if ( FXClient.getStringProperty( "stylesheet" ).equals( "/css/template4fx-light.css" ) )
        {
            image = new Image( "icons/24/ic_folder_open_black_24dp.png" );
        }
        else
        {
            image = new Image( "icons/24/ic_folder_open_white_24dp.png" );
        }

        imageView.setFitWidth( 24 );
        imageView.setFitHeight( 24 );
        imageView.setImage( image );
        tab.setGraphic( imageView );

        ScrollPane scrollPane = FXMLLoader.load( getClass().getResource( "/fxml/fragment/table_fragment.fxml" ),
                                                 FXClient.locale );

        TableView table = (TableView) scrollPane.getContent();
        ObservableList<Person> tableList = FXCollections.observableArrayList();
        tableList.add( new Person( "Jacob", "Smith", "jacob.smith@example.com" ) );
        tableList.add( new Person( "Isabella", "Johnson", "isabella.johnson@example.com" ) );
        tableList.add( new Person( "Ethan", "Williams", "ethan.williams@example.com" ) );
        tableList.add( new Person( "Emma", "Jones", "emma.jones@example.com" ) );
        tableList.add( new Person( "Michael", "Brown", "michael.brown@example.com" ) );
        tableList.add( new Person( "Jacob", "Smith", "jacob.smith@example.com" ) );
        tableList.add( new Person( "Isabella", "Johnson", "isabella.johnson@example.com" ) );
        tableList.add( new Person( "Ethan", "Williams", "ethan.williams@example.com" ) );
        tableList.add( new Person( "Emma", "Jones", "emma.jones@example.com" ) );
        tableList.add( new Person( "Michael", "Brown", "michael.brown@example.com" ) );
        tableList.add( new Person( "Jacob", "Smith", "jacob.smith@example.com" ) );
        tableList.add( new Person( "Isabella", "Johnson", "isabella.johnson@example.com" ) );
        tableList.add( new Person( "Ethan", "Williams", "ethan.williams@example.com" ) );
        tableList.add( new Person( "Emma", "Jones", "emma.jones@example.com" ) );
        tableList.add( new Person( "Michael", "Brown", "michael.brown@example.com" ) );
        table.setItems( tableList );

        tab.setContent( scrollPane );
        ( (TableView<Person>) scrollPane.getContent() ).getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE );

        tabPane.getTabs().add( tab );
    }
}