package tests;

import java.time.LocalDate;
import java.util.List;

import model.Departamento;
import model.Empregado;
import persistent.DAO;
import persistent.DepartamentoDAO;
import persistent.EmpregadoDAO;

public class TesteBD {

	public static void main(String[] args) {
		EmpregadoDAO daoemp = new EmpregadoDAO();
		
		Empregado e = daoemp.buscar(1);
		System.out.println(e.toString()+ "\n" + e.getDepartamento());
	}
}
