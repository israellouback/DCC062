
package com.mycompany.process;
import java.util.List;
import java.util.Collections;

public class Escalonador  {
    
    //Atributos
   private static  List<Process> listProcess;

    public Escalonador(List<Process> processos ) {
        this.listProcess = processos;
    }
   
   //Métodos
   public void addProcess(Process p1){
       listProcess.add(p1);
       
   }
   public List<Process> escalonadorAdmissao()
   {
       for(int i=0;i<listProcess.size();i++){
           for(int j=i;j<listProcess.size();j++){
            if (listProcess.get(i).getPriority()< listProcess.get(j).getPriority()){
                Collections.swap(listProcess, i, j);
                    }
            }   
       }
       
       
      return listProcess;
   }
   
   public List<Process> escalonadorMemoria(List <Process> listaProcess)
   {
       int pesoMemory = 3;
       float pesoTime = 1.5f;
        for(int i=0;i<listaProcess.size();i++){
           for(int j=i;j<listaProcess.size();j++){
               if(pesoMemory * listaProcess.get(i).getSize_memory()< pesoMemory * listaProcess.get(j).getSize_memory() && 
                  pesoTime   * listaProcess.get(i).getRuntime()< pesoTime * listaProcess.get(j).getRuntime()){
                 Collections.swap(listaProcess, i, j);
               }
           }
           }
       
         return listaProcess;
   }
   
   public List<Process>  escalonadorCPU(List <Process> listaProcess)
   {
       
    return listProcess;
   }
   
   public List<Process>  escalonador()
   {
       
        return listProcess;
   }
   public  void main(String[] args)
   {
       
    Process p1= new Process("p1",2,3.5f,11);
    Process p2= new Process("p2",3,13.5f,8);
    Process p3= new Process("p3",1,11.5f,9);
    Process p4= new Process("p4",10,18.5f,5);
    Process p5= new Process("p5",5,20.5f,7);
    addProcess(p1);
    addProcess(p2);
    addProcess(p3);
    addProcess(p4);
    addProcess(p5);
    escalonadorAdmissao();
    
 
   } 
}
