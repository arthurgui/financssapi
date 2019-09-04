package com.financssapi.model;

import java.util.Date;

public class DataPesquisa {

    private Date dataInicio;
    private Date dataFim;

    public DataPesquisa() {
    }

    public DataPesquisa(Date dataInicio, Date dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
