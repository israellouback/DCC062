
package com.mycompany.process;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Escalonador {

    //Atributos
    private static List<Process> listProcess = new ArrayList<>();
    private int n_process;
    private boolean direcition;

    public Escalonador() {
        Escalonador.listProcess = new ArrayList<>();
        this.direcition = true;
        this.n_process = 0;
    }

    //Métodos
    public static void addProcess(Process p1) {
        listProcess.add(p1);

    }

    public List<Process> escalonadorAdmissao() {
        List<Process> processList = new ArrayList<>();
        for (int i = 0; i < Escalonador.listProcess.size(); i++) {
            for (int j = i; j < Escalonador.listProcess.size(); j++) {
                if (Escalonador.listProcess.get(i).getPriority() < Escalonador.listProcess.get(j).getPriority()) {
                    Collections.swap(Escalonador.listProcess, i, j);
                }
            }
        }

        for (int i = 0; i < Escalonador.listProcess.size() * 0.65; i++) {
            processList.add(Escalonador.listProcess.get(i));
        }
        return processList;
    }

    public List<Process> escalonadorMemoria(List<Process> listaProcess) {
        int pesoMemory = 3;
        float pesoTime = 1.5f;
        for (int i = 0; i < listaProcess.size() - 1; i++) {
            for (int j = 0; j < listaProcess.size() - 1 - i; j++) {
                if (pesoMemory * listaProcess.get(j).getSize_memory() + pesoTime * listaProcess.get(j).getRuntime() > pesoMemory * listaProcess.get(j + 1).getSize_memory() +
                        pesoTime * listaProcess.get(j + 1).getRuntime()) {
                    Collections.swap(listaProcess, j, j + 1);
                }
            }
        }
        List<Process> processList = new ArrayList<>();
        for (int i = 0; i < listaProcess.size() * 0.8; i++) {
            processList.add(listaProcess.get(i));
        }

        return processList;
    }

    public Process escalonadorCPU(List<Process> listProcess) {
        Process p;
        if (listProcess.size() == 0)
            return null;
        if (this.n_process >= listProcess.size()) {
            this.n_process = listProcess.size() - 1;
            this.direcition = false;
        } else if (this.n_process < 0) {
            this.n_process = 0;
            this.direcition = true;
        }
        p = listProcess.get(this.n_process);
        if (this.direcition) {
            this.n_process++;
        } else {
            this.n_process--;
        }
        return p;
    }

    public Process escalonador() {
        List<Process> l1 = escalonadorAdmissao();
        List<Process> l2 = escalonadorMemoria(l1);
        return escalonadorCPU(l2);
    }

    public static void main(String[] args) {

        Escalonador e = new Escalonador();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int p = r.nextInt(0, 10);
            Escalonador.addProcess(new Process("p" + String.valueOf(i), p, r.nextFloat(0.5f, 10f), r.nextInt(5, 20)));
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(Escalonador.listProcess.get(i).getName() + " " +
                    Escalonador.listProcess.get(i).getRuntime() + " " +
                    Escalonador.listProcess.get(i).getSize_memory() + " " +
                    (Escalonador.listProcess.get(i).getRuntime() * 1.5 + Escalonador.listProcess.get(i).getSize_memory() * 3));
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(e.escalonador().getName());
        }

    }
}
