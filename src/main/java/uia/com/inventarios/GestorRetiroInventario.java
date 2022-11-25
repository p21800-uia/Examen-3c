package uia.com.inventarios;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorRetiroInventario extends ReporteRetiroInventario
    
{
    List<SolicitudRetiroMaterial> items = new ArrayList<SolicitudRetiroMaterial>();


    public GestorRetiroInventario(IRetiroInventario inventario)
    {
        super(inventario);
    }

    public GestorRetiroInventario(String nombre)
    {
        super();
        //this.gestorApartado = new GestorApartado();
    }

    public GestorRetiroInventario() {

    }


    public void serializa(SolicitudRetiroMaterial newSSM, String nom) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(nom), newSSM);
    }




    public List<SolicitudRetiroMaterial> getItems()
    {
        return this.items;
    }


    public void setItems(List<SolicitudRetiroMaterial> items) {
        this.items = items;
    }


    public SolicitudRetiroMaterial agregaSolicitudSalidaMaterial(String nomArchivo, String solicitante, String categoria) throws IOException {
        String id = nomArchivo+"_"+String.valueOf(this.getItems().size()+1)+".json";
        String existencia = "";
        IRetiroInventario inventario=null;
        SolicitudRetiroMaterial newSSM = new SolicitudRetiroMaterial(super.inventario, id, solicitante, categoria);
        return newSSM;
    }

    @Override
    public void print() {

    }


}
