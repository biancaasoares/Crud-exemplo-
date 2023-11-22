package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    Conexao conexao = new Conexao();

    Connection connection = conexao.getConnection();

    public void listarFuncionario() throws SQLException {

        Statement statement = connection.createStatement();
        String queryList = "select * from funcionarios";

        ResultSet resultSet = statement.executeQuery(queryList);

        Funcionario funcionario = new Funcionario();
        while (resultSet.next()){
            funcionario.setIdFuncionario(resultSet.getInt("id_funcionario"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setCargo(resultSet.getString("departamento"));
            funcionario.setSalario(resultSet.getDouble("salario"));

            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getCargo());
            System.out.println(funcionario.getDepartamento());
            System.out.println(funcionario.getDepartamento());
            System.out.println(funcionario.getSalario());
            System.out.println(" ------------------------------ ");

        }

    }

    public void editarFuncionario (String nome, double salario) throws SQLException {
        Statement statement = connection.createStatement();

        String queryUpdate = "update funcionarios set salario = " + salario + " where nome = '" + nome + "'";

        statement.executeUpdate(queryUpdate);
        System.out.println("dados alterados com sucesso!!");

    }

    public void deletarFuncionario(String nome) throws SQLException {
        Statement statement = connection.createStatement();
        String queryDelete = "Delete from funcionarios where nome = '" + nome + "'";
        statement.executeUpdate(queryDelete);

        System.out.println(" funcionário " + nome + " deletado com sucesso!!");



    }

    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException {
        Statement statement = connection.createStatement();
        String queryCadastro = "INSERT INTO funcionarios (id_funcionario, nome, cargo, departamento, salario)values (" +
                funcionario.getIdFuncionario() + ",'" + funcionario.getNome() + "','" + funcionario.getCargo() + "','" +
                funcionario.getDepartamento() + "'," + funcionario.getSalario() + ")";

        statement.executeUpdate(queryCadastro);
        System.out.println("Funcionário cadastrado com sucesso!!");


    }

    public void consultarFuncionario(String nome) throws SQLException {
        Statement statement = connection.createStatement();

        String queryConsulta = "select * from funcionarios where nome = '" + nome + "'";

        ResultSet resultSet = statement.executeQuery(queryConsulta);

        List<Funcionario> listConsulta = new ArrayList<>();


        while (resultSet.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setIdFuncionario(resultSet.getInt("id_funcionario"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setCargo(resultSet.getString("cargo"));
            funcionario.setDepartamento(resultSet.getString("departamento"));
            funcionario.setSalario(resultSet.getDouble("salario"));

            listConsulta.add(funcionario);
        }

        for (Funcionario funcionario : listConsulta) {
            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getCargo());
            System.out.println(funcionario.getDepartamento());
            System.out.println(funcionario.getSalario());
            System.out.println("--------------------------------");

        }
    }
}
