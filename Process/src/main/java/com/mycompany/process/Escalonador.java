
package com.mycompany.process;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Escalonador  {
    
    //Atributos
   private static  List<Process> listProcess = new ArrayList<>();

    public Escalonador(List<Process> processos ) {
        this.listProcess = processos;
    }
   
   //Métodos
   public static void addProcess(Process p1){
       listProcess.add(p1);
       
   }
   public static List<Process> escalonadorAdmissao()
   {
       for(int i=0;i<listProcess.size();i++){
           for(int j=i;j<listProcess.size();j++){
            if (listProcess.get(i).getPriority() < listProcess.get(j).getPriority()){
                Collections.swap(listProcess, i, j);
                    }
            }   
       }

       for(int i = 0; i < 10; i++){
            System.out.println(listProcess.get(i).getPriority());
            }
       
       
      return listProcess;
   }
   
   public static List<Process> escalonadorMemoria(List <Process> listaProcess)
   {
       int pesoMemory = 3;
       float pesoTime = 1.5f;
        for(int i=0;i<listaProcess.size() - 1;i++){
           for(int j=0;j<listaProcess.size() - 1 - i;j++){
               if(pesoMemory * listaProcess.get(j).getSize_memory() + pesoTime * listaProcess.get(j).getRuntime() > pesoMemory * listaProcess.get(j+1).getSize_memory() + 
                  pesoTime   * listaProcess.get(j + 1).getRuntime()){
                 Collections.swap(listaProcess, j, j + 1);
               }
           }
           }
           
           for(int i = 0; i < 5; i++){
            System.out.println(listProcess.get(i).getRuntime() + " | " + listProcess.get(i).getSize_memory());
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
   public static void main(String[] args)
   {
       
    Process p1= new Process("p1",2,3.5f,11);
    Process p2= new Process("p2",3,13.5f,8);
    Process p3= new Process("p3",1,11.5f,9);
    Process p4= new Process("p4",10,18.5f,5);
    Process p5= new Process("p5",5,20.5f,7);
    Process p6= new Process("p6",4,3.5f,11);
    Process p7= new Process("p7",5,13.5f,8);
    Process p8= new Process("p8",6,11.5f,9);
    Process p9= new Process("p9",11,18.5f,5);
    Process p10= new Process("p10",15,20.5f,7);

    addProcess(p1);
    addProcess(p2);
    addProcess(p3);
    addProcess(p4);
    addProcess(p5);
    addProcess(p6);
    addProcess(p7);
    addProcess(p8);
    addProcess(p9);
    addProcess(p10);

    escalonadorAdmissao();
    
    //escalonadorMemoria(listProcess);
 
   } 
}
