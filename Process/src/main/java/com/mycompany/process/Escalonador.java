
package com.mycompany.process;
import java.util.List;

public class Escalonador  {
    
    //Atributos
   private List<Process> listProcess;

    public Escalonador(List<Process> processos ) {
        this.listProcess = processos;
    }
   
   
   //Métodos
   public void addProcess(List<Process> listProcess,Process p1){
       listProcess.add(p1);
   }
   public void escalonadorAdmissao(List<Process> listProcess)
   {
       
   }
   
   public void escalonadorMemoria(List<Process> listProcess)
   {
       
       
   }
   
   public void escalonadorCPU(List<Process> listProcess)
   {
       
   }
   
   public void escalonador(List<Process> listProcess)
   {
       
   }
   public static void main(String[] args)
   {
  
    Process p1= new Process("p1",2,3,15);
   // Process p2= new Process("p2",3,8,125);
   // Process p3= new Process("p3",4,7,35);
   // Process p4= new Process("p4",7,6,45);
   // Process p5= new Process("p5",8,3,65);
   // Process p6= new Process("p6",9,4,85);
    //Process p7= new Process("p7",11,5,95);
    //e1.add(p1);
  
   }
   
    
}
