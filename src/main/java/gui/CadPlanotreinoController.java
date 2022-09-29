package gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Cliente;
import models.Exercicio;
import javafx.scene.Parent;
import javafx.scene.Scene;
import models.Treino;
import models.Usuario;
import negocio.ServidorAcademia;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadPlanotreinoController implements Initializable {

@FXML
private Button btnVoltar;
@FXML
private Button btnCadastrar;
@FXML
private Button btnAdicionar;
@FXML private Spinner<Integer> intervalo;
@FXML private Spinner<Integer> series;
@FXML private Spinner<Integer> repeticoes;
@FXML private Spinner<Integer> duracao;

@FXML
private ListView<Treino> lvTreinos;
@FXML
private ListView<Exercicio> lvExercicios;
@FXML
private ListView<Usuario> lvClientes;
@FXML
private DatePicker dpDataIni;
@FXML
private ObservableList<Exercicio> observableListExercicio;
@FXML
private ObservableList<Usuario> observableListCliente;
@FXML
private List<Exercicio> listExercicios = new ArrayList<>();
@FXML
private List<Usuario>  listClientes = new ArrayList<>();

    ServidorAcademia servidor =  ServidorAcademia.getInstance();
public void initialize(URL location, ResourceBundle resources) {

    carregarListaExercicio();
    carregarListaClientes();

    SpinnerValueFactory<Integer> valueFactoryRepeticoes = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10);
    SpinnerValueFactory<Integer> valueFactorySeries = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10);
    SpinnerValueFactory<Integer> valueFactoryDuracao = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10);
    SpinnerValueFactory<Integer> valueFactoryIntervalo = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,5);

    valueFactoryIntervalo.setValue(1);
    valueFactoryDuracao.setValue(1);
    valueFactoryRepeticoes.setValue(1);
    valueFactorySeries.setValue(1);

    intervalo.setValueFactory(valueFactoryIntervalo);
    series.setValueFactory(valueFactorySeries);
    duracao.setValueFactory(valueFactoryDuracao);
    repeticoes.setValueFactory(valueFactoryRepeticoes);



}
public void onBtnVoltarClick(ActionEvent event) throws IOException {
    Stage stage;
    Parent root;

    stage = (Stage) btnVoltar.getScene().getWindow();
    root = FXMLLoader.load(getClass().getResource("personal.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
public void onBtnAdicionarClick(ActionEvent event) throws IOException {

}
public void onBtnCadastrarClick(ActionEvent event) throws IOException {
}

    public void carregarListaExercicio(){
        Usuario  cliente = lvClientes.getSelectionModel().getSelectedItem();
        listExercicios = servidor.listarExercicioCliente((Cliente) cliente);
        observableListExercicio = FXCollections.observableArrayList(listExercicios);
        lvExercicios.setItems(observableListExercicio);
    }
    public void carregarListaClientes(){
        List<Usuario> usuario = servidor.usuarioListar();
        for (int i = 0; i< usuario.size(); i++){
            if( usuario.get(i) instanceof Cliente){
                listClientes.add(usuario.get(i));
            }
        }

        observableListCliente = FXCollections.observableArrayList(listClientes);
        lvClientes.setItems(observableListCliente);

    }




}

