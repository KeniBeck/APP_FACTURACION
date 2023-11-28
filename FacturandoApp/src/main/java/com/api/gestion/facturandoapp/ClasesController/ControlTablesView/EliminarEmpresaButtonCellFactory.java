package com.api.gestion.facturandoapp.ClasesController.ControlTablesView;

import com.api.gestion.facturandoapp.Clases_cls.cls_empresa;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class EliminarEmpresaButtonCellFactory implements Callback<TableColumn<cls_empresa, Void>, TableCell<cls_empresa, Void>> {

    @Override
    public TableCell<cls_empresa, Void> call(final TableColumn<cls_empresa, Void> param) {
        return new TableCell<>() {
            private final Button button = new Button("Eliminar");

            {
                button.setOnAction(event -> {
                    cls_empresa empresa = getTableView().getItems().get(getIndex());
                    eliminarEmpresa(empresa);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        };
    }

    private void eliminarEmpresa(cls_empresa empresa) {
     eliminarEmpresa(empresa);

    }
}

