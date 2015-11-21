package br.unip.alarmeremedio.Alarme.POJO;

import java.io.Serializable;

public class Medicamentos implements Serializable

{
   private static final long serialVersionUID = 1L;

   private long id;
   private String nomeMedicamento;
   private double qtdMedi;
   private String formaFarma;
   private int horaInicio;
   private String periodo;
   private int quatDias_Mes;
   private boolean mes;
   private boolean dias;
   private boolean usoContinuo;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getNomeMedicamento() {
      return nomeMedicamento;
   }

   public void setNomeMedicamento(String nomeMedicamento) {
      this.nomeMedicamento = nomeMedicamento;
   }


   public double getQtdMedi() {
      return qtdMedi;
   }

   public void setQtdMedi(double qtdMedi) {
      this.qtdMedi = qtdMedi;
   }

   public String getFormaFarma() {
      return formaFarma;
   }

   public void setFormaFarma(String formaFarma) {
      this.formaFarma = formaFarma;
   }

   public int getHoraInicio() {
      return horaInicio;
   }

   public void setHoraInicio(int horaInicio) {
      this.horaInicio = horaInicio;
   }

   public String getPeriodo() {
      return periodo;
   }

   public void setPeriodo(String periodo) {
      this.periodo = periodo;
   }

   public int getQuatDias_Mes() {
      return quatDias_Mes;
   }

   public void setQuatDias_Mes(int quatDias_Mes) {
      this.quatDias_Mes = quatDias_Mes;
   }

   public boolean isMes() {
      return mes;
   }

   public void setMes(boolean mes) {
      this.mes = mes;
   }

   public boolean isDias() {
      return dias;
   }

   public void setDias(boolean dias) {
      this.dias = dias;
   }

   public boolean isUsoContinuo() {
      return usoContinuo;
   }

   public void setUsoContinuo(boolean usoContinuo) {
      this.usoContinuo = usoContinuo;
   }
}
