package com.example.ac2_jpa;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac2_jpa.model.Professor;
import com.example.ac2_jpa.model.Curso;
import com.example.ac2_jpa.model.Especializacao;
import com.example.ac2_jpa.model.Agenda;
import com.example.ac2_jpa.repository.AgendaRepository;
import com.example.ac2_jpa.repository.CursoRepository;
import com.example.ac2_jpa.repository.EspecializacaoRepository;
import com.example.ac2_jpa.repository.ProfessorRepository;

@SpringBootApplication
public class Ac2JpaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired ProfessorRepository professorRepository,
			@Autowired EspecializacaoRepository especializacaoRepository,
			@Autowired AgendaRepository agendaRepository) {
		return args -> {

			System.out.println("*** CADASTRANDO PROFESSOR ***");
			Professor prof1 = new Professor(
				(long) 0,
				"Rafael 1",
				"cpf123",
				"rg123",
				"015123",
				"Sorocaba",
				"sp",
				"123"
			);
			Professor prof2 = new Professor(
				(long) 0,
				"Rafael 2",
				"cpf123",
				"rg123",
				"015123",
				"Votorantim",
				"sp",
				"123"
			);
			Professor prof3 = new Professor(
				(long) 0,
				"Rafael 3",
				"cpf123",
				"rg123",
				"015123",
				"Piedade",
				"sp",
				"123"
			);
			professorRepository.inserir(prof1);
			professorRepository.inserir(prof2);
			professorRepository.inserir(prof3);
			List<Professor> professores = professorRepository.obterTodos();
			
			for (Professor professor : professores) {
				System.out.println(professor.getNome());
			}
			
			System.out.println("*** CADASTRANDO CURSO ***");

			Curso curso1 = new Curso(
				(long) 0,
				"Fisioterapia xyz",
				"Curso de Fisioterapia xyz",
				"350h",
				"Formar um fisioterapeuta xyz",
				"Ementa de fisioterapia xyz"
			);

			Curso curso2 = new Curso(
				(long) 0,
				"Fisioterapia nivel 1",
				"Curso de Fisioterapia nivel 1",
				"300h",
				"Formar um fisioterapeuta nivel 1",
				"Ementa de fisioterapia nivel 1"
			);

			Curso curso3 = new Curso(
				(long) 0,
				"Fisioterapia inicial",
				"Curso de Fisioterapia inicial",
				"250h",
				"Formar um fisioterapeuta inicial",
				"Ementa de fisioterapia inicial"
			);

			cursoRepository.inserir(curso1);
			cursoRepository.inserir(curso2);
			cursoRepository.inserir(curso3);

			List<Curso> cursos = cursoRepository.obterTodos();
			
			for (Curso curso : cursos) {
				System.out.println(curso.getNome());
			}
			
			System.out.println("*** CADASTRANDO ESPECIALIZACAO ***");

			Especializacao especializacao = new Especializacao(
			(long) 0, 
			professorRepository.obterPorId(1), 
			cursoRepository.obterPorId(1));
			Especializacao especializacao2 = new Especializacao(
			(long) 0, 
			professorRepository.obterPorId(1), 
			cursoRepository.obterPorId(2));
			Especializacao especializacao3 = new Especializacao(
			(long) 0, 
			professorRepository.obterPorId(2), 
			cursoRepository.obterPorId(2));
			Especializacao especializacao4 = new Especializacao(
			(long) 0, 
			professorRepository.obterPorId(3), 
			cursoRepository.obterPorId(1));
			Especializacao especializacao5 = new Especializacao(
			(long) 0, 
			professorRepository.obterPorId(3), 
			cursoRepository.obterPorId(3));

			especializacaoRepository.inserir(especializacao);
			especializacaoRepository.inserir(especializacao2);
			especializacaoRepository.inserir(especializacao3);
			especializacaoRepository.inserir(especializacao4);
			especializacaoRepository.inserir(especializacao5);

			List<Especializacao> especializacoes = especializacaoRepository.obterTodos();
			
			for (Especializacao espec : especializacoes) {
				System.out.println(espec.getProfessor().getNome());
				System.out.println(espec.getCurso().getNome());
			}

			System.out.println("*** CADASTRANDO AGENDA ***");

			Date data = new Date();

			Agenda agenda = new Agenda(
				(long) 0,
				data,
				data,
				"19h",
				"22h",
				"Sorocaba",
				"sp",
				"123",
				professorRepository.obterPorId(1),
				cursoRepository.obterPorId(1)
			);

			agendaRepository.inserir(agenda);

			List<Agenda> agendas = agendaRepository.obterTodos();
			
			for (Agenda ag : agendas) {
				System.out.println(ag.getCurso().getNome());
				System.out.println(agenda.getProfessor().getNome());
				System.out.println(agenda.getDataInicio());
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac2JpaApplication.class, args);
	}

}
